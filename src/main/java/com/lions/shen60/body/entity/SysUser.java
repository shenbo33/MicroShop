package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;
import org.hibernate.annotations.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Entity
@Table(appliesTo = "sys_user",comment = "系统用户表")
public class SysUser extends BaseEntity implements UserDetails{

    @NotEmpty(message = "登陆名不能为空")
    @Column(nullable = false, unique = true, columnDefinition = "varchar(36) comment '登陆名'")
    private String username;
    @Column(nullable = false, columnDefinition = "varchar(128) comment '密码'")
    private String password;
    @Column(nullable = false, columnDefinition = "varchar(5) comment '状态'")
    private String state;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "professionId", columnDefinition = "varchar(36) comment '人员id'")
    private InfPerson person;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SysRole.class)
    @JoinTable(name="sys_user_organize_relation",
            joinColumns ={@JoinColumn(name="userId", columnDefinition =  "varchar(36) comment '用户ID'" )},
            inverseJoinColumns = {@JoinColumn(name="organizeId", columnDefinition =  "varchar(36) comment '组织机构ID'")})
    private Set<SysOrganize> organizes = new HashSet();

    @ManyToMany
    @JoinTable(name="sys_user_role_relation",
            joinColumns ={@JoinColumn(name="userId", columnDefinition =  "varchar(36) comment '用户ID'" )},
            inverseJoinColumns = {@JoinColumn(name="roleId", columnDefinition =  "varchar(36) comment '角色ID'" )})
    private Set<SysRole> roles = new HashSet();

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<SysOrganize> getOrganizes() {
        return organizes;
    }

    public void setOrganizes(Set<SysOrganize> organizes) {
        this.organizes = organizes;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    public InfPerson getPerson() {
        return person;
    }

    public void setPerson(InfPerson person) {
        this.person = person;
    }

    @Transient
    private Set<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
        for(GrantedAuthority authority : this.authorities){
            simpleAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return simpleAuthorities;
    }

    public void setAuthorities(Set<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() { // 最重点Ⅰ
        return this.password;
    }

    @Override
    public String getUsername() { // 最重点Ⅱ
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //账号是否锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //账号凭证是否未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
