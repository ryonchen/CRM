package com.cn.crm.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;

public class SalPlanT {
    private Integer planId;

    private Integer planChcId;

    private Date planDate;

    private String planResult;

    private String planTodo;

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

    @JSONField(format="yyyy-MM-dd HH:mm:ss",serialzeFeatures= SerializerFeature.WriteMapNullValue)
    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getPlanResult() {
        return planResult;
    }

    public void setPlanResult(String planResult) {
        this.planResult = planResult == null ? null : planResult.trim();
    }

    public String getPlanTodo() {
        return planTodo;
    }

    public void setPlanTodo(String planTodo) {
        this.planTodo = planTodo == null ? null : planTodo.trim();
    }
}