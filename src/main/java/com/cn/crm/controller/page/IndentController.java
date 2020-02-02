package com.cn.crm.controller.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.crm.service.CstIndendTService;
import com.cn.crm.vo.IndentVo;
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

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/crm/indent")
public class IndentController {
    private static Logger logger = LoggerFactory.getLogger(IndentController.class);

    @Autowired
    private CstIndendTService cstIndendTService;

    @RequestMapping(value = "/getIndentList",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getIntentList(Integer cstId){
        JSONObject result = new JSONObject();
        JSONArray data = new JSONArray();
        try {
            List<IndentVo> list = cstIndendTService.selectByCstId(cstId);
            for(int i=0;i<list.size();i++){
                IndentVo indentVo = list.get(i);
                BigDecimal total = new BigDecimal(0);
                for(int j=0;j<indentVo.getDetail().size();j++){
                    total = total.add(indentVo.getDetail().get(j).getTotal());
                }
                indentVo.setTotal(total);
            }
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

    //当前端页面传过来的的String类型的日期与后台实体类的Date类型不匹配时，需要加上该方法
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }
}
