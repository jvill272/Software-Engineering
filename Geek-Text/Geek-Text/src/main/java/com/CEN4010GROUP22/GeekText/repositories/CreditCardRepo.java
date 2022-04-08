package com.CEN4010GROUP22.GeekText.repositories;

import com.CEN4010GROUP22.GeekText.content.CreditCard;
import com.CEN4010GROUP22.GeekText.exceptions.EtAuthException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


//@Component
@EnableAutoConfiguration
public interface CreditCardRepo {

    String addCreditCard (String cardNumber, String fk_user_name, String date, String csv) throws EtAuthException;

    CreditCard findByCardNumber(String cardNumber);

}
