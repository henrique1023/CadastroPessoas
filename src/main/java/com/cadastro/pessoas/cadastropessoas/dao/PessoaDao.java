package com.cadastro.pessoas.cadastropessoas.dao;

import com.cadastro.pessoas.cadastropessoas.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public class PessoaDao extends DaoFactory implements Serializable, IPessoa {

    private EntityManagerFactory emf;
    public PessoaDao(EntityManagerFactory emf){
        super();
        this.emf = emf;
    }

    @Override
    public void insert(Pessoa obj) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(obj);
        transaction.commit();
    }

    @Override
    public void update(Pessoa obj) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(obj);
        transaction.commit();
    }

    @Override
    public void delete(Pessoa obj) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(obj);
        transaction.commit();
    }

    @Override
    public Pessoa findById(Long id) {
        Pessoa obj = new Pessoa();
        EntityManager entityManager = emf.createEntityManager();
        obj = entityManager.find(Pessoa.class, id);
        return obj;
    }

    @Override
    public List<Pessoa> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        StringBuffer sql = new StringBuffer();
        sql.append("from Pessoa");
        return entityManager.createQuery(sql.toString()).getResultList();
    }
}
