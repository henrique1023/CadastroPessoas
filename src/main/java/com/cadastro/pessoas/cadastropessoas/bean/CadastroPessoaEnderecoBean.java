package com.cadastro.pessoas.cadastropessoas.bean;

import com.cadastro.pessoas.cadastropessoas.model.Endereco;
import com.cadastro.pessoas.cadastropessoas.model.Pessoa;
import com.cadastro.pessoas.cadastropessoas.service.EnderecoService;
import com.cadastro.pessoas.cadastropessoas.service.PessoaService;
import com.cadastro.pessoas.cadastropessoas.utils.Cast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "cadastroPessoa")
@ViewScoped
public class CadastroPessoaEnderecoBean implements Serializable {

    private PessoaService pessoaService = new PessoaService();
    private EnderecoService enderecoService = new EnderecoService();
    private Pessoa pessoa;
    private Endereco endereco;
    private List<Endereco> enderecos;
    @PostConstruct
    public void init() {
        pessoa = new Pessoa();
        endereco = new Endereco();
        enderecos = new ArrayList<>();
    }

    public String listarPessoas(){
        return "/cadastroPessoa/list_cadastroPessoa.xhtml";
    }

    public void novoPessoa(){
        pessoa = new Pessoa();
    }

    public void alterarPessoa(Object id){
        try {
            pessoa = pessoaService.findById(Cast.toLong(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void listarEnderecos(Object id){
        try {
            enderecos = enderecoService.findAll(Cast.toLong(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void novoEndereco(Object id){
        try {
            pessoa = pessoaService.findById(Cast.toLong(id));
            endereco = new Endereco();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirEndereco(Object id){
        try {
            endereco = enderecoService.findById(Cast.toLong(id));
            enderecoService.delete(endereco);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirPessoa(Object id){
        try {
            pessoa = pessoaService.findById(Cast.toLong(id));
            pessoaService.delete(pessoa);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void salvarPessoa(){
        try {
            pessoaService.saveOrUptade(pessoa);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void salvarEndereco(){
        try {
            enderecoService.saveOrUptade(endereco, pessoa);
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

    public PessoaService getPessoaService() {
        return pessoaService;
    }

    public void setPessoaService(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public EnderecoService getEnderecoService() {
        return enderecoService;
    }

    public void setEnderecoService(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
