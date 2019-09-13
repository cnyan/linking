package com.yan.linking.controller;


import com.yan.entity.User;
import com.yan.utils.ResultMsg;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sales")
public class LinkSalesController {

    @RequestMapping("/index")
    public ModelAndView index(Model model) {

        return new ModelAndView("sales/index", "model", model);
    }


    @RequestMapping("/login")
    public ResultMsg login(String username, String password) {

        User user = new User();
        user.setName(username);
        user.setPwd(password);

        return new ResultMsg("200", "成功", user);
    }

    @RequestMapping("/query/user")
    public ResultMsg qureyUser(){
        return null;
    }

}
