package com.aegerm.springsglbookstore.repository;

import com.aegerm.springsglbookstore.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT COUNT(id) FROM Categoria")
    Integer countCategoria();
}
