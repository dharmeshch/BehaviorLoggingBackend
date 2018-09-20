package com.dharmesh.AW.Assignment1.Model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "user_posts_count")
public class UserPostsCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "username")
    String userName;

    @Column(name = "posts_count")
    Integer postsCount;

    @Column(name = "posted_date")
    Date postedDate;

    public UserPostsCount(){

    }
    public UserPostsCount(String userName, Integer postsCount, Date postedDate){
        this.userName = userName;
        this.postsCount = postsCount;
        this.postedDate = postedDate;
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

    public Integer getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(Integer postsCount) {
        this.postsCount = postsCount;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }
}
