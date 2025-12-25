package com.example.demo_spring_jpa.dao;

import com.example.demo_spring_jpa.entity.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
