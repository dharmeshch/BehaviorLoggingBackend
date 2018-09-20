package com.dharmesh.AW.Assignment1.Model;

import javax.persistence.*;

@Entity
@Table(name = "question_hits")
public class QuestionHits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "username")
    String username;

    @Column(name = "question_id")
    Integer questionId;

    @Column(name = "question_hits")
    Integer questionHits;

    public QuestionHits(){

    }
    public QuestionHits(String username, Integer questionId, Integer questionHits) {
        this.username = username;
        this.questionId = questionId;
        this.questionHits = questionHits;
    }

    public QuestionHits(Integer id,String username, Integer questionId, Integer questionHits) {
        this.username = username;
        this.id = id;
        this.questionId = questionId;
        this.questionHits = questionHits;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionHits() {
        return questionHits;
    }

    public void setQuestionHits(Integer questionHits) {
        this.questionHits = questionHits;
    }
}
