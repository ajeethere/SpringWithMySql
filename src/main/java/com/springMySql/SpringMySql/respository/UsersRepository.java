package com.springMySql.SpringMySql.respository;

import com.springMySql.SpringMySql.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
