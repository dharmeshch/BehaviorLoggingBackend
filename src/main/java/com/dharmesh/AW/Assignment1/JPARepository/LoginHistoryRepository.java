package com.dharmesh.AW.Assignment1.JPARepository;

import com.dharmesh.AW.Assignment1.Model.LoginHistory;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Integer> {
    List<LoginHistory> findAllByUserId(Integer userId);
    List<LoginHistory> findTop10ByUserIdOrderByIdDesc(Integer userId);
}
