package com.ywgroup.iecloud.bagshare.dao;

import com.ywgroup.iecloud.bagshare.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectAll();

    int selecyIdByName(String name);
}