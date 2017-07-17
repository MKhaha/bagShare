package com.ywgroup.iecloud.bagshare.dao;

import com.ywgroup.iecloud.bagshare.pojo.BagCollect;

import java.util.List;

public interface BagCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BagCollect record);

    int insertSelective(BagCollect record);

    BagCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BagCollect record);

    int updateByPrimaryKey(BagCollect record);

    List<BagCollect> selectAll();

    List<BagCollect> selectByPageNumber(Integer pagenumber);
}