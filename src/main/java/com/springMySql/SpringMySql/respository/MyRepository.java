package com.springMySql.SpringMySql.respository;

import com.springMySql.SpringMySql.entity.MyTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<MyTable, Integer> {
}
