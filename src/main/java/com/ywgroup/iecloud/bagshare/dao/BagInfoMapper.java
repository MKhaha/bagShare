package com.ywgroup.iecloud.bagshare.dao;

import com.ywgroup.iecloud.bagshare.pojo.BagInfo;

public interface BagInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BagInfo record);

    int insertSelective(BagInfo record);

    BagInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BagInfo record);

    int updateByPrimaryKey(BagInfo record);
}