package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;

import javax.persistence.Entity;
/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/14  11:02
 * @description : SysMenu 菜单
 * @modified By :
 * @version     : version 1.0
 */
@Entity
public class SysMenu extends BaseEntity {

    private String pId;
    private String name;
    private String url;
    private String type; // 1 菜单 2 功能
    private String icon;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
