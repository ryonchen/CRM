package com.cn.crm.vo;

import com.cn.crm.bean.CstIndentDetail;
import com.cn.crm.bean.CstIndentT;

import java.math.BigDecimal;
import java.util.List;

public class IndentVo extends CstIndentT {


    public List<IndentDetailVo> getDetail() {
        return detail;
    }

    public void setDetail(List<IndentDetailVo> detail) {
        this.detail = detail;
    }

    private List<IndentDetailVo> detail;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    private BigDecimal total;
}
