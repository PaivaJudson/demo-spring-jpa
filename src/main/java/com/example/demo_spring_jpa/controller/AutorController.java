package com.example.demo_spring_jpa.controller;

import com.example.demo_spring_jpa.dao.AutorDao;
import com.example.demo_spring_jpa.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("autores")
public class AutorController {

    @Autowired
    private AutorDao autorDao;

    @PostMapping
    public Autor salvar(@RequestBody Autor autor){
        autorDao.save(autor);
        return autor;
    }

    @PutMapping
    public Autor atualizar(@RequestBody Autor autor){
        autorDao.update(autor);
        return autor;
    }

    @DeleteMapping("{id}")
    public String remover(@PathVariable Long id){
        autorDao.delete(id);
        return "Autor com o ID "+ id + " foi removido com sucesso!";
    }

}
