package com.lions.shen60.body.controller;

import com.lions.shen60.body.entity.User;
import com.lions.shen60.body.service.UserService;
import com.lions.shen60.header.model.protocol.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name")String name){
        return " 你好 ~ 朋友 ~ " + name;
    }

    @PostMapping(value = "/addUser")
    public NetResult addUser(NetResult res, User user){
        res.setData(userService.addUser(user));
        return res;
    }
}
