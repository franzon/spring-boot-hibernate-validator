# Hibernate Validator

Demo project for Hibernate Validator with Spring Boot

### Dependencies

- `spring-boot-starter-web`
- `spring-boot-starter-validation`
- `lombok`

### Contents

- Exception handling with `@ControllerAdvice`
- Basic validations (`@NotNull`, `@NotBlank`, `@Length`, `@Positive`, `@Max`, `@Size`, `@Email`)
- Validation of list elements
- Validation of dates (`@Past`, `@Future`)
- Validation of enums (by any enum value, by subset of enum and by pattern)
- Class-level validation (check if two fields are equals and make one field required depending on another field value)