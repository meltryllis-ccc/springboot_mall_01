package com.meltryllis.springbootmall.controller;

import com.meltryllis.springbootmall.entities.Cart;
import com.meltryllis.springbootmall.entities.CartView;
import com.meltryllis.springbootmall.entities.Product;
import com.meltryllis.springbootmall.mapper.CartMapper;
import com.meltryllis.springbootmall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

/**
 * @author Ereshkigal
 * @date 2019/10/23 - 19:19
 */

@Controller
public class CartController {

    @Autowired
    CartMapper cartMapper;
    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/insertCart/{id}")
    public void insertCart (@PathVariable("id") Integer id, HttpSession session){


        Integer userId = (Integer) session.getAttribute("userId");
        Integer pNum = cartMapper.pNum(userId, id);
        if (pNum == null){
            pNum = 1;

            Cart cart = new Cart();

            cart.setUserid(userId);
            cart.setPid(id);
            cart.setNum(pNum);

            cartMapper.insertCart(cart);
        }else {
            Cart cart = new Cart();

            cart.setUserid(userId);
            cart.setPid(id);
            cart.setNum(++pNum);

            cartMapper.updatePNum(cart);
        }
    }

    @RequestMapping("cartPage/")
    public String cartPage(Map<String,Object> map , HttpSession session){

        Integer id = (Integer) session.getAttribute("userId");

        List<CartView> list = cartMapper.cartPage(id);
        map.put("cartList",list);

        return "cartPage";
    }

//    @ResponseBody
//    @RequestMapping("cartPage/{id}")
//    public List<CartView> cartPage(@PathVariable("id") Integer id, Map<String,Object> map){
//        System.out.println(id + "的购物车");
//
//        List<CartView> list = cartMapper.cartPage(id);
//        map.put("cartList",list);
//
//        System.out.println("查询到购物车信息");
//
//        return list;
//    }

    @RequestMapping("cartPage/userProductDetails/{id}")
    public String cartProduct(@PathVariable("id") Integer id){

        return "redirect:/userProductDetails/" + id;
    }

    @PostMapping("/increase/{id}")
        public String increasePNum(@PathVariable("id") Integer id){

        return "redirect:/insertCart/" + id;
    }

    @ResponseBody
    @PostMapping("/reduce/{id}")
        public void reducePNum(@PathVariable("id") Integer id,HttpSession session){

        Integer userId = (Integer) session.getAttribute("userId");
        Integer pNum = cartMapper.pNum(userId, id);
            Cart cart = new Cart();

            cart.setUserid(userId);
            cart.setPid(id);
            cart.setNum(--pNum);

            cartMapper.updatePNum(cart);

    }

    @RequestMapping("/removecart/{id}")
        public String removeCart(@PathVariable("id") String id,HttpSession session){

        System.out.println("要移除的商品id" + id);
        cartMapper.removeProduct(id);

        Integer userId = (Integer) session.getAttribute("userId");
        return "redirect:/cartPage/" + userId;
    }

    @ResponseBody
    @PostMapping("/removecart/{id}")
        public void removeCarts(@PathVariable("id") String id, HttpSession session){

        String[] aid = id.split(",");
        for (int i=0; i<aid.length;i++){
            cartMapper.removeProduct(aid[i]);
            System.out.println("移除商品" + i);
        }
//        cartMapper.removeProduct(id);

//        Integer userId = (Integer) session.getAttribute("userId");
//        return "redirect:/cartPage/" + userId;
    }
}
