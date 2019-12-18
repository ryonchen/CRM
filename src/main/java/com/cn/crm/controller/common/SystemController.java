package com.cn.crm.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-06 21:24
 */
@Controller
@RequestMapping("/crm")
public class SystemController {

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String goIndex() {
        return "common/main";
    }
}
