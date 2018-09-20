package com.dharmesh.AW.Assignment1.controller;

import com.dharmesh.AW.Assignment1.JPARepository.StackOverflowPageRepository;
import com.dharmesh.AW.Assignment1.JPARepository.UserPostsCountRepository;
import com.dharmesh.AW.Assignment1.Model.StackOverflowPage;
import com.dharmesh.AW.Assignment1.Model.UserPostsCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin
public class StackoverflowController extends APIKeyCheckController {

    @Autowired
    StackOverflowPageRepository repository;

    @Autowired
    UserPostsCountRepository userPostsCountRepository;

    @RequestMapping(value="/getStackOverflowPage", method= RequestMethod.GET)
        List<StackOverflowPage> getStackOverflowPage(HttpServletRequest request, HttpServletResponse response){

        List<StackOverflowPage> data = repository.findAllByOrderById();
        return data;
    }

    @RequestMapping(value="/postQuestion", method= RequestMethod.POST)
    String PostQuestion(@RequestHeader(value = "description") String description,
                        @RequestHeader(value = "detailedDescription") String detailedDescription,
                        @RequestHeader(value = "userName") String userName,
                        HttpServletRequest request, HttpServletResponse response){
        long time = System.currentTimeMillis();
        UserPostsCount userPostsCount = userPostsCountRepository.findByUserNameAndPostedDate(userName, new Date(time));
        if(userName==null){
            userPostsCountRepository.save(new UserPostsCount(userName,1,new Date(time)));
        }
        else{
            userPostsCount.setPostsCount(userPostsCount.getPostsCount()+1);
            userPostsCountRepository.save(userPostsCount);
        }
        repository.save(new StackOverflowPage(description, detailedDescription, 0,0));
        return "inserted";
    }
    @RequestMapping(value="/postlike", method= RequestMethod.POST)
    String postLike(@RequestHeader(value = "questionId") Integer questionId, HttpServletRequest request, HttpServletResponse response){
        StackOverflowPage record = repository.findByCustomId(questionId);
        record.setVotes(record.getVotes()+1);
        repository.save(record);
        return "inserted";
    }

    @RequestMapping(value="/postdislike", method= RequestMethod.POST)
    String postdislike(@RequestHeader(value = "questionId") Integer questionId, HttpServletRequest request, HttpServletResponse response){
        StackOverflowPage record = repository.findByCustomId(questionId);
        record.setDislikes(record.getDislikes() + 1);
        repository.save(record);
        return "inserted";
    }

    @RequestMapping(value="/getUsersPostsCount", method= RequestMethod.GET)
    List<UserPostsCount> getUsersPostsCount(@RequestHeader(value = "userName") String userName,
            HttpServletRequest request, HttpServletResponse response){

        Calendar currenttime = Calendar.getInstance();
        currenttime.add(Calendar.DATE, -7);
        Date dateBeforeSevenDays = new Date(currenttime.getTime().getTime());
        List<UserPostsCount> result = userPostsCountRepository.findAllByUserNameAndPostedDateAfter(userName, dateBeforeSevenDays);
        return result;
    }

}
