package com.aegerm.springsglbookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TblLivro")
public class Livro implements Serializable {

    private static final long serialVersionUID = -5451188405914244418L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O campo titulo é requerido")
    @Length(min = 3, max = 80, message = "O campo titulo deve ter entre 3 e 80 caracteres")
    private String titulo;

    @NotEmpty(message = "O campo autor é requerido")
    @Length(min = 3, max = 80, message = "O campo autor deve ter entre 3 e 80 caracteres")
    private String autor;

    @NotEmpty(message = "O campo texto é requerido")
    @Length(min = 10, message = "O campo texto deve ter no minímo 10 caracteres")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
