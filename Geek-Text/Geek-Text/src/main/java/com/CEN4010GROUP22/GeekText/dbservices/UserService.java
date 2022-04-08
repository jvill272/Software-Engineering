package com.CEN4010GROUP22.GeekText.dbservices;

import com.CEN4010GROUP22.GeekText.content.User;
import com.CEN4010GROUP22.GeekText.exceptions.EtAuthException;

public interface UserService  {

    User registerUser (String email, String password, String address, String name) throws EtAuthException;

    User registerUser (String email, String password, String address) throws EtAuthException;

    User registerUser (String email, String password) throws EtAuthException;

    User validateUser (String email, String password) throws EtAuthException;

    void updateUser(String email, User user) throws EtAuthException;


}
