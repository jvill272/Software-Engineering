package com.CEN4010GROUP22.GeekText.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorsController {
    private final AuthorsService authorsService;

    @Autowired
    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @PostMapping(path = "authors/add")
    public void addNewAuthor(@RequestBody Authors author) {
        System.out.println("\nRequest Body: " + author);
        authorsService.addNewAuthor(author);
    }
}
