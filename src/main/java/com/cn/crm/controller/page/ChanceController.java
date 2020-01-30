package com.cn.crm.controller.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.crm.bean.SalChanceT;
import com.cn.crm.bean.SalPlanT;
import com.cn.crm.service.SalChanceTService;
import com.cn.crm.service.SalPlanTService;
import com.cn.crm.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
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

    private static Logger logger = LoggerFactory.getLogger(ChanceController.class);

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

    @Autowired
    private SalPlanTService salPlanTService;

    //查询销售机会
    @RequestMapping(value = "/getChanceList",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getChanceList(String beginDate, String endDate, String custName, String title, String linkman, Integer page, Integer rows, String sort, String order){
        beginDate = beginDate + " 00:00:00";
        endDate = endDate + " 23:59:59";
        Long beginDateSt = DateUtil.strToTimestamp(beginDate);
        Long endDateSt = DateUtil.strToTimestamp(endDate);
        JSONObject result = new JSONObject();
        JSONArray chanceArray = new JSONArray();
        try {
            Long total = salChanceTService.countByCreateTime(beginDateSt, endDateSt, custName, title, linkman,page,rows,sort,order);
            List<SalChanceT> list = salChanceTService.selectByCreateTime(beginDateSt, endDateSt, custName, title, linkman,page,rows,sort,order);
            chanceArray = JSONArray.parseArray(JSON.toJSONString(list));
            result.put("success", true);
            result.put("message", "");
            result.put("data", chanceArray);
            result.put("total", total);
        }catch (Exception e){
            logger.error(e.getMessage());
            result.put("success", false);
            result.put("message", "发生未知异常");
        }

        return result;
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
            resultMap.put("message", "新增失败");
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
    public Map<String, Object> deleteChance(HttpServletRequest request, HttpServletResponse response){
        String[] chcIdsStr = request.getParameterValues("chcIds[]");
        Integer[] chcIdsInt = new Integer[chcIdsStr.length];;
        for(int i=0;i<chcIdsStr.length;i++){
            chcIdsInt[i] = Integer.parseInt(chcIdsStr[i]);
        }
        int code = salChanceTService.deleteByPrimaryKeys(chcIdsInt);
        Map<String, Object> resultMap = new HashMap<>();
        if(code>0){
            resultMap.put("success", true);
            resultMap.put("message", "");
        }else{
            resultMap.put("success", false);
            resultMap.put("code", code);
            resultMap.put("message", "删除失败");
        }
        return resultMap;

    }

    //查询开发计划
    @RequestMapping(value = "/getPlanList",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getPlanList(Integer chcId){
        JSONObject result = new JSONObject();
        JSONArray planArray = new JSONArray();
        try {
            List<SalPlanT> list = salPlanTService.selectByChcId(chcId, 0, 0, "", "");
            planArray = JSONArray.parseArray(JSON.toJSONString(list));
            result.put("success", true);
            result.put("message", "");
            result.put("data", planArray);
//            result.put("total", total);
        }catch (Exception e){
            logger.error(e.getMessage());
            result.put("success", false);
            result.put("message", "发生未知异常");
        }

        return result;
    }

    //新增开发计划
    @RequestMapping(value = "/addPlan",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addPlan(SalPlanT salPlanT){
        int code = salPlanTService.insertSelective(salPlanT);
        Map<String, Object> resultMap = new HashMap<>();
        if(code>0){
            resultMap.put("success", true);
            resultMap.put("message", "");
        }else{
            resultMap.put("success", false);
            resultMap.put("code", code);
            resultMap.put("message", "新增失败");
        }
        return resultMap;
    }

    //修改销售机会
    @RequestMapping(value = "/editPlan",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editPlan(SalPlanT salPlanT){
        int code = salPlanTService.updateByPrimaryKeySelective(salPlanT);
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
    @RequestMapping(value = "/deletePlan",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deletePlan(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        int code = salPlanTService.deleteByPrimaryKey(Integer.parseInt(id));
        Map<String, Object> resultMap = new HashMap<>();
        if(code>0){
            resultMap.put("success", true);
            resultMap.put("message", "");
        }else{
            resultMap.put("success", false);
            resultMap.put("code", code);
            resultMap.put("message", "删除失败");
        }
        return resultMap;

    }

    //当前端页面传过来的的String类型的日期与后台实体类的Date类型不匹配时，需要加上该方法
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }
}
