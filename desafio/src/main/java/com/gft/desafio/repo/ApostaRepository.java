package com.gft.desafio.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.desafio.models.Aposta;
import com.gft.desafio.models.Usuario;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Integer>{
	
	public List<Aposta> findByUsuario(Usuario usuario);

}
