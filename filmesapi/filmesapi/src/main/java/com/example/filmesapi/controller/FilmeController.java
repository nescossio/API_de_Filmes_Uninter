package com.example.filmesapi.controller;

import com.example.filmesapi.model.Filme;
import com.example.filmesapi.repository.FilmeRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<Filme>> listarTodos() {
        return ResponseEntity.ok(filmeRepository.findAll());
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable("id") String id) {
        return filmeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // POST - Criar novo filme
    @PostMapping
    public ResponseEntity<Filme> criar(@Valid @RequestBody Filme filme) {
        filmeRepository.save(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filme);
    }

    // PUT - Atualizar filme
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@PathVariable("id") String id,
                                           @Valid @RequestBody Filme filmeAtualizado) {
        return filmeRepository.findById(id).map(filme -> {
            filme.setTitulo(filmeAtualizado.getTitulo());
            filme.setDescricao(filmeAtualizado.getDescricao());
            filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());
            filme.setGenero(filmeAtualizado.getGenero());
            filmeRepository.save(filme);
            return ResponseEntity.ok(filme);
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // DELETE - Remover filme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        return filmeRepository.findById(id).map(filme -> {
            filmeRepository.delete(filme);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
