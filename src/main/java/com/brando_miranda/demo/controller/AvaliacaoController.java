package com.brando_miranda.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.brando_miranda.demo.business.AvaliacaoService;
import com.brando_miranda.demo.model.Avaliacao;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping
    public Avaliacao create(@RequestBody Avaliacao avaliacao) {
        return avaliacaoService.create(avaliacao);
    }

    @GetMapping
    public List<Avaliacao> getAll() {
        return avaliacaoService.listAll();
    }

    @PutMapping("/{id}")
    public Avaliacao update(@PathVariable String id, @RequestBody Avaliacao avaliacao) {
        return avaliacaoService.update(id, avaliacao);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        avaliacaoService.delete(id);
    }
    

}
