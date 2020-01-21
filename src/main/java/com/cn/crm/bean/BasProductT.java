package com.cn.crm.bean;

public class BasProductT {
    private Integer pro_id;

    private String pro_depot;

    private String pro_goods_unit;

    private String pro_name;

    private String pro_no;

    private String pro_price;

    private String pro_rank;

    private String pro_remark;

    private String pro_type;

    private String pro_unit;

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_depot() {
        return pro_depot;
    }

    public void setPro_depot(String pro_depot) {
        this.pro_depot = pro_depot == null ? null : pro_depot.trim();
    }

    public String getPro_goods_unit() {
        return pro_goods_unit;
    }

    public void setPro_goods_unit(String pro_goods_unit) {
        this.pro_goods_unit = pro_goods_unit == null ? null : pro_goods_unit.trim();
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name == null ? null : pro_name.trim();
    }

    public String getPro_no() {
        return pro_no;
    }

    public void setPro_no(String pro_no) {
        this.pro_no = pro_no == null ? null : pro_no.trim();
    }

    public String getPro_price() {
        return pro_price;
    }

    public void setPro_price(String pro_price) {
        this.pro_price = pro_price == null ? null : pro_price.trim();
    }

    public String getPro_rank() {
        return pro_rank;
    }

    public void setPro_rank(String pro_rank) {
        this.pro_rank = pro_rank == null ? null : pro_rank.trim();
    }

    public String getPro_remark() {
        return pro_remark;
    }

    public void setPro_remark(String pro_remark) {
        this.pro_remark = pro_remark == null ? null : pro_remark.trim();
    }

    public String getPro_type() {
        return pro_type;
    }

    public void setPro_type(String pro_type) {
        this.pro_type = pro_type == null ? null : pro_type.trim();
    }

    public String getPro_unit() {
        return pro_unit;
    }

    public void setPro_unit(String pro_unit) {
        this.pro_unit = pro_unit == null ? null : pro_unit.trim();
    }
}