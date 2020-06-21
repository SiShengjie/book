package com.tongji.book.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * (Enterprise)实体类
 *
 * @author makejava
 * @since 2020-05-16 19:06:33
 */
@Entity
@Data
public class Enterprise {

    @Id
    private Integer id;
    
    private String name;
    
    private String url;
    
    private String addr;
    
    private String tel;
    
    private String product;


}