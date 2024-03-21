package br.com.fiap.byteboundary.model;



import br.com.fiap.byteboundary.validation.TipoPeriodo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Periodo {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{periodo.descricao.notblank}")
    @Size(min = 5, message = "{periodo.descricao.size}")
    private String descricao;

    @TipoPeriodo(message = "{periodo.tipo.tipoperiodo}")
    private String tipo;

}
