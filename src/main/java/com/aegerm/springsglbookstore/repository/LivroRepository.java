package com.aegerm.springsglbookstore.repository;

import com.aegerm.springsglbookstore.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {}
