package com.CEN4010GROUP22.GeekText.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        int yearPublished = book.getYearPublished();
        int copiesSold = book.getCopiesSold();

        System.out.println("ISBN: " + isbn + ", Book Name: " + bookName + "\nDescription: " + description + "\nPrice: " + price + "\nAuthor: " + author + "\nGenre: " + genre
                + "Publisher: " + publisher + ", Year Published: " + yearPublished + "\nCopies Sold: " + copiesSold + "\n");
        booksRepository.save(book);
    }

    public String getBookDetails(String isbn) {
        String bookDetails = booksRepository.findBookDetails(isbn);
        return bookDetails;
    }
    public String getBooksByAuthor(String author) {
        String bookDetails = booksRepository.findBooksByAuthor(author);
        return bookDetails;
    }

}
