package com.cn.crm.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;

public class CstIndentT {
    private Integer indentId;

    private Date indentDate;

    private String indentDestination;

    private String indentState;

    private Double indentSum;

    private Integer cstCustomerTCstId;

    private String indentName;

    private String indentCreateBy;

    public Integer getIndentId() {
        return indentId;
    }

    public void setIndentId(Integer indentId) {
        this.indentId = indentId;
    }

    @JSONField(format="yyyy-MM-dd HH:mm:ss",serialzeFeatures= SerializerFeature.WriteMapNullValue)
    public Date getIndentDate() {
        return indentDate;
    }

    public void setIndentDate(Date indentDate) {
        this.indentDate = indentDate;
    }

    public String getIndentDestination() {
        return indentDestination;
    }

    public void setIndentDestination(String indentDestination) {
        this.indentDestination = indentDestination == null ? null : indentDestination.trim();
    }

    public String getIndentState() {
        return indentState;
    }

    public void setIndentState(String indentState) {
        this.indentState = indentState == null ? null : indentState.trim();
    }

    public Double getIndentSum() {
        return indentSum;
    }

    public void setIndentSum(Double indentSum) {
        this.indentSum = indentSum;
    }

    public Integer getCstCustomerTCstId() {
        return cstCustomerTCstId;
    }

    public void setCstCustomerTCstId(Integer cstCustomerTCstId) {
        this.cstCustomerTCstId = cstCustomerTCstId;
    }

    public String getIndentName() {
        return indentName;
    }

    public void setIndentName(String indentName) {
        this.indentName = indentName == null ? null : indentName.trim();
    }

    public String getIndentCreateBy() {
        return indentCreateBy;
    }

    public void setIndentCreateBy(String indentCreateBy) {
        this.indentCreateBy = indentCreateBy == null ? null : indentCreateBy.trim();
    }
}