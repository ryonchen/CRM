package com.cn.crm.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-07 23:44
 */
@Controller
@RequestMapping("/crm/chance")
public class ChanceController {

    //销售机会管理
    @RequestMapping(value = "/list_chance",method = RequestMethod.GET)
    public String goListChance(){
        return "chance/list_chance";
    }

    //客户开发计划
    @RequestMapping(value = "/list_plan",method = RequestMethod.GET)
    public String goListPlan(){
        return "chance/list_plan";
    }
}
