package com.ywgroup.iecloud.bagshare.dao;

import com.ywgroup.iecloud.bagshare.pojo.BagInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BagInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BagInfo record);

    int insertSelective(BagInfo record);

    BagInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BagInfo record);

    int updateByPrimaryKey(BagInfo record);


    List<BagInfo> selectByPageNumber(Integer pagenumber);

    List<BagInfo> selectByPrice(@Param("types")List<Integer> types, @Param("status")String status, @Param("bid")Integer bid,
                                @Param("start") Integer start, @Param("end") Integer end);

    List<BagInfo> selectAll();
}