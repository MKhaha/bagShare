package com.ywgroup.iecloud.bagshare.dao;

import com.ywgroup.iecloud.bagshare.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

}