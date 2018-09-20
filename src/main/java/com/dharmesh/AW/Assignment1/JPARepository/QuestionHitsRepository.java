package com.dharmesh.AW.Assignment1.JPARepository;

import com.dharmesh.AW.Assignment1.Model.QuestionHits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionHitsRepository extends JpaRepository<QuestionHits, Integer> {
    QuestionHits findByQuestionId(Integer questionId);
    List<QuestionHits> findAllByUsernameOrderByQuestionId(String userName);
}
