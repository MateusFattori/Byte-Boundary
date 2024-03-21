package br.com.fiap.byteboundary.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoPeriodoValidator implements ConstraintValidator<TipoPeriodo, String> {
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("FINALIZADO") || value.equals("EM ADAMENTO");
    }

}
