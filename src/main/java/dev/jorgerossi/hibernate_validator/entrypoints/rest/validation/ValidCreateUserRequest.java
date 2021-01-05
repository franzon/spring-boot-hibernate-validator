package dev.jorgerossi.hibernate_validator.entrypoints.rest.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValidCreateUserRequestValidator.class)
public @interface ValidCreateUserRequest {
    String message() default "must be a valid CreateUserRequest";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
