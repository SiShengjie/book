package com.tongji.book.dao;

import com.tongji.book.entity.Abroad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Shengjie Si
 * DateTime: 2019/11/25 5:38
 */
@Repository
public interface AbroadDao extends JpaRepository<Abroad,Integer> {

}
