package com.cn.crm.vo;

import com.cn.crm.bean.BasDictT;
import com.cn.crm.bean.CstCustomerT;
import com.cn.crm.bean.SysUser;

public class CustomerVo extends CstCustomerT {
    private BasDictT cstLevelInfo;

    public BasDictT getCstLevelInfo() {
        return cstLevelInfo;
    }

    public void setCstLevelInfo(BasDictT cstLevelInfo) {
        this.cstLevelInfo = cstLevelInfo;
    }

    private SysUser managerInfo;

    public void setManagerInfo(SysUser managerInfo) {
        this.managerInfo = managerInfo;
    }

    public SysUser getManagerInfo() {
        return managerInfo;
    }


}
