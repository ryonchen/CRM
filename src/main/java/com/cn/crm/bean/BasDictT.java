package com.cn.crm.bean;

public class BasDictT {
    private Integer dictId;

    private String dictIsEditable;

    private String dictItem;

    private String dictType;

    private String dictValue;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictIsEditable() {
        return dictIsEditable;
    }

    public void setDictIsEditable(String dictIsEditable) {
        this.dictIsEditable = dictIsEditable == null ? null : dictIsEditable.trim();
    }

    public String getDictItem() {
        return dictItem;
    }

    public void setDictItem(String dictItem) {
        this.dictItem = dictItem == null ? null : dictItem.trim();
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }
}