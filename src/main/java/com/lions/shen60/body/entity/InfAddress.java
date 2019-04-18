package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Data
@Entity
public class InfAddress extends BaseEntity {

    // country province city district
    @OneToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "districtId")
    private InfDistrict district;
    private String describePart;

}
