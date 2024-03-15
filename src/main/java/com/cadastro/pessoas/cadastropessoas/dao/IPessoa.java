package com.cadastro.pessoas.cadastropessoas.dao;

import com.cadastro.pessoas.cadastropessoas.model.Pessoa;

import java.util.List;

public interface IPessoa {
    void insert(Pessoa obj);
    void update(Pessoa obj);
    void delete(Pessoa obj);
    Pessoa findById(Long id);
    List<Pessoa> findAll();
}
