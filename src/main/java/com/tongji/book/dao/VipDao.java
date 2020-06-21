package com.tongji.book.dao;

import com.tongji.book.entity.Vip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Shengjie Si
 * DateTime: 2019/12/31 10:52
 */
@Repository
public interface VipDao extends JpaRepository<Vip,Integer> {

}
