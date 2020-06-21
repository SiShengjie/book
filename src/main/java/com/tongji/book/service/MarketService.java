package com.tongji.book.service;

import com.tongji.book.dao.MarketDao;
import com.tongji.book.entity.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Onmarket)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 20:54:22
 */
@Service
public class MarketService {

    private MarketDao marketDao;

    @Autowired
    public void setOnmarketDao(MarketDao marketDao) {
        this.marketDao = marketDao;
    }

    public List<Market> getAll(){
        return marketDao.findAll();
    }
}