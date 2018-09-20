package com.dharmesh.AW.Assignment1.controller;

import com.dharmesh.AW.Assignment1.JPARepository.loginRepository;
import com.dharmesh.AW.Assignment1.Model.Login;
import com.dharmesh.AW.Assignment1.query.loginQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class LoginController {


    @Autowired
    loginQuery query;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginController(@RequestHeader(value = "userName") String userName,
                                                   @RequestHeader(value = "password") String password,
                                                   HttpServletRequest request, HttpServletResponse response){
        String apiKey = query.checkLogin(userName, password);
        if(apiKey == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Wrong password";
        }
        return apiKey;
    }

    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public HashMap<String, Object> createUserController(@RequestHeader(value = "userName") String userName,
                                       @RequestHeader(value = "password") String password,
                                       @RequestHeader(value = "confirmPassword") String confirmPassword,
                                       @RequestHeader(value = "firstName") String firstName,
                                       @RequestHeader(value = "lastName") String lastName,
                                       HttpServletRequest request, HttpServletResponse response){
        HashMap<String, Object>result = null;
        if(confirmPassword.equals(password)) {
            result = query.loginQuery(userName,password, firstName, lastName);
            response.setStatus(HttpServletResponse.SC_OK);
            return result;
        }
        else{
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            result.put("status", 400);
            result.put("message", "passwords are not matching");
            return result;
        }
    }
}
