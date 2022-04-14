package com.CEN4010GROUP22.GeekText.authors;

import java.io.Serializable;

public class AuthorsId implements Serializable {
    private int authorID;

    public AuthorsId(){ ; }

    public AuthorsId(int authorID) {
        this.authorID = authorID;
    }
}
