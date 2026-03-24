package com.rdg.GerenciamentoAutores.repository;

import com.rdg.GerenciamentoAutores.models.AutoresModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<AutoresModels, Long> {
}
