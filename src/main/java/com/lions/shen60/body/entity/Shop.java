package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;

import javax.persistence.*;

@Entity
public class Shop extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name="organizeId")
    @Basic(fetch= FetchType.LAZY)
    private Organize organize;

    public Organize getOrganize() {
        return organize;
    }

    public void setOrganize(Organize organize) {
        this.organize = organize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
