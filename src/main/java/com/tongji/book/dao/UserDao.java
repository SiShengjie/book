package com.tongji.book.dao;

import com.tongji.book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Intellij IDEA
 * 用户类映射接口
 * User: chunwei wang
 * Date: 2018/6/17
 * Time: 23:32
 **/
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUserNameAndPassword(String userName, String userPassword);

    User findUserByUserName(String userName);

}
