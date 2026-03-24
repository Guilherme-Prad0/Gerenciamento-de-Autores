package com.rdg.GerenciamentoAutores.controller;

import com.rdg.GerenciamentoAutores.models.AutoresModels;
import com.rdg.GerenciamentoAutores.service.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutoresController {

    @Autowired
    private AutoresService autoresService;

    @GetMapping
    public ResponseEntity<List<AutoresModels>> getAll() {
        List<AutoresModels> autores = autoresService.findAll();
        return ResponseEntity.ok(autores);
    }

    @PostMapping
    public ResponseEntity<AutoresModels> create(@RequestBody AutoresModels autores) {
        AutoresModels autoresSalvo = autoresService.save(autores);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autoresSalvo.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(autoresSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        autoresService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<AutoresModels> findById(@PathVariable Long id) {
        return ResponseEntity.ok(autoresService.findById(id));
    }
}
