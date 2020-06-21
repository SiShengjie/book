package com.tongji.book.service;

import com.tongji.book.dao.EnterpriseDao;
import com.tongji.book.entity.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Shengjie Si
 * DateTime: 2019/12/20 22:44
 */
@Service
public class EnterpriseService {

    private EnterpriseDao enterpriseDao;

    @Autowired
    public void setEnterpriseDao(EnterpriseDao enterpriseDao) {
        this.enterpriseDao = enterpriseDao;
    }

    public List<Enterprise> getAll(){
        return enterpriseDao.findAll();
    }
}
