package com.dharmesh.AW.Assignment1.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "user_name")
    String userName;

    @Column(name = "password")
    String password;

    @Column(name = "api_key")
    String apiKey;

    @Column(name = "key_timestamp")
    Timestamp apiKeyTime;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    Login(){

    }

    public Login(String userName, String password, String apiKey, Timestamp apiKeyTime, String firstName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.apiKey = apiKey;
        this.apiKeyTime = apiKeyTime;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Timestamp getApiKeyTime() {
        return apiKeyTime;
    }

    public void setApiKeyTime(Timestamp apiKeyTime) {
        this.apiKeyTime = apiKeyTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
