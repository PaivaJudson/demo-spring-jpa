package com.example.demo_spring_jpa.dao;

import com.example.demo_spring_jpa.entity.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AutorDao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional(readOnly = false)
    public void save(Autor autor){
        manager.persist(autor);
    }

    @Transactional(readOnly = false)
    public void update(Autor autor){
        manager.merge(autor);
    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        manager.remove(manager.getReference(Autor.class, id));
    }

    @Transactional(readOnly = true)
    public Autor findById(Long id){
        return manager.find(Autor.class, id);
    }

    @Transactional(readOnly = true)
    public List<Autor> findAll(){
        String query = "select a from Autor a";
        return manager.createQuery(query, Autor.class).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Autor> findAllByNomeOrSobrenome(String expressao){
        String query = "select a from Autor a "+
                       "where a.nome like :expressao OR a.sobrenome like :expressao";
        return manager.createQuery(query, Autor.class)
                .setParameter("expressao", "%" + expressao +"%")
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Long getTotalElements(){
        String query = "select count(1) from Autor a";
        return manager.createQuery(query, Long.class).getSingleResult();
    }



}
