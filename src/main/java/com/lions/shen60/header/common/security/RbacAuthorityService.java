package com.lions.shen60.header.common.security;

import com.lions.shen60.body.entity.SysMenu;
import com.lions.shen60.body.entity.SysRole;
import com.lions.shen60.body.entity.SysUser;
import com.lions.shen60.body.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

// TODO: 2019/4/18 权限访问控制

@Component("rbacauthorityservice")
public class RbacAuthorityService {


    private UserService userService;

    @Autowired
    public RbacAuthorityService(UserService userService) {
        this.userService = userService;
    }

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Object userInfo = authentication.getPrincipal();

        boolean hasPermission  = false;

        if (userInfo instanceof UserDetails) {

            AntPathMatcher antPathMatcher = new AntPathMatcher();

            String username = ((UserDetails) userInfo).getUsername();

            SysUser sysUser = userService.findUserByName(username);
            Set<SysRole> roles = sysUser.getRoles();

            outside: for (SysRole role : roles ) {
                Set<SysMenu> menus = role.getSysMenus();
                for (SysMenu menu : menus) {
                    if (antPathMatcher.match(menu.getUrl(), request.getRequestURI())) {
                        hasPermission = true;
                        break outside;
                    }
                }
            }
            return hasPermission;
        } else {
            return false;
        }
    }
}
