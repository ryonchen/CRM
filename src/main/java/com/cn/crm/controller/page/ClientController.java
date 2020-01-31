package com.cn.crm.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/crm/client")
public class ClientController {
    private static Logger logger = LoggerFactory.getLogger(ClientController.class);

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


}
