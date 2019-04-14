package com.lions.shen60.body.entity;

import com.lions.shen60.header.base.bean.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address extends BaseEntity {

    // country province city district
    @OneToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "districtId")
    private District district;
    private String describePart;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getDescribePart() {
        return describePart;
    }

    public void setDescribePart(String describePart) {
        this.describePart = describePart;
    }
}
