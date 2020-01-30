package com.cn.crm.dao;

import com.cn.crm.bean.SalPlanT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalPlanTMapper {
    int deleteByPrimaryKey(Integer plan_id);

    int insert(SalPlanT record);

    int insertSelective(SalPlanT record);

    SalPlanT selectByPrimaryKey(Integer plan_id);

    int updateByPrimaryKeySelective(SalPlanT record);

    int updateByPrimaryKey(SalPlanT record);

    List<SalPlanT> selectByChcId(@Param("chcId") Integer chcId, @Param("page")Integer page,
                                        @Param("rows")Integer rows, @Param("sort")String sort, @Param("order")String order);
}