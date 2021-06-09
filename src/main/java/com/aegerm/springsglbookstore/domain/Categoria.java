package com.aegerm.springsglbookstore.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TblCategoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 982795673788112289L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O campo nome é requerido")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "O campo descrição é requerido")
    @Length(min = 3, max = 200, message = "O campo descrição deve ter entre 3 e 200 caracteres")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros = new ArrayList<>();
}
