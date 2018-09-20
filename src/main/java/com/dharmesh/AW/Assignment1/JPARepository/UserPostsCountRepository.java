package com.dharmesh.AW.Assignment1.JPARepository;

import com.dharmesh.AW.Assignment1.Model.UserPostsCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UserPostsCountRepository extends JpaRepository<UserPostsCount, Integer> {
    UserPostsCount findByUserNameAndPostedDate(String userName, Date postedDate);
    List<UserPostsCount> findAllByUserNameAndPostedDateAfter(String userName, Date postedDate);
}
