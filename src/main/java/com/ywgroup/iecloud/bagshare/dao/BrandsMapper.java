package com.ywgroup.iecloud.bagshare.dao;

import com.ywgroup.iecloud.bagshare.pojo.Brands;

import java.util.List;

public interface BrandsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Brands record);

    int insertSelective(Brands record);

    Brands selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Brands record);

    int updateByPrimaryKey(Brands record);

    List<Brands> selectAll();

    Brands selectByName(String name);

    Integer selectIdByName(String name);
}