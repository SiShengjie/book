package com.tongji.book.service;

import com.tongji.book.dao.AbroadDao;
import com.tongji.book.entity.Abroad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Abroad)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 20:54:44
 */
@Service
public class AbroadService {

    private AbroadDao abroadDao;

    @Autowired
    public void setAbroadDao(AbroadDao abroadDao) {
        this.abroadDao = abroadDao;
    }

    public List<Abroad> getAll(){
        return abroadDao.findAll();
    }

}