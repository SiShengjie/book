package com.tongji.book.dao;

import com.tongji.book.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Shengjie Si
 * DateTime: 2019/12/20 22:42
 */
@Repository
public interface EnterpriseDao extends JpaRepository<Enterprise,Integer> {

}
