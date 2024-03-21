package br.com.fiap.byteboundary.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.byteboundary.model.Documentos;
import br.com.fiap.byteboundary.repository.DocumentosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/documentos")
@Slf4j

public class ByteBoundayController {

    @Autowired
    DocumentosRepository documentosRepository;

    @GetMapping
    public List<Documentos> index() {
        return documentosRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Documentos> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);
        return documentosRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Documentos create(@RequestBody Documentos documentos) {
        log.info("Cadastrando documentos: {}", documentos);
        return documentosRepository.save(documentos);
    }
    
    
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando documento {}", id);
    }

    @PutMapping("{id}")
    public Documentos update(@PathVariable Long id, @RequestBody Documentos documentos){
        log.info("atualizado documento id{} para {},", id, documentos);

        verificarSeDocumento(id);

        documentos.setId(id);
        return documentosRepository.save(documentos);
    }

    @GetMapping("/{maritimo}/{/aerio}")
    public ResponseEntity<Documentos> get(@PathVariable String maritimo, @PathVariable String aerio){
        log.info("Buscar por maritimo e aerio", maritimo, aerio);
        var optionalDocumento = repository.stream().filter(c -> c.maritimo().equals(maritimo) && c.aerio().equals(aerio)).findFirst();
        
        if (optionalDocumento.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalDocumento.get());
    }

    private void verificarSeDocumento(Long id) {
        documentosRepository.findById(id)
        .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada" )
            );
    }

    
}
