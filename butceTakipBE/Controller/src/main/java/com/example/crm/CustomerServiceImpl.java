package com.example.crm;

import com.example.base.customer.*;
import com.example.base.dto.CheckCustomerResponse;
import com.example.base.dto.CustomerResponse;
import com.example.base.dto.CustomerSaveResponse;
import com.example.base.dto.PaymentResponseList;
import com.example.common.entity.CustomerEntity;
import com.example.common.entity.CustomerEntityRepository;
import com.example.common.entity.PlanDetailEntity;
import com.example.common.entity.PlanDetailEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class CustomerServiceImpl implements ICustomerService {
  @Autowired
  private ICustomerService customerService;
  @Autowired
  private CustomerEntity customerEntity;
  @Autowired
  private CustomerSaveResponse customerSaveResponse;
  @Autowired
  private PlanDetailEntityRepository planDetailEntityRepository;
  @Autowired
  private CustomerEntityRepository customerEntityRepository;


  @Override
  public CustomerSaveResponse saveCustomer(CustomerCreateRequest request) {
    CustomerEntity customerEntity = new CustomerEntity();
    if (Objects.isNull(request)) {
      customerSaveResponse.setOperationResult("Bilgi eksiliğinden kayıt başarısız.");
    } else {
      customerEntity.setName(request.getName());
      customerEntity.setPassword(request.getPassword());
      customerEntity.setUserName(request.getUserName());
      customerEntity.setSurName(request.getSurName());
      customerEntityRepository.save(customerEntity);
      customerSaveResponse.setOperationResult("Kayıt Başarılı");
    }
    return customerSaveResponse;
  }

  @Override
  public CustomerResponse getCustomer(LoginCustomerRequest request) {
    Boolean isLogged;
    CheckCustomerResponse checkCustomerResponse = this.checkCustomer(request);
    CustomerResponse customerResponse = new CustomerResponse();
    isLogged = checkCustomerResponse.getLogged();
    if (isLogged) {

      CustomerEntity customerEntity = customerEntityRepository.findByUserNameAndPassword(request.getUserName(), request.getPassword());
      customerResponse.setName(customerEntity.getName());
      customerResponse.setSurName(customerResponse.getSurName());
      customerResponse.setCustId(customerResponse.getCustId());
    } else {
      return null;
    }
    return customerResponse;

  }

  @Override
  public CheckCustomerResponse checkCustomer(LoginCustomerRequest request) {
    //Customer Tablosuna gidilip giriş kontrolü yaptırılacak.
    CheckCustomerResponse checkCustomerResponse = new CheckCustomerResponse();
    if (Objects.nonNull(request)) {
      CustomerEntity customerEntity = customerEntityRepository.findByUserNameAndPassword(request.getUserName(), request.getPassword());
      if (Objects.nonNull(customerEntity)) {
        checkCustomerResponse.setLogged(true);

      } else {
        checkCustomerResponse.setLogged(false);
      }

    } else {
      checkCustomerResponse.setLogged(false);

    }
    return checkCustomerResponse;
  }

  @Override
  public void savePaymentPlan(CustomerPaymentRequest request) {
    PlanDetailEntity planDetailEntity = new PlanDetailEntity();
    planDetailEntity.setCustId(Long.valueOf(request.getCustId()));
    planDetailEntity.setPaymentType(request.getPaymentType());
    planDetailEntity.setPaymentPlace(request.getPaymentPlace());
    planDetailEntity.setPaymentDesc(request.getPaymentDesc());
    planDetailEntity.setDate(request.getDate());
    planDetailEntity.setPrice(request.getPrice());
    planDetailEntityRepository.save(planDetailEntity);
  }

  @Override
  public List<PlanDetailEntity> paymentList(PaymentRequest request) {
    List<PlanDetailEntity> planDetailList;
    if (Objects.nonNull(request)) {
      planDetailList = planDetailEntityRepository.findByCustId(request.getCustId());
    } else {
      return null;
    }
    return planDetailList;
  }

  public PaymentResponseList netAmount(PaymentRequest request) {
    Double cost = 0.0;
    Double earn = 0.0;
    Double netAmount = 0.0;
    PaymentResponseList paymentResponseList = new PaymentResponseList();
    List<PlanDetailEntity> planDetailList;
    if (Objects.nonNull(request)) {
      planDetailList = planDetailEntityRepository.findByCustId(request.getCustId());
      for (PlanDetailEntity planDetailEntity : planDetailList) {
        if ("Gelir".equalsIgnoreCase(planDetailEntity.getPaymentType())) {
          earn = earn + planDetailEntity.getPrice();
        } else if("Gider".equalsIgnoreCase(planDetailEntity.getPaymentType())) {
          cost = cost + planDetailEntity.getPrice();
        }
      }

      netAmount = earn - cost;
      paymentResponseList.setNetAmount(String.valueOf(netAmount));

    } else {
      return null;
    }
    return paymentResponseList;
  }

  @Override
  public String updatePayment(PaymentUpdateRequest request) {
    String statu = null;
    if (Objects.nonNull(request)) {
      PlanDetailEntity planDetailEntity = planDetailEntityRepository.findByCustIdAndPaymentId(request.getCustId(), request.getPaymentId());
      planDetailEntity.setPaymentType(request.getPaymentType());
      planDetailEntity.setPaymentDesc(request.getDesc());
      planDetailEntity.setPrice(request.getPrice());
      statu = "Güncelleme başarılı";
    } else {
      statu = "Güncelleme başarısız";

    }

    return statu;
  }
}
