import com.example.base.customer.*;
import com.example.base.dto.CheckCustomerResponse;
import com.example.base.dto.CustomerResponse;
import com.example.base.dto.CustomerSaveResponse;
import com.example.base.dto.PaymentResponseList;
import com.example.common.entity.PlanDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class ButceTakipController {

  @Autowired
  private ICustomerService customerService;


  @PostMapping("/saveCustomer")
  public CustomerSaveResponse saveCustomer(@RequestBody CustomerCreateRequest request) {
    return customerService.saveCustomer(request);
  }

  @PostMapping("/getCustomer")
  public CustomerResponse customerResponse(@RequestBody LoginCustomerRequest request) {
    return customerService.getCustomer(request);
  }

  @PostMapping("/checkCustomer")
  public CheckCustomerResponse checkCustomer(@RequestBody LoginCustomerRequest request) {
    return customerService.checkCustomer(request);
  }

  @PostMapping("/saveDetail")
  public void savePayment(@RequestBody CustomerPaymentRequest request) {
    customerService.savePaymentPlan(request);
  }

  @PostMapping("/getPayment")
  public List<PlanDetailEntity> getPayment(@RequestBody PaymentRequest request) {
   return customerService.paymentList(request);
  }
  @PostMapping("/getNetAmount")
  public PaymentResponseList netAmount(@RequestBody PaymentRequest request) {
    return customerService.netAmount(request);
  }

  @PostMapping("/updatePayment")
  public String updatePayment(@RequestBody PaymentUpdateRequest request) {
    return customerService.updatePayment(request);
  }

}
