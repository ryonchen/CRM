package com.cn.crm.controller.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.crm.bean.BasDictT;
import com.cn.crm.service.BasDictTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/crm/dict")
public class DictController {

    private static Logger logger = LoggerFactory.getLogger(DictController.class);

    @Autowired
    private BasDictTService basDictTService;

    @RequestMapping(value = "/getCstLevel",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getClientList(String dictType){
        JSONObject result = new JSONObject();
        JSONArray data = new JSONArray();
        try {
            List<BasDictT> list = basDictTService.selectByDictType(dictType);
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
}
