package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;
/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/14  11:00
 * @description : InfUser 人员信息
 * @modified By :
 * @version     : version 1.0
 */

@Data
@Entity
public class InfPerson extends BaseEntity {

    private String name;
    private Date birthday;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "addressId")
    private InfAddress address;
    private String tel;
    private String sex;
    private String hobby;

    @OneToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "professionId")
    private InfProfession profession; // 所属行业
    private int income; // 输入

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public InfAddress getAddress() {
        return address;
    }

    public void setAddress(InfAddress address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public InfProfession getProfession() {
        return profession;
    }

    public void setProfession(InfProfession profession) {
        this.profession = profession;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
