package com.dharmesh.AW.Assignment1.JPARepository;

import com.dharmesh.AW.Assignment1.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface loginRepository extends JpaRepository<Login, Integer> {

    Login findByUserName(String userName);
}
