package com.brando_miranda.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.brando_miranda.demo.DTOs.AvaliacaoRequest;
import com.brando_miranda.demo.DTOs.AvaliacaoResponse;
import com.brando_miranda.demo.business.AvaliacaoService;
import com.brando_miranda.demo.model.Avaliacao;


import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AvaliacaoResponse> create(@Valid @RequestBody AvaliacaoRequest dto) {
        AvaliacaoResponse createdAvaliacao = avaliacaoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAvaliacao);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoResponse>> getAll() { 
        List<AvaliacaoResponse> lista = avaliacaoService.listAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoResponse> getById(@PathVariable String id) {
        return avaliacaoService.getById(id)
                .map(avaliacao -> ResponseEntity.ok(avaliacao)) 
                .orElse(ResponseEntity.notFound().build());  
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> update(@PathVariable String id, @RequestBody @Valid AvaliacaoRequest dto) {
        try {
            Avaliacao atualizada = avaliacaoService.update(id, dto);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        avaliacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    

}
