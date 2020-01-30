package com.cn.crm.bean;

public class CstLinkmanT {
    private Integer linkId;

    private Integer linkCstId;

    private String linkCstName;

    private String linkMemo;

    private String linkMobile;

    private String linkName;

    private String linkPostion;

    private String linkSex;

    private String linkTel;

    private Integer cstCustomerTCstId;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getLinkCstId() {
        return linkCstId;
    }

    public void setLinkCstId(Integer linkCstId) {
        this.linkCstId = linkCstId;
    }

    public String getLinkCstName() {
        return linkCstName;
    }

    public void setLinkCstName(String linkCstName) {
        this.linkCstName = linkCstName == null ? null : linkCstName.trim();
    }

    public String getLinkMemo() {
        return linkMemo;
    }

    public void setLinkMemo(String linkMemo) {
        this.linkMemo = linkMemo == null ? null : linkMemo.trim();
    }

    public String getLinkMobile() {
        return linkMobile;
    }

    public void setLinkMobile(String linkMobile) {
        this.linkMobile = linkMobile == null ? null : linkMobile.trim();
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkPostion() {
        return linkPostion;
    }

    public void setLinkPostion(String linkPostion) {
        this.linkPostion = linkPostion == null ? null : linkPostion.trim();
    }

    public String getLinkSex() {
        return linkSex;
    }

    public void setLinkSex(String linkSex) {
        this.linkSex = linkSex == null ? null : linkSex.trim();
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel == null ? null : linkTel.trim();
    }

    public Integer getCstCustomerTCstId() {
        return cstCustomerTCstId;
    }

    public void setCstCustomerTCstId(Integer cstCustomerTCstId) {
        this.cstCustomerTCstId = cstCustomerTCstId;
    }
}