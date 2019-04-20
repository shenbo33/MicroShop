package com.lions.shen60.header.common.security;

import com.alibaba.fastjson.JSON;
import com.lions.shen60.body.entity.SysUser;
import com.lions.shen60.header.common.Enums.ResultEnum;
import com.lions.shen60.header.common.VO.ResultVO;
import com.lions.shen60.header.common.utils.AccessAddressUtil;
import com.lions.shen60.header.common.utils.JwtTokenUtil;
import com.lions.shen60.header.common.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// TODO: 2019/4/18 用户登录成功时返回给前端的数据
@Component
@Slf4j
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Value("${token.expirationSeconds}")
    private int expirationSeconds;

    @Value("${token.validTime}")
    private int validTime;

    private RedisUtil redisUtil;

    @Autowired
    public AjaxAuthenticationSuccessHandler(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        //获取请求的ip地址
        String ip = AccessAddressUtil.getIpAddress(httpServletRequest);
        Map<String,Object> map = new HashMap<>();
        map.put("ip",ip);

        SysUser sysUser = (SysUser) authentication.getPrincipal();

        String jwtToken = JwtTokenUtil.generateToken(sysUser.getUsername(), expirationSeconds, map);

        //刷新时间
        Integer expire = validTime*24*60*60*1000;
        //获取请求的ip地址
        String currentIp = AccessAddressUtil.getIpAddress(httpServletRequest);
        redisUtil.setTokenRefresh(jwtToken,sysUser.getUsername(),currentIp);
//        log.info("用户{}登录成功, 信息已保存至redis ", sysUser.getUsername());

        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGIN_SUCCESS,jwtToken,true)));

    }
}
