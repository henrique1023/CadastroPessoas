package com.cadastro.pessoas.cadastropessoas.service;

import com.cadastro.pessoas.cadastropessoas.dao.DaoFactory;
import com.cadastro.pessoas.cadastropessoas.dao.PessoaDao;
import com.cadastro.pessoas.cadastropessoas.model.Pessoa;

import java.util.List;

public class PessoaService {

    private PessoaDao dao = DaoFactory.criaPessoa();
    public Pessoa saveOrUptade(Pessoa obj) {
        if(obj.getId() == null) {
            obj = dao.insert(obj);
        }else {
            obj = dao.update(obj);
        }
        return obj;
    }

    public Pessoa findById(Long id) {
        return dao.findById(id);
    }

    public List<Pessoa> findAll(){
        return dao.findAll();
    }

    public void delete(Pessoa obj){
        dao.delete(obj);
    }
}
