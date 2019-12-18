package com.cn.crm.bean;

import java.util.Date;

public class SalPlan {
    private Integer planId;

    private Integer planChcId;

    private Date planDate;

    private String planContent;

    private String planResult;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getPlanChcId() {
        return planChcId;
    }

    public void setPlanChcId(Integer planChcId) {
        this.planChcId = planChcId;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent == null ? null : planContent.trim();
    }

    public String getPlanResult() {
        return planResult;
    }

    public void setPlanResult(String planResult) {
        this.planResult = planResult == null ? null : planResult.trim();
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}