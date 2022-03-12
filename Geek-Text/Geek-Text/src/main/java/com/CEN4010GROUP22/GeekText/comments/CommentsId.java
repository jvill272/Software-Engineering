package com.CEN4010GROUP22.GeekText.comments;

import java.io.Serializable;

public class CommentsId implements Serializable {
    private String commenterName;
    private String bookName;

    public CommentsId(){
        ;
    }

    public CommentsId(String commenterName, String bookName){
        this.commenterName = commenterName;
        this.bookName = bookName;
    }
}