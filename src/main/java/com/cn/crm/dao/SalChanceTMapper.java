package com.cn.crm.dao;

import com.cn.crm.bean.SalChance;
import com.cn.crm.bean.SalChanceT;
import org.apache.ibatis.annotations.Param;
import sun.util.resources.cldr.mg.LocaleNames_mg;

import java.util.List;
import java.util.Map;

public interface SalChanceTMapper {
    int deleteByPrimaryKey(Integer chcId);

    int insert(SalChanceT record);

    int insertSelective(SalChanceT record);

    SalChanceT selectByPrimaryKey(Integer chcId);

    int updateByPrimaryKeySelective(SalChanceT record);

    int updateByPrimaryKey(SalChanceT record);

    List<SalChanceT> selectByCreateTime(@Param("beginDate") Long beginDate, @Param("endDate")Long endDate,
                                        @Param("custName")String custName, @Param("title")String title,
                                        @Param("linkman")String linkman, @Param("page")Integer page,
                                        @Param("rows")Integer rows, @Param("sort")String sort, @Param("order")String order);

    int deleteByPrimaryKeys(Integer[] chcIds);

    long countByCreateTime(@Param("beginDate") Long beginDate, @Param("endDate")Long endDate,
                           @Param("custName")String custName, @Param("title")String title,
                           @Param("linkman")String linkman, @Param("page")Integer page,
                           @Param("rows")Integer rows, @Param("sort")String sort, @Param("order")String order) ;
}