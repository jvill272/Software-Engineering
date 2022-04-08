package com.CEN4010GROUP22.GeekText.content;

public class CreditCard {
    private String cardNumber;
    private String fk_user_name;
    private String date;
    private String csv;

    public CreditCard(String cardNumber, String fk_user_name, String date, String csv) {
        this.cardNumber = cardNumber;
        this.fk_user_name = fk_user_name;
        this.date = date;
        this.csv = csv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFk_user_name() {
        return fk_user_name;
    }

    public void setFk_user_name(String fk_user_name) {
        this.fk_user_name = fk_user_name;
    }

    public String getDate() {
        return date;
    }

    public void setCSV(String csv) {
        this.csv = csv;
    }

    public String getCsv(){return csv;}

}
