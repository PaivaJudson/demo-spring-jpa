package com.example.demo_spring_jpa.controller;

import com.example.demo_spring_jpa.dao.AutorDao;
import com.example.demo_spring_jpa.entity.Autor;
import com.example.demo_spring_jpa.entity.InfoAutor;
import com.example.demo_spring_jpa.projection.AutorInfoProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public Autor getById(@PathVariable Long id){
        return autorDao.findById(id);
    }

    @GetMapping
    public List<Autor> getAll(){
        return autorDao.findAll();
    }

    @GetMapping("nomeOrsobrenome")
    public List<Autor> getAutoresByNomeOrSobrenome(@RequestParam String expressao){
        return autorDao.findAllByNomeOrSobrenome(expressao);
    }

    @GetMapping("total")
    public Long getTotalDeAutores(){
        return autorDao.getTotalElements();
    }

    @PutMapping("{id}/info")
    public Autor salvarInfoAutor(@PathVariable Long id, @RequestBody InfoAutor infoAutor){
        return autorDao.saveInfoAutor(infoAutor, id);
    }

    @GetMapping("info")
    public List<Autor> consultarAutoresPorCargo(@RequestParam String expressaoCargo){
        return autorDao.findByCargo(expressaoCargo);
    }

    @GetMapping("autor-info")
    public AutorInfoProjection consultar(@RequestParam Long id){
        return autorDao.findAutorInfoById(id);
    }

}
