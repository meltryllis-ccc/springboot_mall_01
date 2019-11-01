package com.meltryllis.springbootmall.controller;

import com.meltryllis.springbootmall.entities.Product;
import com.meltryllis.springbootmall.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Ereshkigal
 * @date 2019/10/22 - 17:15
 */
@Controller
public class UserController {

    @Autowired
    ProductMapper productMapper;

    @RequestMapping("userProductDetails/{id}")
    public String productDetails(@PathVariable("id") Integer id, Map<String,Object> map){

        System.out.println("到后台" + id);
        Product product = productMapper.productDetails(id);
        map.put("product",product);
        return "userDetails";
    }
}
