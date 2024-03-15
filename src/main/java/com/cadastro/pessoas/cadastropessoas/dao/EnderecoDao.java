package com.cadastro.pessoas.cadastropessoas.dao;

import com.cadastro.pessoas.cadastropessoas.model.Endereco;
import com.cadastro.pessoas.cadastropessoas.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public class EnderecoDao implements IEndereco, Serializable {

    private EntityManagerFactory emf;

    public EnderecoDao(EntityManagerFactory emf){
        super();
        this.emf = emf;
    }

    @Override
    public void insert(Endereco obj, Pessoa obj2) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(obj);
        obj.setPessoa(obj2);
        entityManager.merge(obj);
        transaction.commit();
    }

    @Override
    public void update(Endereco obj) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(obj);
        transaction.commit();
    }

    @Override
    public void delete(Endereco obj) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(obj);
        transaction.commit();
    }

    @Override
    public Endereco findById(Long id) {
        Endereco obj = new Endereco();
        EntityManager entityManager = emf.createEntityManager();
        obj = entityManager.find(Endereco.class, id);
        return obj;
    }

    @Override
    public List<Endereco> findAllbyPessoa(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        StringBuffer sql = new StringBuffer();
        sql.append("from Endereco vo where vo.pessoa.id = :id");
        return entityManager.createQuery(sql.toString())
                .setParameter("id", id)
                .getResultList();
    }
}
