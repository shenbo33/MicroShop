package com.lions.shen60.body.service;

import com.lions.shen60.body.dao.UserRepository;
import com.lions.shen60.body.entity.SysUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public SysUser findUserByName(String name) {
        SysUser user = null;
        try {
            user = userRepository.findUserByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Transactional
    public SysUser addUser(SysUser user){
        SysUser resUser = null;
        try {
            resUser = userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resUser;
    }


    @Override
    public SysUser loadUserByUsername(String username) throws UsernameNotFoundException {

        //通过username查询用户
        SysUser user = userRepository.findUserByName(username);
        if(user == null){
            //仍需要细化处理
            throw new UsernameNotFoundException("该用户不存在");
        }

        Set authoritiesSet = new HashSet();
        // 模拟从数据库中获取用户角色
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");

        authoritiesSet.add(authority);
        user.setAuthorities(authoritiesSet);

        logger.info("用户{}验证通过",username);
        return user;
    }
}
