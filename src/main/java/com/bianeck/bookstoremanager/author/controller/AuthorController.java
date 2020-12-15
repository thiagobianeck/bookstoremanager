package com.bianeck.bookstoremanager.author.controller;

import com.bianeck.bookstoremanager.author.dto.AuthorDTO;
import com.bianeck.bookstoremanager.author.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController implements AuthorControllerDocs{

    private final AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO create(@RequestBody @Valid AuthorDTO authorDTO) {
        return authorService.create(authorDTO);
    }
}
