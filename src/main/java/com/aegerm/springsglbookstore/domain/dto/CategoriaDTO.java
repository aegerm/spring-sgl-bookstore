package com.aegerm.springsglbookstore.domain.dto;

import com.aegerm.springsglbookstore.domain.Categoria;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 8095144555331299587L;

    private Long id;
    private String nome;
    private String descricao;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }
}
