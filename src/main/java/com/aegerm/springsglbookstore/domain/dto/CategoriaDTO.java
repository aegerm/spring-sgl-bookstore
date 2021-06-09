package com.aegerm.springsglbookstore.domain.dto;

import com.aegerm.springsglbookstore.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 8095144555331299587L;

    private Long id;

    @NotEmpty(message = "O campo nome é requerido")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "O campo descrição é requerido")
    @Length(min = 3, max = 200, message = "O campo descrição deve ter entre 3 e 200 caracteres")
    private String descricao;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }
}
