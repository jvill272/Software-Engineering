package com.CEN4010GROUP22.GeekText.repositories;

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
@ComponentScan({"com.CEN4010GROUP22.GeekText.repositories.UserRepository"})
public class ImplementUserRepo implements UserRepository {

    private static final String SQL_Create = "INSERT INTO USERS (user_uname, user_pword, user_address, user_name) VALUES(?,?,?,?) ";
    private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT (*) FROM USERS WHERE user_uname = ?";
    private static final String SQL_FIND_BY_ID = "SELECT user_uname, user_pword, user_address, user_name FROM USERS WHERE user_uname = ?";
    private static final String SQL_UPDATE_USER = "UPDATE users SET user_pword = ?, user_address = ?, user_name = ? " +
            "WHERE user_uname = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public String create(String email, String password, String address, String name) throws EtAuthException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_Create, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,email);
                ps.setString(2,password);
                ps.setString(3,address);
                ps.setString(4,name);
                return ps;
            } , keyHolder);
            return (String) keyHolder.getKeys().get("user_uname");
        } catch (Exception e){
            throw new EtAuthException("Invalid creation of User");
        }
    }

    public String create(String email, String password, String address) throws EtAuthException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_Create, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,email);
                ps.setString(2,password);
                ps.setString(3,address);
                return ps;
            } , keyHolder);
            return (String) keyHolder.getKeys().get("user_uname");
        } catch (Exception e){
            throw new EtAuthException("Invalid creation of User");
        }
    }

    public String create(String email, String password) throws EtAuthException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_Create, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,email);
                ps.setString(2,password);
                return ps;
            } , keyHolder);
            return (String) keyHolder.getKeys().get("user_uname");
        } catch (Exception e){
            throw new EtAuthException("Invalid creation of User");
        }
    }

    @Override
    public void updateUser(String email, User user) throws EtAuthException{
        try {
            jdbcTemplate.update(SQL_UPDATE_USER,
                    new Object[]{user.getPassword(),user.getAddress(),user.getName(), email});
        }
        catch (Exception e){
            throw new EtAuthException("Invalid Request");
        }
    }

    @Override
    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object[]{email},Integer.class);
    }

    @Override
    public User findByEmail(String email)  {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{email}, userRowMapper);
    }

    private RowMapper<User> userRowMapper = ((rs, rowNum) -> {
        return new User(rs.getString("user_uname"),
                rs.getString("user_pword"),
                rs.getString("user_address"),
                rs.getString("user_name"));
    });

}
