package com.cadastro.pessoas.cadastropessoas.service;

import com.cadastro.pessoas.cadastropessoas.dao.DaoFactory;
import com.cadastro.pessoas.cadastropessoas.dao.EnderecoDao;
import com.cadastro.pessoas.cadastropessoas.dao.PessoaDao;
import com.cadastro.pessoas.cadastropessoas.model.Endereco;
import com.cadastro.pessoas.cadastropessoas.model.Pessoa;
import com.cadastro.pessoas.cadastropessoas.utils.Cast;

import java.util.List;

public class EnderecoService {

    private EnderecoDao dao = DaoFactory.criaEndereco();
    public void saveOrUptade(Endereco obj, Pessoa obj2) {
        if(obj.getId() == null) {
            dao.insert(obj,obj2);
        }else {
            dao.update(obj);
        }
    }

    public Endereco findById(Long id) {
        return dao.findById(id);
    }

    public List<Endereco> findAll(Object id){
        return dao.findAllbyPessoa(Cast.toLong(id));
    }

    public void delete(Endereco obj){
        dao.delete(obj);
    }
}
