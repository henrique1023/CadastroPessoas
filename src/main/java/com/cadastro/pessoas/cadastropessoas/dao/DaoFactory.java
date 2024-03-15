package com.cadastro.pessoas.cadastropessoas.dao;

import com.cadastro.pessoas.cadastropessoas.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class DaoFactory  {
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancopessoa");

	public static PessoaDao criaPessoa(){
		return new PessoaDao(emf);
	}
}
