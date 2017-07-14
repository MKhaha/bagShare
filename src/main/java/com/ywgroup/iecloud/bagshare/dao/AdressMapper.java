package com.ywgroup.iecloud.bagshare.dao;

import com.ywgroup.iecloud.bagshare.pojo.Adress;

import java.util.List;

public interface AdressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Adress record);

    int insertSelective(Adress record);

    Adress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Adress record);

    int updateByPrimaryKey(Adress record);

    List<Adress> selectAdressByUid(Integer uid);
}