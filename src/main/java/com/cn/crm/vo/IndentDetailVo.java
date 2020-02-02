package com.cn.crm.vo;

import com.cn.crm.bean.CstIndentDetail;

import java.math.BigDecimal;

public class IndentDetailVo extends CstIndentDetail {
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    private BigDecimal total;

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    private String proName;
}
