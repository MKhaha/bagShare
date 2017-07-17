package com.ywgroup.iecloud.bagshare.dao;

import com.ywgroup.iecloud.bagshare.pojo.Payment;

import java.util.List;

public interface PaymentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);

    int insertPay(Payment order);

    List<Payment> selectByUid(Integer uid);

}