package com.springMySql.SpringMySql.respository;

import com.springMySql.SpringMySql.entity.UserValidity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserValidityRepository extends JpaRepository<UserValidity, Long> {

    List<UserValidity> getUserValidityByIsValid(int isValid);
}
