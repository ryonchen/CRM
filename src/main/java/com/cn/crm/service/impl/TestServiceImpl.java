package com.cn.crm.service.impl;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-03 00:52
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.crm.dao.TestMapper;
import com.cn.crm.service.TestService;

/**
 * Created by infodba on 2018/5/23.
 */

@Service("testService")
public class TestServiceImpl implements TestService {


    @Autowired(required = false)
    private TestMapper testMapper;

    @Override
    public int testAction() {

        int i = testMapper.selectCount();

        return i;
    }
}