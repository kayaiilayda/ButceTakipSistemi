package com.example.common.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanDetailEntityRepository extends JpaRepository<PlanDetailEntity, Long> {

  @Query ("select p from PlanDetailEntity p WHERE p.custId=: custId")
  List<PlanDetailEntity> findByCustId (@Param("custId") String custId);

  @Query ("select p from PlanDetailEntity p WHERE p.custId=: custId and p.id=: id")
  PlanDetailEntity  findByCustIdAndPaymentId (@Param("custId") String custId, @Param("id") String id);
}