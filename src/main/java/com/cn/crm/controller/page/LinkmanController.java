package com.cn.crm.controller.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.crm.bean.CstLinkmanT;
import com.cn.crm.service.CstLinkmanTService;
import com.cn.crm.vo.CustomerReqVo;
import com.cn.crm.vo.IndentVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/crm/linkman")
public class LinkmanController {
    private static Logger logger = LoggerFactory.getLogger(LinkmanController.class);

    @Autowired
    private CstLinkmanTService cstLinkmanTService;

    @RequestMapping(value = "/getLinkmanList",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getLinkmanList(Integer cstId){
        JSONObject result = new JSONObject();
        JSONArray data = new JSONArray();
        try {
            List<CstLinkmanT> list = cstLinkmanTService.selectByCstId(cstId);
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

    //新增联系人
    @RequestMapping(value = "/addLinkman",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addLinkman(CstLinkmanT cstLinkmanT){
        int code = cstLinkmanTService.insertSelective(cstLinkmanT);
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

    //修改联系人
    @RequestMapping(value = "/editLinkman",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editLinkman(CstLinkmanT cstLinkmanT){
        int code = cstLinkmanTService.updateByPrimaryKeySelective(cstLinkmanT);
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

    //删除联系人
    @RequestMapping(value = "/deleteLinkman",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteLinkman(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        int code = cstLinkmanTService.deleteByPrimaryKey(Integer.parseInt(id));
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

}
