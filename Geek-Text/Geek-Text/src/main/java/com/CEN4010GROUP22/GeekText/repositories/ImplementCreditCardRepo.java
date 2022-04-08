package com.CEN4010GROUP22.GeekText.repositories;

import com.CEN4010GROUP22.GeekText.content.CreditCard;
import com.CEN4010GROUP22.GeekText.content.User;
import com.CEN4010GROUP22.GeekText.exceptions.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;


@Service
@Repository
@ComponentScan({"com.CEN4010GROUP22.GeekText.repositories.CreditCardRepository"})
public class ImplementCreditCardRepo implements CreditCardRepo {

    private static final String SQL_Create = "INSERT INTO CREDIT (card_number, fk_user_uname, card_exdate, card_ccv) VALUES(?,?,?,?) ";
    private static final String SQL_FIND_BY_ID = "SELECT card_number, fk_user_uname, card_exdate, card_ccv FROM CREDIT WHERE card_number = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String addCreditCard(String cardNumber, String fk_user_name, String date, String csv) throws EtAuthException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_Create, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,cardNumber);
                ps.setString(2,fk_user_name);
                ps.setString(3,date);
                ps.setString(4,csv);
                return ps;
            } , keyHolder);
            return (String) keyHolder.getKeys().get("card_Number");
        } catch (Exception e){
            throw new EtAuthException("Invalid creation of Credit Card");
        }
    }

    @Override
    public CreditCard findByCardNumber(String cardNumber){
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{cardNumber}, cardRowMapper);
    }

    private RowMapper<CreditCard> cardRowMapper = ((rs, rowNum) -> {
        return new CreditCard(rs.getString("card_number"),
                rs.getString("fk_user_uname"),
                rs.getString("card_exdate"),
                rs.getString("card_ccv"));
    });

}
