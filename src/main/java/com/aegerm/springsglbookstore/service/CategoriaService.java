package com.aegerm.springsglbookstore.service;

import com.aegerm.springsglbookstore.domain.Categoria;
import com.aegerm.springsglbookstore.repository.CategoriaRepository;
import com.aegerm.springsglbookstore.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public Categoria buscarCategoriaId(Long id) {
        Optional<Categoria> categoria = this.repository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> listarCategorias() {
        return this.repository.findAll();
    }

    public Categoria registrarCategoria(Categoria categoria) {
        return this.repository.save(categoria);
    }
}
