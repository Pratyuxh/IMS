package com.pratyush.IMS.restcontroller;

import com.pratyush.IMS.dao.OrderDetailsDao;
import com.pratyush.IMS.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsRestController {

    @Autowired
    private OrderDetailsDao orderDetailsDao;
    
    @RequestMapping(value = "/getAllOrderDetails", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<OrderDetails> getAllOrderDetails(){
        return orderDetailsDao.getAllOrderDetails();
    }
    
    
    @RequestMapping(value = "/getOdDetailsByOID/{oid}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<OrderDetails> getOdDetailsByOID(@PathVariable("oid") String oid){
        return orderDetailsDao.getAllOrderDetailsByOrderID(Integer.parseInt(oid));
    }
    
    
    
    @RequestMapping(value = "/orderdetail", method = RequestMethod.POST)
    public OrderDetails saveOrderDetails(@RequestBody OrderDetails orderDetails) {
        orderDetailsDao.saveOrderDetails(orderDetails);
        return orderDetails;
    }
    
}
