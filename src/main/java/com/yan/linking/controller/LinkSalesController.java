package com.yan.linking.controller;


import com.yan.linking.entity.User;
import com.yan.linking.repository.UserRepository;
import com.yan.utils.ResultMsg;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class LinkSalesController {

    @Autowired
    private UserRepository userRepository;

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
    public ResultMsg qureyUser() {
        User u = new User(1, "11", "111");
        User ru = userRepository.save(u);
        System.out.println(ru);
        return new ResultMsg("200", "成功", ru);
    }

}
