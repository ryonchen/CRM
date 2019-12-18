package com.cn.crm.controller.sales;

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
@RequestMapping("/sales")
public class SalesController {

    @RequestMapping(value = "/chance",method = RequestMethod.GET)
    public String goSalesChance(){
        return "sales/chance";
    }
}
