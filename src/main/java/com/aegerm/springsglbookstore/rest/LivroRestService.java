package com.aegerm.springsglbookstore.rest;

import com.aegerm.springsglbookstore.domain.Livro;
import com.aegerm.springsglbookstore.domain.dto.LivroDTO;
import com.aegerm.springsglbookstore.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/livros")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LivroRestService {

    private final LivroService service;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroId(@PathVariable Long id) {
        Livro livro = this.service.buscarLivroId(id);
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarLivros(@RequestParam(value = "categoria", defaultValue = "0") Long categoriaId) {
        List<Livro> livros = this.service.listarLivros(categoriaId);
        List<LivroDTO> dtoList = livros.stream().map(LivroDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @Valid @RequestBody Livro livro) {
        Livro livroUpd = this.service.atualizarLivro(id, livro);
        return ResponseEntity.ok().body(livroUpd);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivroParcial(@PathVariable Long id, @Valid @RequestBody Livro livro) {
        Livro livroUpd = this.service.atualizarLivro(id, livro);
        return ResponseEntity.ok().body(livroUpd);
    }

    @PostMapping
    public ResponseEntity<Livro> registrarLivro(@RequestParam(value = "categoria", defaultValue = "0") Long categoriaId, @Valid @RequestBody Livro livro){
        Livro newLivro = this.service.registrarLivro(categoriaId, livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newLivro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        this.service.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}
