package com.tongji.book.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * (Inside)实体类
 *
 * @author makejava
 * @since 2020-05-14 20:53:29
 */
@Entity
@Data
public class Inside {

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
    
    private String province;

}