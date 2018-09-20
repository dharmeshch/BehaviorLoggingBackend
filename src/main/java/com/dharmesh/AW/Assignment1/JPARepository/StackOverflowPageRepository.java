package com.dharmesh.AW.Assignment1.JPARepository;

import com.dharmesh.AW.Assignment1.Model.StackOverflowPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackOverflowPageRepository extends JpaRepository<StackOverflowPage, Integer> {

    @Query(value = "select * from stackoverflow where id=?1", nativeQuery = true)
    StackOverflowPage findByCustomId(Integer id);

    List<StackOverflowPage>  findAllByOrderById();
}
