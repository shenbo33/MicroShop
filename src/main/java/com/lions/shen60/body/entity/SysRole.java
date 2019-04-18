package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/14  11:10
 * @description : SysRole 角色
 * @modified By :
 * @version     : version 1.0
 */
@Entity
public class SysRole extends BaseEntity {

    private String name;

    @ManyToMany
    @JoinTable(name="sys_role_menu_relation",
            joinColumns ={@JoinColumn(name="roleId")}, inverseJoinColumns = {@JoinColumn(name="menuId")})
    private Set<SysMenu> sysMenus = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SysMenu> getSysMenus() {
        return sysMenus;
    }

    public void setSysMenus(Set<SysMenu> sysMenus) {
        this.sysMenus = sysMenus;
    }
}
