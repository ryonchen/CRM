package com.cn.crm.bean;

import java.util.Date;

public class CstLstT {
    private Integer lst_id;

    private String lst_cst_id;

    private String lst_cst_manager_id;

    private String lst_cst_manager_name;

    private String lst_cst_name;

    private String lst_delay;

    private String lst_last_order_date;

    private String lst_reason;

    private String lst_status;

    private Date sureLstDate;

    public Integer getLst_id() {
        return lst_id;
    }

    public void setLst_id(Integer lst_id) {
        this.lst_id = lst_id;
    }

    public String getLst_cst_id() {
        return lst_cst_id;
    }

    public void setLst_cst_id(String lst_cst_id) {
        this.lst_cst_id = lst_cst_id == null ? null : lst_cst_id.trim();
    }

    public String getLst_cst_manager_id() {
        return lst_cst_manager_id;
    }

    public void setLst_cst_manager_id(String lst_cst_manager_id) {
        this.lst_cst_manager_id = lst_cst_manager_id == null ? null : lst_cst_manager_id.trim();
    }

    public String getLst_cst_manager_name() {
        return lst_cst_manager_name;
    }

    public void setLst_cst_manager_name(String lst_cst_manager_name) {
        this.lst_cst_manager_name = lst_cst_manager_name == null ? null : lst_cst_manager_name.trim();
    }

    public String getLst_cst_name() {
        return lst_cst_name;
    }

    public void setLst_cst_name(String lst_cst_name) {
        this.lst_cst_name = lst_cst_name == null ? null : lst_cst_name.trim();
    }

    public String getLst_delay() {
        return lst_delay;
    }

    public void setLst_delay(String lst_delay) {
        this.lst_delay = lst_delay == null ? null : lst_delay.trim();
    }

    public String getLst_last_order_date() {
        return lst_last_order_date;
    }

    public void setLst_last_order_date(String lst_last_order_date) {
        this.lst_last_order_date = lst_last_order_date == null ? null : lst_last_order_date.trim();
    }

    public String getLst_reason() {
        return lst_reason;
    }

    public void setLst_reason(String lst_reason) {
        this.lst_reason = lst_reason == null ? null : lst_reason.trim();
    }

    public String getLst_status() {
        return lst_status;
    }

    public void setLst_status(String lst_status) {
        this.lst_status = lst_status == null ? null : lst_status.trim();
    }

    public Date getSureLstDate() {
        return sureLstDate;
    }

    public void setSureLstDate(Date sureLstDate) {
        this.sureLstDate = sureLstDate;
    }
}