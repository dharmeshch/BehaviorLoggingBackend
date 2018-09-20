package com.dharmesh.AW.Assignment1.controller;

import com.dharmesh.AW.Assignment1.JPARepository.BookmarkedRepository;
import com.dharmesh.AW.Assignment1.Model.Bookmarked;
import com.dharmesh.AW.Assignment1.Model.StackOverflowPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
public class BookmarkedController extends APIKeyCheckController {

    @Autowired
    BookmarkedRepository bookmarkedRepository;

    @RequestMapping(value="/getBookmarked", method= RequestMethod.GET)
    List<Bookmarked> getBookmarked(@RequestHeader(value = "userName") String userName){
        List<Bookmarked>result =  bookmarkedRepository.findAllByUserName(userName);
        return result;
    }
    @RequestMapping(value="/BookmarkQuestion", method= RequestMethod.POST)
    String postBookmarked(@RequestHeader(value = "userName") String userName,
                          @RequestHeader(value = "questionId") Integer questionId){
        bookmarkedRepository.save(new Bookmarked(userName,questionId));
        return "Bookmarked";
    }
    @RequestMapping(value="/removeBookmark", method= RequestMethod.POST)
    String removeBookmark(@RequestHeader(value = "userName") String userName,
                          @RequestHeader(value = "questionId") Integer questionId){
        bookmarkedRepository.deleteByUserNameAndAndQuestionId(userName,questionId);
        return "removed";
    }
}
