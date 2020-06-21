package com.tongji.book.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * (Vip)实体类
 *
 * @author makejava
 * @since 2020-05-16 19:06:56
 */
@Entity
@Data
public class Vip {

    @Id
    private Integer id;
    
    private String name;
    
    private String code;
    
    private String category;
    
    private String status;
    
    private String kind;
    
    private String product;
    
    private String found;
    
    private String addr;



}