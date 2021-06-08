package com.aegerm.springsglbookstore.rest;

import com.aegerm.springsglbookstore.domain.Livro;
import com.aegerm.springsglbookstore.domain.dto.LivroDTO;
import com.aegerm.springsglbookstore.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/livros")
@RequiredArgsConstructor
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
}
