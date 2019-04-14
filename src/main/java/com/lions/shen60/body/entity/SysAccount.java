package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SysAccount extends BaseEntity {

    private String name;
    private String password;
    private String state;
    @ManyToMany
    @JoinTable(name="sys_account_organize_relation",
            joinColumns ={@JoinColumn(name="accountId")}, inverseJoinColumns = {@JoinColumn(name="organizeId")})
    private List<Organize> organizes = new ArrayList<Organize>();

    @ManyToMany
    @JoinTable(name="sys_account_role_relation",
            joinColumns ={@JoinColumn(name="accountId")}, inverseJoinColumns = {@JoinColumn(name="roleId")})
    private List<Role> roles = new ArrayList<Role>();
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Organize> getOrganizes() {
        return organizes;
    }

    public void setOrganizes(List<Organize> organizes) {
        this.organizes = organizes;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
