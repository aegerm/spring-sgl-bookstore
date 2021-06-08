package com.aegerm.springsglbookstore.service;

import com.aegerm.springsglbookstore.domain.Livro;
import com.aegerm.springsglbookstore.repository.LivroRepository;
import com.aegerm.springsglbookstore.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;
    private final CategoriaService categoriaService;

    public Livro buscarLivroId(Long id) {
        Optional<Livro> livro = this.repository.findById(id);
        return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> listarLivros(Long categoriaId) {
        this.categoriaService.buscarCategoriaId(categoriaId);
        return this.repository.findAllByCategoria(categoriaId);
    }
}
