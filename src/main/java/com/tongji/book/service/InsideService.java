package com.tongji.book.service;

import com.tongji.book.dao.InsideDao;
import com.tongji.book.entity.Inside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Inside)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 20:53:29
 */
@Service
public class InsideService {

    private InsideDao insideDao;

    @Autowired
    public void setInsideDao(InsideDao insideDao) {
        this.insideDao = insideDao;
    }

    public List<Inside> getAll(){
        return insideDao.findAll();
    }
}