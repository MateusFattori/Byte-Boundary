package br.com.fiap.byteboundary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.byteboundary.model.Periodo;
import br.com.fiap.byteboundary.repository.PeriodoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("periodo")
public class PeriodoController {
    
    @Autowired
    PeriodoRepository repository;

    @PostMapping
    public Periodo create(@RequestBody @Valid Periodo periodo){
        return repository.save(periodo);
    }

}
