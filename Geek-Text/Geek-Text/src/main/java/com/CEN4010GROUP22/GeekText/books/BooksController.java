package com.CEN4010GROUP22.GeekText.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }


    @PostMapping(path = "books")
    public void addNewBook(@RequestBody Books book){
        System.out.println("\nRequest body: " + book);

        booksService.addNewBook(book);
    }


    @GetMapping(path = "books/{isbn}")
    public String getBookDetails() {
        System.out.println("Get request for Book Details is successful.");
        return booksService.getBookDetails();
    }


}