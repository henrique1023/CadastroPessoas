package com.cadastro.pessoas.cadastropessoas.bean;

import com.cadastro.pessoas.cadastropessoas.dao.PessoaDao;
import com.cadastro.pessoas.cadastropessoas.model.Pessoa;
import com.cadastro.pessoas.cadastropessoas.service.PessoaService;
import com.cadastro.pessoas.cadastropessoas.utils.Cast;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "cadastroPessoa")
@ViewScoped
public class CadastroPessoaBean implements Serializable {

    private PessoaService service = new PessoaService();
    private Pessoa pessoa;
    @PostConstruct
    public void init() {
        pessoa = new Pessoa();
    }

    public String listarPessoas(){
        return "/cadastroPessoa/list_cadastroPessoa.xhtml";
    }

    public void novoPessoa(){
        pessoa = new Pessoa();
    }

    public void alterarPessoa(Object id){
        try {
            pessoa = service.findById(Cast.toLong(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirPessoa(Object id){
        try {
            pessoa = service.findById(Cast.toLong(id));
            service.delete(pessoa);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void salvarPessoa(){
        try {
            service.saveOrUptade(pessoa);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaService getService() {
        return service;
    }

    public void setService(PessoaService service) {
        this.service = service;
    }
}
