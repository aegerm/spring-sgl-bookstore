package com.aegerm.springsglbookstore.domain.dto;

import com.aegerm.springsglbookstore.domain.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 4693371794146062096L;

    private Long id;

    @NotEmpty(message = "O campo titulo é requerido")
    @Length(min = 3, max = 80, message = "O campo titulo deve ter entre 3 e 80 caracteres")
    private String titulo;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }
}
