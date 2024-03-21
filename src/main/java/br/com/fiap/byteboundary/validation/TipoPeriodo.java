package br.com.fiap.byteboundary.validation;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(FIELD)
@Constraint(validatedBy = TipoPeriodoValidator.class)
@Retention(RUNTIME)
public @interface TipoPeriodo {
    
    String message() default "Tipo inválido. Tipo deve ser FINALIZAD0 ou EM ADAMENTO.";

    Class<?>[] groups() default { };

        Class<? extends Payload>[] payload() default { };
    
}
