package com.dharmesh.AW.Assignment1.JPARepository;

import com.dharmesh.AW.Assignment1.Model.Bookmarked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkedRepository extends JpaRepository<Bookmarked, Integer> {
    List<Bookmarked> findAllByUserName(String userName);
    void deleteByUserNameAndAndQuestionId(String userName, Integer questionId);
}
