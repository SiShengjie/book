package com.tongji.book.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * (Onmarket)实体类
 *
 * @author makejava
 * @since 2020-05-14 20:54:22
 */
@Entity
@Data
public class Market {

    @Id
    private Integer id;
    
    private String name;
    
    private String category;
    
    private String business;
    
    private String kind;
    
    private String product;
    
    private String url;
    
    private String tel;
    
    private String addr;
    
    private String city;
    
    private String pro;

}