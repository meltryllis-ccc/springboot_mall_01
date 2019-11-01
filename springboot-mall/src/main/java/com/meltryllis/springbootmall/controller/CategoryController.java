package com.meltryllis.springbootmall.controller;

import com.meltryllis.springbootmall.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ereshkigal
 * @date 2019/10/21 - 10:48
 */
@Controller
public class CategoryController {

    @Autowired
    ProductMapper productMapper;

    @ResponseBody
    @GetMapping("/categorylist/{category}")
    public List categoryList(@PathVariable("category")String category){

        List<String> commodity = productMapper.selectSubCategory(category);
        return commodity;
    }

    @ResponseBody
    @GetMapping("productDetails/updata/categorylist/{category}")
    public List categorysList(@PathVariable("category")String category){

        List<String> commodity = productMapper.selectSubCategory(category);
        return commodity;
    }
}
