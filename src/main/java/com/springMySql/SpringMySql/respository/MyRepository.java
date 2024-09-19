package com.springMySql.SpringMySql.respository;

import com.springMySql.SpringMySql.entity.StudentObj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<StudentObj, Integer> {
}
