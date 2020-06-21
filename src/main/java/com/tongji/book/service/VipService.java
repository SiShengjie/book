package com.tongji.book.service;

import com.tongji.book.dao.VipDao;
import com.tongji.book.entity.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Shengjie Si
 * DateTime: 2019/12/31 10:49
 */
@Service
public class VipService {

    private VipDao vipDao;

    @Autowired
    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public List<Vip> findAll(){
        return vipDao.findAll();
    }
}
