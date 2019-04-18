package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;

import javax.persistence.*;
/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/14  11:00
 * @description : InfShop 店铺
 * @modified By :
 * @version     : version 1.0
 */
@Entity
public class InfShop extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name="organizeId")
    @Basic(fetch= FetchType.LAZY)
    private SysOrganize organize;

    public SysOrganize getOrganize() {
        return organize;
    }

    public void setOrganize(SysOrganize organize) {
        this.organize = organize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
