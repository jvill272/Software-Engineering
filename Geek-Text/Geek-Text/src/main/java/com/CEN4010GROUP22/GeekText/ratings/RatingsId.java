package com.CEN4010GROUP22.GeekText.ratings;

import java.io.Serializable;

public class RatingsId implements Serializable {
    private String raterName;
    private String bookName;

    public RatingsId(){
        ;
    }

    public RatingsId(String raterName, String bookName){
        this.raterName = raterName;
        this.bookName = bookName;
    }
}
