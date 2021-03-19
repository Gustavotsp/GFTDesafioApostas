package com.gft.desafio.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity (name="usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    
    private String email;
    
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Aposta> apostas;

    //Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Aposta> getApostas() {
		return apostas;
	}

	public void setApostas(Set<Aposta> apostas) {
		this.apostas = apostas;
	}
}
