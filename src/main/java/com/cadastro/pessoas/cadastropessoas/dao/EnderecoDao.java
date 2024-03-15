package com.cadastro.pessoas.cadastropessoas.dao;

import com.cadastro.pessoas.cadastropessoas.model.Endereco;

import javax.ejb.Stateful;
import java.io.Serializable;

@Stateful
public class EnderecoDao<T> extends DaoFactory implements Serializable {

    public EnderecoDao(){
        super();

    }
}
