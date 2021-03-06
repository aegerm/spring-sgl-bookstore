package com.aegerm.springsglbookstore.service;

import com.aegerm.springsglbookstore.domain.Categoria;
import com.aegerm.springsglbookstore.domain.dto.CategoriaDTO;
import com.aegerm.springsglbookstore.repository.CategoriaRepository;
import com.aegerm.springsglbookstore.service.exceptions.DataIntegrityViolationException;
import com.aegerm.springsglbookstore.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public Integer countRegistrosCategoria() {
        Integer count = this.repository.countCategoria();
        return count;
    }

    public Categoria atualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = this.buscarCategoriaId(id);
        categoria.setNome(categoriaDTO.getNome());
        categoria.setDescricao(categoriaDTO.getDescricao());
        return this.repository.save(categoria);
    }

    public Categoria buscarCategoriaId(Long id) {
        Optional<Categoria> categoria = this.repository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> listarCategorias(Pageable pageable) {
        List<Categoria> categorias = this.repository.findAll(pageable).stream().collect(Collectors.toList());
        return categorias;
    }

    public Categoria registrarCategoria(Categoria categoria) {
        return this.repository.save(categoria);
    }

    public void deletarCategoria(Long id) {
        this.buscarCategoriaId(id);
        try {
            this.repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Categoria possui livros associados!");
        }
    }
}
