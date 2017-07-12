package com.ywgroup.iecloud.bagshare.dao;

import com.ywgroup.iecloud.bagshare.pojo.Banners;

import java.util.List;

public interface BannersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banners record);

    int insertSelective(Banners record);

    Banners selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banners record);

    int updateByPrimaryKey(Banners record);

    List<Banners> selectByPageNumber(Integer pageSize);


}