package com.cn.crm.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;

public class SalChanceT {
    private Integer chcId;

    private String chcCreateBy;


    private Date chcCreateDate;

    private Integer chcCreateId;

    private String chcCustName;

    private String chcDesc;


    private Date chcDueDate;

    private Integer chcDueId;

    private Integer chcDueTo;

    private String chcLinkman;

    private Integer chcRate;

    private String chcSource;

    private String chcStatus;

    private String chcTel;

    private String chcTitle;

    public Integer getChcId() {
        return chcId;
    }

    public void setChcId(Integer chcId) {
        this.chcId = chcId;
    }

    public String getChcCreateBy() {
        return chcCreateBy;
    }

    public void setChcCreateBy(String chcCreateBy) {
        this.chcCreateBy = chcCreateBy == null ? null : chcCreateBy.trim();
    }

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
@JSONField(format="yyyy-MM-dd HH:mm:ss",serialzeFeatures= SerializerFeature.WriteMapNullValue)
    public Date getChcCreateDate() {
        return chcCreateDate;
    }

    public void setChcCreateDate(Date chcCreateDate) {
        this.chcCreateDate = chcCreateDate;
    }

    public Integer getChcCreateId() {
        return chcCreateId;
    }

    public void setChcCreateId(Integer chcCreateId) {
        this.chcCreateId = chcCreateId;
    }

    public String getChcCustName() {
        return chcCustName;
    }

    public void setChcCustName(String chcCustName) {
        this.chcCustName = chcCustName == null ? null : chcCustName.trim();
    }

    public String getChcDesc() {
        return chcDesc;
    }

    public void setChcDesc(String chcDesc) {
        this.chcDesc = chcDesc == null ? null : chcDesc.trim();
    }

    @JSONField(format="yyyy-MM-dd HH:mm:ss",serialzeFeatures=SerializerFeature.WriteMapNullValue)
    public Date getChcDueDate() {
        return chcDueDate;
    }

    public void setChcDueDate(Date chcDueDate) {
        this.chcDueDate = chcDueDate;
    }

    public Integer getChcDueId() {
        return chcDueId;
    }

    public void setChcDueId(Integer chcDueId) {
        this.chcDueId = chcDueId;
    }

    public Integer getChcDueTo() {
        return chcDueTo;
    }

    public void setChcDueTo(Integer chcDueTo) {
        this.chcDueTo = chcDueTo;
    }

    public String getChcLinkman() {
        return chcLinkman;
    }

    public void setChcLinkman(String chcLinkman) {
        this.chcLinkman = chcLinkman == null ? null : chcLinkman.trim();
    }

    public Integer getChcRate() {
        return chcRate;
    }

    public void setChcRate(Integer chcRate) {
        this.chcRate = chcRate;
    }

    public String getChcSource() {
        return chcSource;
    }

    public void setChcSource(String chcSource) {
        this.chcSource = chcSource == null ? null : chcSource.trim();
    }

    public String getChcStatus() {
        return chcStatus;
    }

    public void setChcStatus(String chcStatus) {
        this.chcStatus = chcStatus == null ? null : chcStatus.trim();
    }

    public String getChcTel() {
        return chcTel;
    }

    public void setChcTel(String chcTel) {
        this.chcTel = chcTel == null ? null : chcTel.trim();
    }

    public String getChcTitle() {
        return chcTitle;
    }

    public void setChcTitle(String chcTitle) {
        this.chcTitle = chcTitle == null ? null : chcTitle.trim();
    }
}