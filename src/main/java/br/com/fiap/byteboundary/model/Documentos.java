package br.com.fiap.byteboundary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Data
@Entity
public class Documentos{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String documento;
    private String aerio;
    private String maritimo;
}
