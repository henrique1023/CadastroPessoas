package com.cadastro.pessoas.cadastropessoas.dao;

import com.cadastro.pessoas.cadastropessoas.model.Endereco;
import com.cadastro.pessoas.cadastropessoas.model.Pessoa;

import java.util.List;

public interface IEndereco {
    void insert(Endereco obj, Pessoa obj2);
    void update(Endereco obj);
    void delete(Endereco obj);
    Endereco findById(Long id);
    List<Endereco> findAllbyPessoa(Long id);
}
