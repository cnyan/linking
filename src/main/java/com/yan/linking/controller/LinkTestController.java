package com.yan.linking.controller;


import com.yan.linking.entity.User;
import com.yan.linking.repository.UserRepository;
import com.yan.utils.ResultMsg;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class LinkTestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/index")
    public ModelAndView index(Model model) {

        return new ModelAndView("sales/index", "model", model);
    }

    @RequestMapping("/user")
    public ModelAndView user(Model model) {
        model.addAttribute(userRepository.findAll());
        return new ModelAndView("test/userTest", "model", model);

    }


    @RequestMapping(value = "/userwithid", method = RequestMethod.GET)
    public ResultMsg userWithName(int id) {
        //http://localhost:8080/linking/test/user?id=2
        List<User> userList = userRepository.findUserById(id);
        return new ResultMsg("200", "成功", userList);
    }


    @RequestMapping("/login")
    public ResultMsg login(String username, String password) {

        User user = new User();
        user.setName(username);
        user.setPwd(password);

        return new ResultMsg("200", "成功", user);
    }

    @RequestMapping("/save/user")
    public ResultMsg qureyUser() {
        User u = new User(0, "00", "000");
        User u1 = new User(1, "11", "111");
        User u2 = new User(2, "22", "222");
        User u3 = new User(3, "33", "333");
        User u4 = new User(4, "44", "444");
        User u5 = new User(5, "55", "555");
        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5);
        userRepository.saveAll(userList);
        return new ResultMsg("200", "成功", userList);
    }

}
