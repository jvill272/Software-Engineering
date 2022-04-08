package com.CEN4010GROUP22.GeekText.repositories;

import com.CEN4010GROUP22.GeekText.content.User;
import com.CEN4010GROUP22.GeekText.exceptions.EtAuthException;
import org.springframework.context.annotation.ComponentScan;

public interface UserRepository {

    String create (String email, String password, String address, String name) throws EtAuthException;

    String create (String email, String password, String address) throws EtAuthException;

    String create (String email, String password) throws EtAuthException;

    void updateUser(String email, User user) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findByEmail(String email);

}
