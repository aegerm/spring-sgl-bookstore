package com.aegerm.springsglbookstore.service;

import com.aegerm.springsglbookstore.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;
}
