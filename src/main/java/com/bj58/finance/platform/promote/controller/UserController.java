package com.bj58.finance.platform.promote.controller;


import com.alibaba.fastjson.JSONObject;
import com.bj58.finance.platform.promote.db.pojo.TUser;
import com.bj58.finance.platform.promote.db.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testMysql")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public String GetUser(){
        TUser user = userService.getUser(1);
        log.info("查询结果为{}",JSONObject.toJSONString(user));
        return user.toString();
    }


}
