package com.aegerm.springsglbookstore.repository;

import com.aegerm.springsglbookstore.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT cat FROM Livro cat WHERE cat.categoria.id = :categoriaId ORDER BY titulo")
    List<Livro> findAllByCategoria(@Param(value = "categoriaId") Long categoriaId);
}
