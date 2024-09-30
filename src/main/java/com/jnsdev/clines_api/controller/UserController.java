package com.jnsdev.clines_api.controller;

import com.jnsdev.clines_api.domain.UserForm;
import com.jnsdev.clines_api.domain.UserView;
import com.jnsdev.clines_api.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 12:07
 */
@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> createBy(@RequestBody @Valid UserForm form) {
        var userView = service.createUserBy(form);

        var uri = URI.create("/users/").resolve(userView.id().toString());

        return created(uri).body(userView);
    }

    @GetMapping
    List<UserView> list() {
        return service.findAll();
    }

    @GetMapping("{id}")
    UserView show(@PathVariable Long id) {
        return service.showUserBy(id);
    }
}
