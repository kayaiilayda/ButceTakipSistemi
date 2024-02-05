package com.example.common.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long> {

  @Query("select c from CustomerEntity where CustomerEntity.userName=:userName and CustomerEntity.password=: passWord")
  CustomerEntity findByUserNameAndPassword (@Param("userName") String userName, @Param("password") String password);

}