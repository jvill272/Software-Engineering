package com.CEN4010GROUP22.GeekText.resources;


//import com.CEN4010GROUP22.GeekText.content.CreditCard;
import com.CEN4010GROUP22.GeekText.content.CreditCard;
import com.CEN4010GROUP22.GeekText.content.User;
//import com.CEN4010GROUP22.GeekText.dbservices.CreditCardService;
import com.CEN4010GROUP22.GeekText.dbservices.UserService;
import com.CEN4010GROUP22.GeekText.exceptions.EtAuthException;
//import com.CEN4010GROUP22.GeekText.repositories.ImplementCreditCard;
import com.CEN4010GROUP22.GeekText.repositories.CreditCardRepo;
import com.CEN4010GROUP22.GeekText.repositories.ImplementUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserResources {

    @Autowired
    UserService userService;
    @Autowired
    ImplementUserRepo implementUserRepo;
    @Autowired
    CreditCardRepo creditCardRepo;

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String, Object> userMap){
        String name = (String) userMap.get("name");
        String address = (String) userMap.get("address");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.registerUser(email,password,address,name);
        Map<String,String> map = new HashMap<>();
        map.put("message", "registered successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/addCreditCard")
    public ResponseEntity<Map<String,String>> addCreditCard(@RequestBody Map<String, Object> userMap){
        String cardNumber = (String) userMap.get("cardNumber");
        String fk_user_name = (String) userMap.get("fk_user_name");
        String date = (String) userMap.get("date");
        String csv = (String) userMap.get("csv");
        String creditCard = creditCardRepo.addCreditCard(cardNumber, fk_user_name, date, csv);
        CreditCard card = creditCardRepo.findByCardNumber(creditCard);
        Map<String,String> map = new HashMap<>();
        map.put("message", "added card succesfully successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/findUser/{user_uname}")
    public ResponseEntity<User> getUserByEmail(HttpServletRequest request, @PathVariable("user_uname") String userName) {
        try {
            User user = implementUserRepo.findByEmail(userName);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e){
            throw new EtAuthException("This user is not in the database!");
        }
    }

    @PutMapping("/updateUser/{user_uname}")
    public ResponseEntity<Map<String,Boolean>> updateUser(HttpServletRequest request,
                                                          @PathVariable("user_uname") String username,
                                                          @RequestBody User user){
        userService.updateUser(username, user);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }



}
