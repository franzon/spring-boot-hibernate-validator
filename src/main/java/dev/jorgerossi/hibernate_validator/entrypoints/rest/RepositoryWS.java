package dev.jorgerossi.hibernate_validator.entrypoints.rest;

import dev.jorgerossi.hibernate_validator.entrypoints.rest.request.CreateRepositoryRequest;
import dev.jorgerossi.hibernate_validator.entrypoints.rest.response.CreateRepositoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/repositories")
public class RepositoryWS {

    @PostMapping("/")
    public ResponseEntity<CreateRepositoryResponse> createRepository(@Valid @RequestBody CreateRepositoryRequest request) {

        CreateRepositoryResponse response = new CreateRepositoryResponse();
        response.setId(1L);
        response.setName(request.getName());
        response.setStars(request.getStars());
        response.setLanguages(request.getLanguages());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
