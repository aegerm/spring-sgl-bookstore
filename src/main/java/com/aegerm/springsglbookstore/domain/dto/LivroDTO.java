package com.aegerm.springsglbookstore.domain.dto;

import com.aegerm.springsglbookstore.domain.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 4693371794146062096L;

    private Long id;
    private String titulo;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }
}
