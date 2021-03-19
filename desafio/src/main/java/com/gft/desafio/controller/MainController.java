package com.gft.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gft.desafio.exception.ApostaNaoEncontradaException;
import com.gft.desafio.facade.ApostaServiceFacade;
import com.gft.desafio.models.Aposta;

@Controller 
@RequestMapping(path="/apostas") 
public class MainController {
	
	@Autowired 
	private ApostaServiceFacade apostaServiceFacade;

	/**
	* Gera uma proposta aleatória e adiciona ao usuário do email fornecido. Adiciona um novo usuário, caso o mesmo não exista.
	* @param String email - email o qual a aposta será adicionada
	* @return String aposta - aposta aleatória gerada
	*/
	@PostMapping(path="/adicionarAposta") 
	@ResponseBody
	public String adicionarAposta (@RequestParam String email) {
	  return apostaServiceFacade.adicionarAposta(email);
	}
	
	/**
	 * Lista todas as apostas a partir de um email fornecido
	 * @param String email - email fornecido para buscar suas apostas
	 * @return List<Aposta> listaApostas - lista de apostas encontradas
	 * @throws ApostaNaoEncontradaException - exception caso não haja apostas feitas para o email fornecido
	 */
	@GetMapping(path="/obterApostasPorEmail")
	@ResponseBody
	public List<Aposta> obterApostasPorEmail(@RequestParam String email) throws ApostaNaoEncontradaException {
	  return apostaServiceFacade.listarApostasPorEmail(email);
	}
}
