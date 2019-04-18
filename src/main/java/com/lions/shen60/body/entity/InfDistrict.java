package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/14  10:58
 * @description : InfDistrict 国家-省-市-县
 * @modified By :
 * @version     : version 1.0
 */

@Data
@Entity
public class InfDistrict {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    private String id;
    private String pId;
    private String level;
    private String name;
    private int sortNo;
    private String center;
    private String polyLine;

}
