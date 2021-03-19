package com.gft.desafio.facade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gft.desafio.exception.ApostaNaoEncontradaException;
import com.gft.desafio.models.Aposta;
import com.gft.desafio.models.Usuario;
import com.gft.desafio.repo.ApostaRepository;
import com.gft.desafio.repo.UsuarioRepository;

@Transactional
@Service
public class ApostaServiceFacadeImpl implements ApostaServiceFacade{
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@Autowired 
	private ApostaRepository apostaRepository;

	/**
    * {@inheritDoc}
    */
	@Override
	public String adicionarAposta(String email) {
		Aposta aposta = new Aposta();
		aposta.setNumeroAposta(this.gerarApostaAleatoria());
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		//Salva o usuário, caso não exista um no banco
		if(usuario == null) {
			usuario = new Usuario();
			usuario.setEmail(email);
			usuarioRepository.save(usuario);
		}
		
		aposta.setUsuario(usuario);
		apostaRepository.save(aposta);
		
		return aposta.getNumeroAposta();
	}

	/**
    * {@inheritDoc}
    */
	@Override
	public String gerarApostaAleatoria() {
		return formatarApostas(gerarListIntegerApostas());
	}

	/**
    * {@inheritDoc}
    */
	@Override
	public List<Aposta> listarApostasPorEmail(String email) throws ApostaNaoEncontradaException {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario == null) {
			throw new ApostaNaoEncontradaException("Aposta não encontrada para o email: " + email);
		}
		return apostaRepository.findByUsuario(usuario);
	}
	
	/**
    * Gera uma lista de Integer com 6 números não repetidos em uma lista, com um range de 1 a 60
    */
	private List<Integer> gerarListIntegerApostas(){
		Random r = new Random();
		List<Integer> listaNumerosAleatorios = new ArrayList<Integer>();
		
		while (listaNumerosAleatorios.size() < 6) {
			Integer numeroGerado = r.nextInt(60)+1;
			if(!listaNumerosAleatorios.contains(numeroGerado)) {
				listaNumerosAleatorios.add(numeroGerado);
			}
		}
		Collections.sort(listaNumerosAleatorios);
		
		return listaNumerosAleatorios;
	}
	
	/**
    * Formata uma lista de Integer para que fique no formato "X-X-X-X-X-X"
    */
	private String formatarApostas(List<Integer> apostasNaoFormatadas) {
		String aposta = "";
		for (int i = 0; i < apostasNaoFormatadas.size(); i++) {
			if(i == 0) {
				aposta = String.valueOf(apostasNaoFormatadas.get(i));
			} else {
				aposta = aposta.concat(" - " + String.valueOf(apostasNaoFormatadas.get(i)));
			}
		}
		return aposta;
	}

}
