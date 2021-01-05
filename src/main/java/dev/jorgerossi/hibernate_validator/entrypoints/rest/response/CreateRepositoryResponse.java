package dev.jorgerossi.hibernate_validator.entrypoints.rest.response;

import lombok.Data;

import java.util.List;

@Data
public class CreateRepositoryResponse {
    private Long id;
    private String name;
    private Long stars;
    private List<String> languages;
}
