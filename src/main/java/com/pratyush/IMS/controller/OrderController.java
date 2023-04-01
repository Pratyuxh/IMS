package com.pratyush.IMS.controller;

import com.pratyush.IMS.dao.CustomerDao;
import com.pratyush.IMS.dao.OrderDao;
import com.pratyush.IMS.dao.OrderDetailsDao;
import com.pratyush.IMS.dao.ProductDao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
    @Controller
    public class OrderController {

        @Autowired
        private OrderDao orderDao;
        @Autowired
        private OrderDetailsDao orderDetailsDao;
        @Autowired
        private ProductDao productDao;
        @Autowired
        private CustomerDao customerDao;

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String indexPage(ModelMap modelMap, HttpServletRequest request) {
            modelMap.addAttribute("orderNo", orderDao.getOrderNo());
            modelMap.addAttribute("products", productDao.getAllProduct());
            modelMap.addAttribute("customers", customerDao.getAllCustomer());
            modelMap.addAttribute("em", request.getParameter("em"));
            return "index";
        }

    }

