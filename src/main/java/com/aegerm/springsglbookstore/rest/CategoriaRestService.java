package com.aegerm.springsglbookstore.rest;

import com.aegerm.springsglbookstore.domain.Categoria;
import com.aegerm.springsglbookstore.domain.dto.CategoriaDTO;
import com.aegerm.springsglbookstore.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Categoria> registrarCategoria(@RequestBody Categoria categoria) {
        categoria = this.service.registrarCategoria(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                                             .path("/{id}")
                                             .buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        Categoria newCategoria = this.service.atualizarCategoria(id, categoriaDTO);
        return ResponseEntity.ok().body(new CategoriaDTO(newCategoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        this.service.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
