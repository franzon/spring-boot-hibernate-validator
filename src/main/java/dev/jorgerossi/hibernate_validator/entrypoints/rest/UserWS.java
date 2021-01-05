package dev.jorgerossi.hibernate_validator.entrypoints.rest;

import dev.jorgerossi.hibernate_validator.core.enums.UserType;
import dev.jorgerossi.hibernate_validator.entrypoints.rest.request.CreateUserRequest;
import dev.jorgerossi.hibernate_validator.entrypoints.rest.response.CreateUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserWS {

    @PostMapping("/")
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {

        CreateUserResponse response = new CreateUserResponse();
        response.setId(1L);
        response.setName(request.getName());
        response.setEmail(request.getEmail());
        response.setType(UserType.valueOf(request.getType()));
        response.setStudentId(request.getStudentId());
        response.setExample(request.getExample());
        response.setPastDate(request.getPastDate());
        response.setFutureDate(request.getFutureDate());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
