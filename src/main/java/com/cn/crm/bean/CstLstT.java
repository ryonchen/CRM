package com.cn.crm.bean;

import java.util.Date;

public class CstLstT {
    private Integer lstId;

    private String lstCstId;

    private String lstCstManagerId;

    private String lstCstManagerName;

    private String lstCstName;

    private String lstDelay;

    private String lstLastOrderDate;

    private String lstReason;

    private String lstStatus;

    private Date sureLstDate;

    public Integer getLstId() {
        return lstId;
    }

    public void setLstId(Integer lstId) {
        this.lstId = lstId;
    }

    public String getLstCstId() {
        return lstCstId;
    }

    public void setLstCstId(String lstCstId) {
        this.lstCstId = lstCstId == null ? null : lstCstId.trim();
    }

    public String getLstCstManagerId() {
        return lstCstManagerId;
    }

    public void setLstCstManagerId(String lstCstManagerId) {
        this.lstCstManagerId = lstCstManagerId == null ? null : lstCstManagerId.trim();
    }

    public String getLstCstManagerName() {
        return lstCstManagerName;
    }

    public void setLstCstManagerName(String lstCstManagerName) {
        this.lstCstManagerName = lstCstManagerName == null ? null : lstCstManagerName.trim();
    }

    public String getLstCstName() {
        return lstCstName;
    }

    public void setLstCstName(String lstCstName) {
        this.lstCstName = lstCstName == null ? null : lstCstName.trim();
    }

    public String getLstDelay() {
        return lstDelay;
    }

    public void setLstDelay(String lstDelay) {
        this.lstDelay = lstDelay == null ? null : lstDelay.trim();
    }

    public String getLstLastOrderDate() {
        return lstLastOrderDate;
    }

    public void setLstLastOrderDate(String lstLastOrderDate) {
        this.lstLastOrderDate = lstLastOrderDate == null ? null : lstLastOrderDate.trim();
    }

    public String getLstReason() {
        return lstReason;
    }

    public void setLstReason(String lstReason) {
        this.lstReason = lstReason == null ? null : lstReason.trim();
    }

    public String getLstStatus() {
        return lstStatus;
    }

    public void setLstStatus(String lstStatus) {
        this.lstStatus = lstStatus == null ? null : lstStatus.trim();
    }

    public Date getSureLstDate() {
        return sureLstDate;
    }

    public void setSureLstDate(Date sureLstDate) {
        this.sureLstDate = sureLstDate;
    }
}