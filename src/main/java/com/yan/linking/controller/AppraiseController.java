package com.yan.linking.controller;


import com.yan.linking.entity.AppraiseUser;
import com.yan.linking.entity.ErrorMsg;
import com.yan.linking.entity.User;
import com.yan.linking.entity.UserGrade;
import com.yan.linking.repository.AppraiseUserGradeRepository;
import com.yan.linking.repository.AppraiseUserRepository;
import com.yan.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@RestController
@RequestMapping("/appraise")
public class AppraiseController {

    @Autowired
    AppraiseUserRepository appraiseUserRepository;
    @Autowired
    AppraiseUserGradeRepository appraiseUserGradeRepository;

    @RequestMapping("/index")
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("appraise/index");

        modelAndView.addObject("error", new ErrorMsg());
        return modelAndView;
    }

    @RequestMapping("login")
    public ModelAndView login(String name) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(name);
        List<AppraiseUser> appraiseUsers = appraiseUserRepository.findAppraiseUserByName(name);
        System.out.println(appraiseUsers);
        if (appraiseUsers.size() == 1) {
            AppraiseUser user = appraiseUsers.get(0);

            if (user.getIsApprise() == 0) {
                // 主页面

                modelAndView.setViewName("appraise/main");
                modelAndView.addObject("user", user);
                //被评分
                // 用户列表
                List<AppraiseUser> appraiseUsers1 = (List<AppraiseUser>) appraiseUserRepository.findAll();
                modelAndView.addObject("userList", appraiseUsers1);
                modelAndView.addObject("userGrade", new UserGrade());

                modelAndView.addObject("error", new ErrorMsg("error", ""));

                return modelAndView;
            } else {
                modelAndView.setViewName("appraise/index");
                modelAndView.addObject("error", new ErrorMsg("error", "已经做出评价，请勿重复评价，如果存在问题请联系管理员"));
                return modelAndView;
            }


        } else {

            modelAndView.setViewName("appraise/index");
            modelAndView.addObject("error", new ErrorMsg("error", "用户"+name+"不存在"));
            return modelAndView;
        }

    }

    @RequestMapping(value = "/save_grade", method = RequestMethod.POST)
    public ModelAndView saveGrade(@ModelAttribute UserGrade userGrade) {
        //System.out.println("保存数据测试代码");
        //System.out.println(userGrade);

        ModelAndView modelAndView = new ModelAndView();
        int reVlue = objectIsNull(userGrade);
        List<AppraiseUser> users = appraiseUserRepository.findAppraiseUserById(userGrade.getUserId());

        if (users.size() != 1) {

            modelAndView.setViewName("appraise/index");
            modelAndView.addObject("error", new ErrorMsg("error", "用户账户发生未知错误1，请重新登录"));
            return modelAndView;
        }
        //获取给出评分人员的信息
        AppraiseUser user = users.get(0);

        switch (reVlue) {

            case 0:
                //验证数据成功
                try {
                    //保存用户数据
                    modelAndView.setViewName("appraise/success");
                    List<UserGrade> oldUserGrades = appraiseUserGradeRepository.findUserGradeByUserId(userGrade.getUserId());

                    if(oldUserGrades.size()!=0){
                        UserGrade oldUserGrade = oldUserGrades.get(0);
                        userGrade.setId(oldUserGrade.getId());
                    }
                    appraiseUserGradeRepository.save(userGrade);

                    user.setIsApprise(1);
                    appraiseUserRepository.save(user);

                    return modelAndView;
                } catch (Exception exc) {
                    modelAndView.setViewName("appraise/index");
                    modelAndView.addObject("error", new ErrorMsg("error", "用户发生未知错误2，请重新登录"));
                    return modelAndView;
                }

            case 1:
                // 存在空值
                modelAndView.setViewName("appraise/main");
                modelAndView.addObject("user", user);
                //被评分
                // 用户列表
                List<AppraiseUser> appraiseUsers1 = (List<AppraiseUser>) appraiseUserRepository.findAll();
                modelAndView.addObject("userList", appraiseUsers1);
                modelAndView.addObject("userGrade", userGrade);
                modelAndView.addObject("error", new ErrorMsg("error", "存在未评分的数据"));
                return modelAndView;
            case 2:
                /*
                大于20存在空值
                */
                modelAndView.setViewName("appraise/main");
                modelAndView.addObject("user", user);
                //被评分 用户列表
                List<AppraiseUser> appraiseUsers2 = (List<AppraiseUser>) appraiseUserRepository.findAll();
                modelAndView.addObject("userList", appraiseUsers2);
                modelAndView.addObject("userGrade", userGrade);
                modelAndView.addObject("error", new ErrorMsg("error", "数据范围是0~20，存在异常数据"));
                return modelAndView;
            default:
                modelAndView.setViewName("appraise/index");
                modelAndView.addObject("error", new ErrorMsg("error", "用户发生未知错误3，请重新登录"));
                return modelAndView;
        }
    }


    // 修改用户信息（是否评分）
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ResultMsg saveUser(@RequestParam("id") String id,@RequestParam("name") String name) {

        int userId = Integer.parseInt(id);
        AppraiseUser user = new AppraiseUser(userId, name, 0, 0);
        return new ResultMsg("200", "success", appraiseUserRepository.save(user));

    }

    //管理员查看全部信息
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public ModelAndView manager(@RequestParam("name") String name) {
        if (name.equals("yanjilong")) {
            //System.out.println(name);
            List<UserGrade> userGrades = (List<UserGrade>) appraiseUserGradeRepository.findAll();

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("appraise/manager");
            modelAndView.addObject("userGrades", userGrades);

            return modelAndView;
        }

        return null;
    }

    //删除一条用户评分记录
    @RequestMapping(value= "/manager/remove",method = RequestMethod.GET)
    public ResultMsg removeRecord(@RequestParam("id") String id){

        // 如果数组为0 ，说明该记录不存在
        List<UserGrade> userGrades= appraiseUserGradeRepository.findUserIdByUserGradeId(Integer.parseInt(id));

        if(userGrades.size()!=0) {
            //删除记录
            appraiseUserGradeRepository.deleteById(Integer.parseInt(id));

            //找到已评分的用户，并重置该用户的评分状态
            UserGrade userGrade = userGrades.get(0);
            AppraiseUser user = appraiseUserRepository.findAppraiseUserById(userGrade.getUserId()).get(0);
            user.setIsApprise(0);
            appraiseUserRepository.save(user);

            return new ResultMsg("200", "success","remove grade id");
        }

        return new ResultMsg("500", "faild","have an error");
    }


    /**
     * 检测用户上传数据对象，是否存在空值以及超过20的
     *
     * @param obj
     * @return 0 正确，1 数值为空，2数值大于20
     */
    private static int objectIsNull(Object obj) {

        // 获取f对象对应类中的所有属性域
        Field[] fields = getAllFields(obj);
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();

            if (varName.equals("userId") || varName.equals("id")){
                continue;
            }
            // 获取在对象f中属性fields[i]对应的对象中的变量
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o = fields[i].get(obj);
                if (o.toString().equals(""))
                    return 1;
                else if (Float.parseFloat(o.toString()) > 20 || Float.parseFloat(o.toString()) < 0) {

                    return 2;
                }
                // System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 返回对象的Field（包括私有的和父类的）
     */
    public static Field[] getAllFields(Object object) {
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }



}
