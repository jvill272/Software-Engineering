package com.CEN4010GROUP22.GeekText.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, BooksId> {
    // retrieve the book details for a specific isbn.
    @Query("SELECT b.isbn, b.bookName, b.description, b.price, b.author, b.genre, b.publisher, b.yearPublished, b.copiesSold FROM Books b WHERE b.isbn = ?1")
    String findBookDetails(String isbn);
}
