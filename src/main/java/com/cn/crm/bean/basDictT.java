package com.cn.crm.bean;

public class basDictT {
    private Integer dict_id;

    private String dict_is_editable;

    private String dict_item;

    private String dict_type;

    private String dict_value;

    public Integer getDict_id() {
        return dict_id;
    }

    public void setDict_id(Integer dict_id) {
        this.dict_id = dict_id;
    }

    public String getDict_is_editable() {
        return dict_is_editable;
    }

    public void setDict_is_editable(String dict_is_editable) {
        this.dict_is_editable = dict_is_editable == null ? null : dict_is_editable.trim();
    }

    public String getDict_item() {
        return dict_item;
    }

    public void setDict_item(String dict_item) {
        this.dict_item = dict_item == null ? null : dict_item.trim();
    }

    public String getDict_type() {
        return dict_type;
    }

    public void setDict_type(String dict_type) {
        this.dict_type = dict_type == null ? null : dict_type.trim();
    }

    public String getDict_value() {
        return dict_value;
    }

    public void setDict_value(String dict_value) {
        this.dict_value = dict_value == null ? null : dict_value.trim();
    }
}