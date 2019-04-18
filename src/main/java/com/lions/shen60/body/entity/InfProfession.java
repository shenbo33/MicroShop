package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;

import javax.persistence.Entity;

/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/14  10:59
 * @description : InfProfession 行业
 * @modified By :
 * @version     : version 1.0
 */
@Entity
public class InfProfession extends BaseEntity {

    private String pId;
    private String name;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}