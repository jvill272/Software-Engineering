package com.CEN4010GROUP22.GeekText.comments;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
@IdClass(CommentsId.class)
public class Comments implements Serializable{
    // instance variables representing the fields / attributes
    @Column(name = "comment_text", nullable = false, columnDefinition = "text")
    private String commentText;

    @Column(name = "comment_date", nullable = false, columnDefinition = "date")
    private LocalDate commentDate;

    @Id
    @Column(name = "fk_book_commenter", columnDefinition="text")
    private String commenterName;
    
    @Id
    @Column(name = "fk_comment_bname", columnDefinition="text")
    private String bookName;

    // constructors
    public Comments(){
        ;
    }

    public Comments(String commentText, LocalDate commentDate, String commenterName, String bookName){
        this.commentText = commentText;
        this.commentDate = commentDate;
        this.commenterName = commenterName;
        this.bookName = bookName;
    }

    // getters and setters

    public String getCommentText() {
        return this.commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDate getCommentDate() {
        return this.commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommenterName() {
        return this.commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    // toString method
    @Override
    public String toString() {
        return "{" +
            " commentText='" + getCommentText() + "'" +
            ", commentDate='" + getCommentDate() + "'" +
            ", commenterName='" + getCommenterName() + "'" +
            ", bookName='" + getBookName() + "'" +
            "}";
    }

}
