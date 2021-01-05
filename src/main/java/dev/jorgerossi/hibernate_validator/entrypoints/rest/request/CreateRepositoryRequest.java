package dev.jorgerossi.hibernate_validator.entrypoints.rest.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class CreateRepositoryRequest {
    @NotBlank(message = "Please choose a name")
    @Length(min = 8, max = 20)
    private String name;

    @NotNull
    @Positive
    @Max(value = 1000)
    private Long stars;

    @NotNull
    @Size(min = 2, max = 5)
    private List<@NotNull @Length(min = 1, max = 8) String> languages;
}
