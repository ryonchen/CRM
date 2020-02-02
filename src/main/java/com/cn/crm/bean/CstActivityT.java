package com.cn.crm.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;

public class CstActivityT {
    private Integer atvId;

    private Date atvDate;

    private String atvDesc;

    private String atvPlace;

    private String atvTitle;

    private Integer cstCustomerTCstId;

    private String atvDetail;

    public Integer getAtvId() {
        return atvId;
    }

    public void setAtvId(Integer atvId) {
        this.atvId = atvId;
    }

    @JSONField(format="yyyy-MM-dd HH:mm:ss",serialzeFeatures= SerializerFeature.WriteMapNullValue)
    public Date getAtvDate() {
        return atvDate;
    }

    public void setAtvDate(Date atvDate) {
        this.atvDate = atvDate;
    }

    public String getAtvDesc() {
        return atvDesc;
    }

    public void setAtvDesc(String atvDesc) {
        this.atvDesc = atvDesc == null ? null : atvDesc.trim();
    }

    public String getAtvPlace() {
        return atvPlace;
    }

    public void setAtvPlace(String atvPlace) {
        this.atvPlace = atvPlace == null ? null : atvPlace.trim();
    }

    public String getAtvTitle() {
        return atvTitle;
    }

    public void setAtvTitle(String atvTitle) {
        this.atvTitle = atvTitle == null ? null : atvTitle.trim();
    }

    public Integer getCstCustomerTCstId() {
        return cstCustomerTCstId;
    }

    public void setCstCustomerTCstId(Integer cstCustomerTCstId) {
        this.cstCustomerTCstId = cstCustomerTCstId;
    }

    public String getAtvDetail() {
        return atvDetail;
    }

    public void setAtvDetail(String atvDetail) {
        this.atvDetail = atvDetail == null ? null : atvDetail.trim();
    }
}