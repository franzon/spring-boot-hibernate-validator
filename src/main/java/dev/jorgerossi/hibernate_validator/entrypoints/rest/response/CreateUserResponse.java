package dev.jorgerossi.hibernate_validator.entrypoints.rest.response;

import dev.jorgerossi.hibernate_validator.core.enums.ExampleEnum;
import dev.jorgerossi.hibernate_validator.core.enums.UserType;
import lombok.Data;

import java.util.Date;

@Data
public class CreateUserResponse {
    private Long id;
    private String name;
    private String email;
    private UserType type;
    private String studentId;
    private ExampleEnum example;
    private Date pastDate;
    private Date futureDate;
}
