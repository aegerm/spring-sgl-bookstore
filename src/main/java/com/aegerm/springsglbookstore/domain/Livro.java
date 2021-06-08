package com.aegerm.springsglbookstore.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String titulo;
    private String autor;
    private String texto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
