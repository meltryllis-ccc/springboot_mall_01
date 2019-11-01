package com.meltryllis.springbootmall.controller;

import com.meltryllis.springbootmall.entities.User;
import com.meltryllis.springbootmall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Ereshkigal
 * @date 2019/10/14 - 10:54
 */
@Controller
public class LoginController {


    @Autowired
    UserMapper userMapper;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){

        User user = userMapper.login(username,password);

        if ("admin".equals(username) && "123456".equals(password)){
            //登录成功,防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
//            return "redirect:/main.html";
            return "redirect:/index";
        }else if (user != null){
            session.setAttribute("userId",user.getId());
            session.setAttribute("loginUser",username);
            return "redirect:/userindex";
        }else {
            //登陆失败
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
