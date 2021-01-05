package dev.jorgerossi.hibernate_validator.entrypoints.rest.validation;

import dev.jorgerossi.hibernate_validator.core.enums.UserType;
import dev.jorgerossi.hibernate_validator.entrypoints.rest.request.CreateUserRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.Map;

public class ValidCreateUserRequestValidator implements ConstraintValidator<ValidCreateUserRequest, CreateUserRequest> {
    static boolean processErrors(Map<String, String> errors, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = errors.isEmpty();

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();

            for (Map.Entry<String, String> entry : errors.entrySet()) {
                constraintValidatorContext.buildConstraintViolationWithTemplate(entry.getValue())
                        .addPropertyNode(entry.getKey())
                        .addConstraintViolation();
            }
        }

        return isValid;
    }

    @Override
    public void initialize(ValidCreateUserRequest constraintAnnotation) {
    }

    @Override
    public boolean isValid(CreateUserRequest request, ConstraintValidatorContext constraintValidatorContext) {
        Map<String, String> errors = new HashMap<>();

        if (!request.getPassword().equals(request.getPasswordConfirmation())) {
            errors.put("passwordConfirmation", "Passwords are not the same");
        }

        if (request.getType().equals(UserType.STUDENT.name()) &&
                (request.getStudentId() == null || request.getStudentId().isBlank())) {
            errors.put("studentId", "Student ID is required if user type is STUDENT");
        }

        return processErrors(errors, constraintValidatorContext);
    }
}
