package br.com.fiap.byteboundary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.byteboundary.model.Periodo;

public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
    
}
