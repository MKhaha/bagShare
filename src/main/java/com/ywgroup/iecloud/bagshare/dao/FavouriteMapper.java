package com.ywgroup.iecloud.bagshare.dao;

import com.ywgroup.iecloud.bagshare.pojo.Favourite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavouriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Favourite record);

    int insertSelective(Favourite record);

    Favourite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Favourite record);

    int updateByPrimaryKey(Favourite record);

    int selectByUidAndBid(@Param("uid") Integer uid,@Param("bid") Integer bid);

    int deleteByUidAndBid(@Param("uid") Integer uid,@Param("bid") Integer bid);

    int insertByUidAndBid(@Param("uid") Integer uid,@Param("bid") Integer bid);

    List<Favourite> selectByUid(Integer uid);
}