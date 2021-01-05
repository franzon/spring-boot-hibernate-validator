package dev.jorgerossi.hibernate_validator.entrypoints.rest.validation;

import dev.jorgerossi.hibernate_validator.core.enums.ExampleEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ExampleEnumSubsetValidator implements ConstraintValidator<ExampleEnumSubset, ExampleEnum> {
    private ExampleEnum[] subset;

    @Override
    public void initialize(ExampleEnumSubset constraintAnnotation) {
        this.subset = constraintAnnotation.anyOf();
    }

    @Override
    public boolean isValid(ExampleEnum value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
