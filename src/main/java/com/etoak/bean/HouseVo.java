package com.etoak.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class HouseVo extends House {

    // 租赁方式名称
    private String rentModeName;
    // 户型名称
    private String houseTypeName;
    // 朝向名称
    private String orientationName;

    /**
     * 这里使用数组和List两种方式接收前端多选框中的参数
     */
    // 接收前端的户型参数
    @JsonIgnore // 不把这个字段封装到返回结果json中
    private String[] houseTypeList;
    // 接收前端的朝向参数
    @JsonIgnore
    private List<String> orientationList;

    // 100-1000, 1000-1500
    // 这个不是用来接收前端参数，而是传入到mybatis的参数
    @JsonIgnore
    List<Map<String, Integer>> rentalMapList;
}
