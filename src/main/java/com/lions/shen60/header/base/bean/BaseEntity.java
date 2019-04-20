package com.lions.shen60.header.base.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    @Column(columnDefinition = "varchar(36) comment '主键' ")
    private String id;
    @Column(columnDefinition = "timestamp comment '更新时间' ")
    private Date modifyTime;
    @Column(columnDefinition = "varchar(36) comment '更新用户' ")
    private String modifyUser;
    @Column(updatable = false, columnDefinition = "timestamp comment '创建时间' ")
    private Date createTime;
    @Column(updatable = false, columnDefinition = "varchar(36) comment '创建用户' ")
    private String createUser;

    @Column(columnDefinition = "varchar(128) comment '备注' ")
    private String remark;
    @Column(columnDefinition = "char comment '是否删除' default 0 ")
    private char isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public char getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(char isDelete) {
        this.isDelete = isDelete;
    }
}

