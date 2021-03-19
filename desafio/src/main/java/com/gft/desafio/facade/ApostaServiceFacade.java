package com.gft.desafio.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gft.desafio.exception.ApostaNaoEncontradaException;
import com.gft.desafio.models.Aposta;

/**
 * Classe de serviço de apostas
 *
 */
@Service
public interface ApostaServiceFacade {
	
	/**
	 * Gera uma proposta aleatória e adiciona ao usuário do email fornecido. Adiciona um novo usuário, caso o mesmo não exista.
	 * @param String email - email o qual a aposta será adicionada
	 * @return String aposta - aposta aleatória gerada
	 */
	public String adicionarAposta(String email);
	
	/**
	 * Gera uma proposta aleatória
	 * @return String aposta - aposta aleatória gerada
	 */
	public String gerarApostaAleatoria();
	
	/**
	 * Lista todas as apostas a partir de um email fornecido
	 * @param String email - email fornecido para buscar suas apostas
	 * @return List<Aposta> listaApostas - lista de apostas encontradas
	 * @throws ApostaNaoEncontradaException - exception caso não haja apostas feitas para o email fornecido
	 */
	public List<Aposta> listarApostasPorEmail(String email) throws ApostaNaoEncontradaException;
}
