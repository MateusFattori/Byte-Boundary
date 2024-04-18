package br.com.fiap.byteboundary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.byteboundary.model.Documentos;


public interface DocumentosRepository extends JpaRepository<Documentos, Long> {

    Optional<Documentos> findByMaritimoAndAerio(String maritimo, String aerio);


}