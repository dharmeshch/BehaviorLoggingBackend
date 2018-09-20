package com.dharmesh.AW.Assignment1.Model;

import javax.persistence.*;

@Entity
@Table(name = "bookmarked_question")
public class Bookmarked {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "user_name")
    String userName;

    @Column(name = "question_id")
    Integer questionId;

    public Bookmarked(){

    }

    public Bookmarked(String userName, Integer questionId) {
        this.userName = userName;
        this.questionId = questionId;
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

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
