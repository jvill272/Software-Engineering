package com.CEN4010GROUP22.GeekText.authors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
@IdClass(AuthorsId.class)

public class Authors {
    @Id
    @Column(name = "author_id", nullable = false, columnDefinition = "text")
    private int authorID;
    @Column(name = "first_name", nullable = false, columnDefinition = "text")
    private String firstName;
    @Column(name = "last_name", nullable = false, columnDefinition = "text")
    private String lastName;
    @Column(name = "biography", columnDefinition = "text")
    private String biography;
    @Column(name = "publisher", columnDefinition = "text")
    private String publisher;


    public Authors() {
        ;
    }

    public Authors(String firstName, String lastName, String publisher, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.publisher = publisher;
        this.biography = biography;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "{" +
                " firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", biography='" + getBiography() + "'" +
                ", publisher='" + getPublisher() + "'" +
                "}";
    }
}
