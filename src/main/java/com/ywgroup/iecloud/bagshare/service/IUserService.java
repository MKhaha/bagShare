package com.ywgroup.iecloud.bagshare.service;

import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.pojo.Adress;
import com.ywgroup.iecloud.bagshare.pojo.Payment;
import com.ywgroup.iecloud.bagshare.pojo.User;
import com.ywgroup.iecloud.bagshare.pojo.vo.BagBriefInfoVO;
import com.ywgroup.iecloud.bagshare.pojo.vo.PaymentsVO;

import java.util.List;

/**
 * Created by Administrator on 2017-7-13.
 */
public interface IUserService {

    ServerResponse<User> login(String  phone, String password);
    ServerResponse<List<BagBriefInfoVO>> getFavourites(Integer uid);
    ServerResponse<List<Adress>> getAdress(Integer uid);
    ServerResponse<Payment> payment(Payment payment);
    ServerResponse<List<PaymentsVO>> getPayments(Integer uid);
    ServerResponse<PaymentsVO> updatePayment(Integer id,Integer type);
    ServerResponse<Adress> updateAdress(Integer id,String adress);
    ServerResponse<List<Adress>> setDefaultAdress(Integer id,Integer uid);
    ServerResponse<String> addAdress(Integer uid ,String adress);
    ServerResponse<User> updateName(Integer id,String name);
    ServerResponse<User> updateUserType(Integer id,String type);
}
