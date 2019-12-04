package com.cn.crm.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-03 15:28
 */

@Controller
@RequestMapping("/common")
public class PageController {

    @RequestMapping(value="/goLogin",method = RequestMethod.GET)
    public String goLogin() {
        return "common/login";
    }
}
