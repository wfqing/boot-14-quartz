package com.etoak.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 地区表对应的实体类
 */
@Data
public class Area implements Serializable {
    // 主键
    private Integer id;
    // 父id（省级父id是0）
    private Integer pid;
    // 地区名称
    private String name;
    // 排序字段
    private Integer sort;

}
