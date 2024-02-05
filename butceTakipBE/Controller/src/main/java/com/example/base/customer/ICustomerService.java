package com.example.base.customer;


import com.example.base.dto.CheckCustomerResponse;
import com.example.base.dto.CustomerResponse;
import com.example.base.dto.CustomerSaveResponse;
import com.example.base.dto.PaymentResponseList;
import com.example.common.entity.PlanDetailEntity;

import java.util.List;

public interface ICustomerService {


  CustomerSaveResponse saveCustomer(CustomerCreateRequest request);

  CustomerResponse getCustomer(LoginCustomerRequest request);

  CheckCustomerResponse checkCustomer(LoginCustomerRequest request);

  void savePaymentPlan(CustomerPaymentRequest request);

  List<PlanDetailEntity> paymentList (PaymentRequest request);
  PaymentResponseList netAmount(PaymentRequest request);
  String updatePayment(PaymentUpdateRequest request);

}
