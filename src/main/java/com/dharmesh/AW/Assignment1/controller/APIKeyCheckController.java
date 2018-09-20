package com.dharmesh.AW.Assignment1.controller;

import com.dharmesh.AW.Assignment1.Model.Login;
import com.dharmesh.AW.Assignment1.query.loginQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/")
public class APIKeyCheckController {

    @Autowired
    loginQuery query;
    @ModelAttribute("validate")
    public void validateApiKey(@RequestHeader(value = "userName") String userName,
                                @RequestHeader(value = "apiKey") String apiKey,
                                HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(userName == null || apiKey == null || userName
                .isEmpty() || apiKey.isEmpty()){
            throw new Exception("UserName or apiKey is missing");
        }
        Boolean ret = query.validateUser(userName,apiKey);
        if(ret == false){
            throw new Exception("Invalid userName or apiKey!");
        }
    }
}
