package com.dharmesh.AW.Assignment1.JPARepository;

import com.dharmesh.AW.Assignment1.Model.QuestionViewTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionViewTimeRepository extends JpaRepository<QuestionViewTime, Integer> {
    List<QuestionViewTime> findAllByUsername(String userName);
}
