package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;

import javax.persistence.*;
import java.util.List;
/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/14  11:10
 * @description : SysOrganize 组织机构
 * @modified By :
 * @version     : version 1.0
 */
@Entity
public class SysOrganize extends BaseEntity {

    private String pId;
    private String level;
    private String name;

    @OneToMany(mappedBy="organize",cascade={CascadeType.REFRESH})
    private List<InfShop> shops;

    public List<InfShop> getShops() {
        return shops;
    }

    public void setShops(List<InfShop> shops) {
        this.shops = shops;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
