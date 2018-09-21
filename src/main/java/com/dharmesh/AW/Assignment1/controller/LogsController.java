package com.dharmesh.AW.Assignment1.controller;

import com.dharmesh.AW.Assignment1.JPARepository.*;
import com.dharmesh.AW.Assignment1.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class LogsController extends APIKeyCheckController{

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    loginRepository repository;

    @Autowired
    LoginHistoryRepository loginHistoryRepository;

    @Autowired
    QuestionViewTimeRepository questionViewTimeRepository;

    @Autowired
    QuestionHitsRepository questionHitsRepository;

    @Autowired
    StackOverflowPageRepository stackOverflowPageRepository;


    @RequestMapping(value="/getUserDetails", method= RequestMethod.GET)
    public Login getUsers(@RequestHeader(value = "userName") String userName,
                                HttpServletRequest request, HttpServletResponse response){

        Login userDetails = repository.findByUserName(userName);
        response.setStatus(HttpServletResponse.SC_OK);
        return userDetails;
    }

    @RequestMapping(value="/getLoginHistory", method = RequestMethod.GET)
    public List<LoginHistory> getLoginHistory(@RequestHeader(value = "userName") String userName){
        Login login = repository.findByUserName(userName);
        List<LoginHistory> result = loginHistoryRepository.findTop10ByUserIdOrderByIdDesc(login.getId());
        return result;
    }

    @RequestMapping(value="/logQuestionViewTime", method = RequestMethod.POST)
    public String logQuestionViewTime(@RequestHeader(value = "userName") String userName,
                                                  @RequestHeader(value = "duration") Integer duration,
                                                  @RequestHeader(value = "questionId") Integer questionId){
        questionViewTimeRepository.save(new QuestionViewTime(userName, duration, questionId));
        return "logged";
    }

    @RequestMapping(value="/getQuestionViewTime", method = RequestMethod.GET)
    public List<Object[]> getQuestionViewTime(@RequestHeader(value = "userName") String userName){

        //List<QuestionViewTime> result = questionViewTimeRepository.;
        Query query = entityManager.createNativeQuery("select question_id, avg(duration) from question_view_time where username=? group by question_id order by question_id;");
        query.setParameter(1,userName);
        List<Object[]> result = query.getResultList();
        return result;
    }

    @RequestMapping(value="/logQuestionHits", method = RequestMethod.POST)
    public String logQuestionhits(@RequestHeader(value = "userName") String userName,
                                      @RequestHeader(value = "questionId") Integer questionId){
        QuestionHits hits = questionHitsRepository.findByUsernameAndQuestionId(userName,questionId);
        if(hits==null){
            questionHitsRepository.save(new QuestionHits(userName,questionId,1));
            return "logged";
        }
        else {
            hits.setQuestionHits(hits.getQuestionHits()+1);
            questionHitsRepository.save(hits);
            return "logged";
        }
    }

    @RequestMapping(value="/getQuestionHits", method = RequestMethod.GET)
    public List<QuestionHits> getQuestionHits(@RequestHeader(value = "userName") String userName){
        List<QuestionHits> hits = questionHitsRepository.findAllByUsernameOrderByQuestionId(userName);
        return hits;
    }

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public void check(){
        System.out.println("HelloWorld!");
    }
}
