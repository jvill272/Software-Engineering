package com.CEN4010GROUP22.GeekText.dbservices;

import com.CEN4010GROUP22.GeekText.content.User;
import com.CEN4010GROUP22.GeekText.exceptions.EtAuthException;
import com.CEN4010GROUP22.GeekText.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class ImplementUser implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        return null;
    }

    @Override
    public void updateUser(String email, User user) throws EtAuthException{
        Integer count = userRepository.getCountByEmail(email);
        if (count == 0){
            throw new EtAuthException("The user you are trying to update does not exist in the system");
        }
        userRepository.updateUser(email, user);
    }

    @Override
    public User registerUser(String email, String password, String address, String name) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null){
            email = email.toLowerCase();
        }
        if (!pattern.matcher(email).matches()){
            throw new EtAuthException("Your email is invalid");
        }
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0){
            throw new EtAuthException("Email already in use");
        }

        String userName = userRepository.create(email, password, address, name);

        return userRepository.findByEmail(userName);
    }

    public User registerUser(String email, String password, String address) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null){
            email = email.toLowerCase();
        }
        if (!pattern.matcher(email).matches()){
            throw new EtAuthException("Your email is invalid");
        }
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0){
            throw new EtAuthException("Email already in use");
        }

        String userName = userRepository.create(email, password, address);

        return userRepository.findByEmail(userName);
    }

    public User registerUser(String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null){
            email = email.toLowerCase();
        }
        if (!pattern.matcher(email).matches()){
            throw new EtAuthException("Your email is invalid");
        }
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0){
            throw new EtAuthException("Email already in use");
        }

        String userName = userRepository.create(email, password);

        return userRepository.findByEmail(userName);
    }


}
