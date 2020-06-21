package com.tongji.book.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tongji.book.dao.UserDao;
import com.tongji.book.entity.User;
import com.tongji.book.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User authorizeUser(String userName, String userPassword) {
        return userDao.findByUserNameAndPassword(userName, userPassword);
    }

    public int countAll() {
        return userDao.findAll().size();
    }

    public boolean save(String userStr) {
        JSONObject userObject = JSON.parseObject(userStr);
        String password = userObject.getString("password");
        userObject.put("password", Md5Util.md5Encrypt(password));
        userObject.put("level", 0);
        User user = JSON.parseObject(userObject.toJSONString(), User.class);
        try {
            userDao.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean exitsUserName(String userName) {
        return userDao.findUserByUserName(userName) != null;
    }

}
