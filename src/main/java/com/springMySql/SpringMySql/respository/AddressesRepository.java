package com.springMySql.SpringMySql.respository;

import com.springMySql.SpringMySql.entity.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepository extends JpaRepository<Addresses, Long> {
}
