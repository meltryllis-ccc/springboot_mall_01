package com.meltryllis.springbootmall.controller;

import com.meltryllis.springbootmall.entities.Commodity;
import com.meltryllis.springbootmall.entities.Product;
import com.meltryllis.springbootmall.mapper.ProductMapper;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin2.main.server.Plugin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.Array;
import java.util.*;

/**
 * @author Ereshkigal
 * @date 2019/10/14 - 17:46
 */

@Controller
//@RestController
public class ProductController {

    @Autowired
    ProductMapper productMapper;

    @GetMapping("/index")
    public String productList(Map<String,Object> map){
        System.out.println("进入后台首页");
        List<Product> list = productMapper.productList();
        map.put("productList",list);

        return "dashboard";
    }

    @GetMapping("/userindex")
    public String userProductList(Map<String,Object> map){
        List<Product> list = productMapper.productList();
        map.put("productList",list);

        return "userindex";
    }

    @GetMapping("/forwardto")
    public String forwardto(Model model){

        List<String> commodity = productMapper.selectCategory();
        model.addAttribute("commodity",commodity);
        return "addproduct";
    }

    @RequestMapping(value = "/addpruduct", method = RequestMethod.POST)
    public String addPruduct(String pName,
                             String category,
                             String info,
                             Float price,
                             MultipartFile pic,
                             Map<String,Object> map,
                             HttpServletRequest request,
                             HttpSession session) throws Exception {

        System.out.println("img = " + pic);

        Product product = new Product();
        // String path = "d:/java";//这样写不安全
        String path = session.getServletContext().getRealPath("D:\\work_space\\springboot\\springboot-mall\\src\\main\\resources\\images");
        if (pic.getSize() > 0) {//img不会等null需要使用getsize()判定是否为空
            //获取上传文件的原始名称
            String filename = pic.getOriginalFilename();
            // 生成文件新的名字
            String newFileName = UUID.randomUUID() + filename;

            if (filename.endsWith("jpg") || filename.endsWith("png") || filename.endsWith("gif")) {
                File file = new File(path, newFileName);
                pic.transferTo(file);

                // 保存到数据库
                product.setpName(pName);
                product.setCategory(category);
                product.setInfo(info);
                product.setPrice(price);
                product.setImage("/images/" + newFileName);
                product.setDetails(request.getParameter("editorValue"));

                productMapper.insertDept(product);

                map.put("msg","添加商品成功");
                map.put("html",request.getParameter("editorValue"));

                System.out.println("html文件" + request.getParameter("editorValue"));
                return "addproduct";

            }
            map.put("msg","上传图片格式不对");
            return "addproduct";
        }
        map.put("msg","没有选中图片");
        return "addproduct";

    }

    @RequestMapping("/productDetails/{id}")
    public String productDetails(@PathVariable ("id") Integer id,Map<String,Object> map){

        Product product = productMapper.productDetails(id);
        map.put("product",product);
        return "details";
    }

    @GetMapping("productDetails/deleted/{id}")
    public String deleted(@PathVariable("id") Integer id){
        productMapper.deleted(id);

        return  "redirect:/index";
    }

    @GetMapping("productDetails/updata/{id}")
    public String updata(@PathVariable("id") Integer id,Map<String,Object> map,Model model){

        Product product = productMapper.productDetails(id);
        map.put("product",product);
        List<String> commodity = productMapper.selectCategory();
        model.addAttribute("commodity",commodity);
        return  "updata";
    }

    @RequestMapping(value = "/uppruduct", method = RequestMethod.POST)
    public String updataProduct(Integer id,
                             String pName,
                             String category,
                             String info,
                             Float price,
                             MultipartFile pic,
                             Map<String,Object> map,
                             HttpServletRequest request,
                             HttpSession session) throws Exception {

        Product product = new Product();
        String path = session.getServletContext().getRealPath("D:\\work_space\\springboot\\springboot-mall\\src\\main\\resources\\images");
        if (pic.getSize() > 0) {//img不会等null需要使用getsize()判定是否为空
            //获取上传文件的原始名称
            String filename = pic.getOriginalFilename();
            // 生成文件新的名字
            String newFileName = UUID.randomUUID() + filename;

            if (filename.endsWith("jpg") || filename.endsWith("png") || filename.endsWith("gif")) {
                File file = new File(path, newFileName);
                pic.transferTo(file);

                // 保存到数据库
                product.setId(id);
                product.setpName(pName);
                product.setCategory(category);
                product.setInfo(info);
                product.setPrice(price);
                product.setImage("/images/" + newFileName);
                product.setDetails(request.getParameter("editorValue"));

                productMapper.updateProduct(product);

                map.put("msg","商品信息修改成功");

                return "addproduct";

            }
            map.put("msg","上传图片格式不对");
            return "addproduct";
        }

        // 保存到数据库

        product.setId(id);
        product.setpName(pName);
        product.setCategory(category);
        product.setInfo(info);
        product.setPrice(price);
        product.setDetails(request.getParameter("editorValue"));

        System.out.println("详细信息" + request.getParameter("editorValue"));
        productMapper.updateProductNoImage(product);

        map.put("msg","商品信息修改成功");

        return "addproduct";
    }
}
