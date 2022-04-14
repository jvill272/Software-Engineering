package com.CEN4010GROUP22.GeekText.authors;

import com.CEN4010GROUP22.GeekText.books.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorsService {
    @Autowired
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public void addNewAuthor(Authors author) {

        String firstName = author.getFirstName();
        String lastName = author.getLastName();
        String biography = author.getBiography();
        String publisher = author.getPublisher();

        System.out.println("First Name: " + firstName + " Last Name: " + lastName + "\nBiography: " + biography + "\nPublisher: " + publisher + "\n");
        authorsRepository.save(author);
    }
}
