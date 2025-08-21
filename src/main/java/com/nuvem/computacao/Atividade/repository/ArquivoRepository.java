package com.nuvem.computacao.Atividade.repository;

import com.nuvem.computacao.Atividade.models.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoRepository extends JpaRepository<Arquivo,Integer> {
}
