package com.cn.crm.controller.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.crm.bean.CstCustomerT;
import com.cn.crm.service.CstActivityTService;
import com.cn.crm.service.CstCustomerTService;
import com.cn.crm.service.CstLinkmanTService;
import com.cn.crm.vo.CustomerReqVo;
import com.cn.crm.vo.CustomerVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/crm/client")
public class ClientController {
    private static Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private CstCustomerTService cstCustomerTService;

//    @Autowired
//    private CstCustomerT cstCustomerT;

    //客户信息管理
    @RequestMapping(value = "/list_client",method = RequestMethod.GET)
    public String goListChance(){
        return "client/list_client";
    }

    //客户流失计划
    @RequestMapping(value = "/list_lst",method = RequestMethod.GET)
    public String goListPlan(){
        return "client/list_lst";
    }


    @RequestMapping(value = "/getClientList",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getClientList(CustomerReqVo customerReqVo){
        JSONObject result = new JSONObject();
        JSONArray data = new JSONArray();
        try {
            Integer total = cstCustomerTService.countByUser(customerReqVo);
            List<CustomerVo> list = cstCustomerTService.selectByUser(customerReqVo);
            data = JSONArray.parseArray(JSON.toJSONString(list));
            result.put("success", true);
            result.put("message", "");
            result.put("data", data);
            result.put("total", total);
        }catch (Exception e){
            logger.error(e.getMessage());
            result.put("success", false);
            result.put("message", "发生未知异常");
        }

        return result;
    }



}
