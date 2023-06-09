package com.pratyush.IMS.restcontroller;

import com.pratyush.IMS.dao.ProductDao;
import com.pratyush.IMS.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/allProduct", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Product> getAllProduct() {
        List<Product> listProduct = productDao.getAllProduct();
        return listProduct;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Product getProduct(@PathVariable("id") String id) {
        Product product = productDao.getProduct(Integer.parseInt(id));
        return product;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST, headers = "Accept=application/json")
    public Product saveProduct(Product p) {
        productDao.saveProduct(p);
        return p;
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product p) {
        productDao.updateProduct(p);
        return p;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public Product delteProduct(@PathVariable("id") String id) {
        productDao.deleteProduct(Integer.parseInt(id));
        Product p = new Product();
        return p;
    }

}
