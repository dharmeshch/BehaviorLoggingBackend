package com.dharmesh.AW.Assignment1.query;

import com.dharmesh.AW.Assignment1.JPARepository.LoginHistoryRepository;
import com.dharmesh.AW.Assignment1.JPARepository.loginRepository;
import com.dharmesh.AW.Assignment1.Model.Login;
import com.dharmesh.AW.Assignment1.Model.LoginHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.UUID;

@Repository
public class loginQuery {
    @Autowired
    loginRepository repository;

    @Autowired
    LoginHistoryRepository loginHistoryRepository;

    public HashMap<String, Object> loginQuery(String userName, String password, String firstName, String lastName){
        HashMap<String, Object>  hm = new HashMap<>();
        Timestamp createdTime  = new Timestamp(System.currentTimeMillis());
        String apiKey = UUID.randomUUID().toString();
        repository.save(new Login(userName, password, apiKey, createdTime, firstName, lastName));
        hm.put("status","200");
        hm.put("message", "successfully inserted");
        return hm;
    }

    public String checkLogin(String userName, String password){
        Login login = repository.findByUserName(userName);
        String apiKey = null;
        if(login.getPassword().equals(password)){
            apiKey = UUID.randomUUID().toString();
            login.setApiKey(apiKey);
            login.setApiKeyTime(new Timestamp(System.currentTimeMillis()));
            repository.save(login);
            loginHistoryRepository.save(new LoginHistory(login.getId(),new Timestamp(System.currentTimeMillis()-25200000)));
        }
        return apiKey;
    }

    public Boolean validateUser(String userName, String apiKey){
        Login login = repository.findByUserName(userName);
        long now = System.currentTimeMillis();
        long apiKeyMilliSeconds = login.getApiKeyTime().getTime();
        long diff = now - apiKeyMilliSeconds;
        diff = diff/(60*60*1000);
        if(diff < 2){
            return true;
        }
        return false;
    }
}
