package com.dharmesh.AW.Assignment1.Model;

import javax.persistence.*;

@Entity
@Table(name = "stackoverflow")
public class StackOverflowPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "question")
    String question;

    @Column(name = "detailed_question")
    String detailedQuestion;

    @Column(name = "votes")
    Integer votes;

    @Column(name = "dislikes")
    Integer dislikes;

    public StackOverflowPage(){

    }
    public StackOverflowPage(String question, String detailedQuestion, Integer votes, Integer dislikes) {
        this.question = question;
        this.detailedQuestion = detailedQuestion;
        this.votes = votes;
        this.dislikes = dislikes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDetailedQuestion() {
        return detailedQuestion;
    }

    public void setDetailedQuestion(String detailedQuestion) {
        this.detailedQuestion = detailedQuestion;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }
}
