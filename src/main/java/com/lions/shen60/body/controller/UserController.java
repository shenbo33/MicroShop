package com.lions.shen60.body.controller;

import com.lions.shen60.body.entity.SysUser;
import com.lions.shen60.body.service.UserService;
import com.lions.shen60.header.common.Enums.ResultEnum;
import com.lions.shen60.header.common.VO.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/sysUser")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name")String name){
        return " 你好 ~ 朋友 ~ " + name;
    }

    @PostMapping(value = "/addUser")
    public Map<String, Object> addUser(SysUser user){
        SysUser data = new SysUser();
        try{
            data = userService.addUser(user);
        }catch (Exception e){
            ResultVO.result(ResultEnum.FAILURE, e.getMessage(),false);
        }
        return ResultVO.result(ResultEnum.SUCCESS, data,true);
    }
}
