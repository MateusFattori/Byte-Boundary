package br.com.fiap.byteboundary.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.byteboundary.model.Documentos;
import br.com.fiap.byteboundary.repository.DocumentosRepository;


@RestController
@RequestMapping("/documentos")

public class ByteBoundayController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    DocumentosRepository documentosRepository;

    @GetMapping
    public List<Documentos> index() {
        return documentosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documentos> get(@PathVariable Long id){
        log.info("Buscar por id: {}", id);
        
        return documentosRepository..findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        log.info("apagando categoria {}", id);

        verificarSeExisteCategoria(id);

        documentosRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }


    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Documentos docuemtento){
        log.info("atualizando documento id {} para {}", id, docuemtento);
        
        verificarSeExisteCategoria(id);

        documentosRepository.setId(id);
        documentosRepository.save(docuemtento);
        return ResponseEntity.ok(docuemtento);
    }

    @GetMapping("/{maritimo}/{/aerio}")
    public ResponseEntity<Documentos> get(@PathVariable String maritimo, @PathVariable String aerio){
        log.info("Buscar por maritimo e aerio", maritimo, aerio);
        var optionalDocumento = repository.stream().filter(c -> c.maritimo().equals(maritimo) && c.aerio().equals(aerio)).findFirst();
        
        if (optionalDocumento.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalDocumento.get());
    }

    private void verificarSeExisteCategoria(Long id) {
        documentosRepository.findById(id)
        .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada" )
            );
    }

    
}
