package com.cn.crm.bean;

import java.util.Date;

public class SalPlanT {
    private Integer plan_id;

    private Integer plan_chc_id;

    private Date plan_date;

    private String plan_result;

    private String plan_todo;

    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
    }

    public Integer getPlan_chc_id() {
        return plan_chc_id;
    }

    public void setPlan_chc_id(Integer plan_chc_id) {
        this.plan_chc_id = plan_chc_id;
    }

    public Date getPlan_date() {
        return plan_date;
    }

    public void setPlan_date(Date plan_date) {
        this.plan_date = plan_date;
    }

    public String getPlan_result() {
        return plan_result;
    }

    public void setPlan_result(String plan_result) {
        this.plan_result = plan_result == null ? null : plan_result.trim();
    }

    public String getPlan_todo() {
        return plan_todo;
    }

    public void setPlan_todo(String plan_todo) {
        this.plan_todo = plan_todo == null ? null : plan_todo.trim();
    }
}