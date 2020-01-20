package com.cn.crm.bean;

import java.util.Date;

public class cstIndentT {
    private Integer indent_id;

    private Date indent_date;

    private String indent_destination;

    private String indent_state;

    private Double indent_sum;

    private Integer cst_customer_t_cst_id;

    private String indent_name;

    private String indent_create_by;

    public Integer getIndent_id() {
        return indent_id;
    }

    public void setIndent_id(Integer indent_id) {
        this.indent_id = indent_id;
    }

    public Date getIndent_date() {
        return indent_date;
    }

    public void setIndent_date(Date indent_date) {
        this.indent_date = indent_date;
    }

    public String getIndent_destination() {
        return indent_destination;
    }

    public void setIndent_destination(String indent_destination) {
        this.indent_destination = indent_destination == null ? null : indent_destination.trim();
    }

    public String getIndent_state() {
        return indent_state;
    }

    public void setIndent_state(String indent_state) {
        this.indent_state = indent_state == null ? null : indent_state.trim();
    }

    public Double getIndent_sum() {
        return indent_sum;
    }

    public void setIndent_sum(Double indent_sum) {
        this.indent_sum = indent_sum;
    }

    public Integer getCst_customer_t_cst_id() {
        return cst_customer_t_cst_id;
    }

    public void setCst_customer_t_cst_id(Integer cst_customer_t_cst_id) {
        this.cst_customer_t_cst_id = cst_customer_t_cst_id;
    }

    public String getIndent_name() {
        return indent_name;
    }

    public void setIndent_name(String indent_name) {
        this.indent_name = indent_name == null ? null : indent_name.trim();
    }

    public String getIndent_create_by() {
        return indent_create_by;
    }

    public void setIndent_create_by(String indent_create_by) {
        this.indent_create_by = indent_create_by == null ? null : indent_create_by.trim();
    }
}