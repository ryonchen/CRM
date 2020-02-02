package com.cn.crm.controller.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.crm.bean.CstActivityT;
import com.cn.crm.service.CstActivityTService;
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

@Controller
@RequestMapping("/crm/activity")
public class ActivityController {
    private static Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    private CstActivityTService cstActivityTService;


    @RequestMapping(value = "/getActivityList",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getLinkmanList(Integer cstId){
        JSONObject result = new JSONObject();
        JSONArray data = new JSONArray();
        try {
            List<CstActivityT> list = cstActivityTService.selectByCstId(cstId);
            data = JSONArray.parseArray(JSON.toJSONString(list));
            result.put("success", true);
            result.put("message", "");
            result.put("data", data);
        }catch (Exception e){
            logger.error(e.getMessage());
            result.put("success", false);
            result.put("message", "发生未知异常");
        }

        return result;
    }

    //新增交往记录
    @RequestMapping(value = "/addActivity",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addActivity(CstActivityT cstActivityT){
        int code = cstActivityTService.insertSelective(cstActivityT);
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

    //修改交往记录
    @RequestMapping(value = "/editActivity",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editActivity(CstActivityT cstActivityT){
        int code = cstActivityTService.updateByPrimaryKeySelective(cstActivityT);
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

    //删除交往记录
    @RequestMapping(value = "/deleteActivity",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteActivity(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        int code = cstActivityTService.deleteByPrimaryKey(Integer.parseInt(id));
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
