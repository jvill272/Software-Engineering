package com.CEN4010GROUP22.GeekText.content;

public class User {
    private String email;
    private String password;
    private String address;
    private String name;

    public User(String email, String password, String address, String name) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}