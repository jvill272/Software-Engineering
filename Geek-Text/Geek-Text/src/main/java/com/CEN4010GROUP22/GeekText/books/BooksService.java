package com.CEN4010GROUP22.GeekText.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Service
public class BooksService {
    @Autowired
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void addNewBook(Books book) {

        String isbn = book.getIsbn();
        String bookName = book.getBookDetailName();
        String description = book.getDescription();
        float price = book.getPrice();
        String author = book.getAuthor();
        String genre = book.getGenre();
        String publisher = book.getPublisher();
        String yearPublished = book.getYearPublished();
        int copiesSold = book.getCopiesSold();

        System.out.println("ISBN: " + isbn + ", Book Name: " + bookName + "\nDescription: " + description + "\nPrice: " + price + "\nAuthor: " + author + "\nGenre: " + genre
        + "Publisher: " + publisher + ", Year Published: " + yearPublished + "\nCopies Sold: " + copiesSold +"\n");

    }
    public String getBookDetails() {
        return "";
    }
}
