package com.pratyush.IMS.restcontroller;

import com.pratyush.IMS.dao.CustomerDao;
import com.pratyush.IMS.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    private CustomerDao customerDao;
    
    @RequestMapping(value = "/allCustomer", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Customer> getAllCustomer(){
        return customerDao.getAllCustomer();
    }
    
}
