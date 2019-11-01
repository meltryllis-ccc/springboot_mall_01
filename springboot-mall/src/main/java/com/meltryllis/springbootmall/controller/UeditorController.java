package com.meltryllis.springbootmall.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author Ereshkigal
 * @date 2019/10/17 - 15:43
 */
@Controller
public class UeditorController {

//    @RequestMapping("/")
//    private String showPage(){
//        return "index";
//    }

    @RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/upload")
    public String upload(HttpServletRequest request, Map<Object,String> map){
        String html = request.getParameter("editorValue");
        request.setAttribute("edit", html);
        System.out.println(html);
        map.put("msg",html);
        return "success";
    }
}
