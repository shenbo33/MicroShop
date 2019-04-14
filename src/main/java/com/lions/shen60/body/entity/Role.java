package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role extends BaseEntity {

    private String name;

    @ManyToMany
    @JoinTable(name="sys_role_menu_relation",
            joinColumns ={@JoinColumn(name="roleId")}, inverseJoinColumns = {@JoinColumn(name="menuId")})
    private List<SysMenu> sysMenus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysMenu> getSysMenus() {
        return sysMenus;
    }

    public void setSysMenus(List<SysMenu> sysMenus) {
        this.sysMenus = sysMenus;
    }
}
