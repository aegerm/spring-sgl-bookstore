package com.aegerm.springsglbookstore.rest;

import com.aegerm.springsglbookstore.domain.Categoria;
import com.aegerm.springsglbookstore.domain.dto.CategoriaDTO;
import com.aegerm.springsglbookstore.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
public class CategoriaRestService {

    private final CategoriaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriaId(@PathVariable Long id) {
        Categoria categoria = this.service.buscarCategoriaId(id);
        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        List<Categoria> categorias = this.service.listarCategorias();
        List<CategoriaDTO> dtoList = categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }
}
