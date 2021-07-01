package com.aegerm.springsglbookstore.rest;

import com.aegerm.springsglbookstore.service.CategoriaService;
import com.aegerm.springsglbookstore.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboards")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DashboardRestService {

    private final LivroService service;
    private final CategoriaService categoriaService;

    @GetMapping("/livros")
    public ResponseEntity<Integer> countRegistroLivros() {
        return ResponseEntity.ok(this.service.countRegistrosLivro());
    }

    @GetMapping("/categorias")
    public ResponseEntity<Integer> countRegistroCategorias() {
        return ResponseEntity.ok(this.categoriaService.countRegistrosCategoria());
    }
}
