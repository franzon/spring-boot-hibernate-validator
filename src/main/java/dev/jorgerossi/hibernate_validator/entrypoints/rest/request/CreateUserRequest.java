package dev.jorgerossi.hibernate_validator.entrypoints.rest.request;

import dev.jorgerossi.hibernate_validator.core.enums.ExampleEnum;
import dev.jorgerossi.hibernate_validator.core.enums.UserType;
import dev.jorgerossi.hibernate_validator.entrypoints.rest.validation.EnumNamePattern;
import dev.jorgerossi.hibernate_validator.entrypoints.rest.validation.ExampleEnumSubset;
import dev.jorgerossi.hibernate_validator.entrypoints.rest.validation.ValidCreateUserRequest;
import dev.jorgerossi.hibernate_validator.entrypoints.rest.validation.ValueOfEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@ValidCreateUserRequest
public class CreateUserRequest {

    @NotBlank
    @Length(min = 8, max = 20)
    private String name;

    @NotBlank
    @Email
    @Length(max = 32)
    private String email;

    @NotBlank
    @Length(max = 32)
    private String password;

    @NotBlank
    @Length(max = 32)
    private String passwordConfirmation;

    @NotBlank
    @ValueOfEnum(enumClass = UserType.class)
    private String type;

    @NotNull
    @ExampleEnumSubset(anyOf = {ExampleEnum.ORANGE, ExampleEnum.APPLE})
    private ExampleEnum example;

    @NotNull
    @EnumNamePattern(regexp = "ORANGE|APPLE")
    private ExampleEnum examplePattern;

    @Past
    @NotNull
    private Date pastDate;

    @Future
    @NotNull
    private Date futureDate;

    // Required if type = STUDENT
    private String studentId;
}
