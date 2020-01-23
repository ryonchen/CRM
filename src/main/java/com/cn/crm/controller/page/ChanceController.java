package com.cn.crm.controller.page;

import com.cn.crm.bean.SalChanceT;
import com.cn.crm.service.SalChanceTService;
import com.cn.crm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Autowired
    private SalChanceTService salChanceTService;

    //查询销售机会
    @RequestMapping(value = "/getChanceList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getChanceList(String beginDate, String endDate){
        beginDate = beginDate + " 00:00:00";
        endDate = endDate + " 23:59:59";
        Long beginDateSt = DateUtil.strToTimestamp(beginDate);
        Long endDateSt = DateUtil.strToTimestamp(endDate);
        Map<String, Object> resultMap = new HashMap<>();
        try {

            List<SalChanceT> list = salChanceTService.selectByCreateTime(beginDateSt, endDateSt);
            resultMap.put("success", true);
            resultMap.put("message", "");
            resultMap.put("data", list);
        }catch (Exception e){
            resultMap.put("success", false);
            resultMap.put("message", "发生未知异常");
        }

        return resultMap;
    }

    //新增销售机会
    @RequestMapping(value = "/addChance",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addChance(SalChanceT salChanceT){
        salChanceT.setChcCreateDate(new Date());
        int code = salChanceTService.insertSelective(salChanceT);
        Map<String, Object> resultMap = new HashMap<>();
        if(code>0){
            resultMap.put("success", true);
            resultMap.put("message", "");
        }else{
            resultMap.put("success", false);
            resultMap.put("code", code);
            resultMap.put("message", "修改失败");
        }
        return resultMap;
    }

    //修改销售机会
    @RequestMapping(value = "/editChance",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editChance(SalChanceT salChanceT){
        int code = salChanceTService.updateByPrimaryKeySelective(salChanceT);
        Map<String, Object> resultMap = new HashMap<>();
        if(code>0){
            resultMap.put("success", true);
            resultMap.put("message", "");
        }else{
            resultMap.put("success", false);
            resultMap.put("code", code);
            resultMap.put("message", "修改失败");
        }
        return resultMap;
    }

    //删除销售机会
    @RequestMapping(value = "/deleteChance",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteChance(Integer chcId){
        int code = salChanceTService.deleteByPrimaryKey(chcId);
        Map<String, Object> resultMap = new HashMap<>();
        if(code>0){
            resultMap.put("success", true);
            resultMap.put("message", "");
        }else{
            resultMap.put("success", false);
            resultMap.put("code", code);
            resultMap.put("message", "修改失败");
        }
        return resultMap;

    }

}
