package com.dharmesh.AW.Assignment1.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "login_history")
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "last_login_time")
    Timestamp lastLoginTime;

    public LoginHistory(){

    }

    public LoginHistory(Integer userId, Timestamp lastLoginTime){
        this.userId = userId;
        this.lastLoginTime=lastLoginTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
