package com.ywgroup.iecloud.bagshare.controller;

import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.pojo.Adress;
import com.ywgroup.iecloud.bagshare.pojo.Payment;
import com.ywgroup.iecloud.bagshare.pojo.User;
import com.ywgroup.iecloud.bagshare.pojo.vo.BagBriefInfoVO;
import com.ywgroup.iecloud.bagshare.pojo.vo.PaymentsVO;
import com.ywgroup.iecloud.bagshare.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017-7-13.
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String  phone,String password){
        return iUserService.login(phone,password);
    }

    @RequestMapping(value = "updateName.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> updateName(int id ,String name){
        return iUserService.updateName(id,name);
    }

    @RequestMapping(value = "updateUserType.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> updateUserType(int id ,String type){
        return iUserService.updateUserType(id,type);
    }

    @RequestMapping(value = "getFavourites.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<BagBriefInfoVO>> getCollections(int uid){
        return iUserService.getFavourites(uid);
    }

    @RequestMapping(value = "getAdress.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Adress>> getAdress(int uid){
        return iUserService.getAdress(uid);
    }

    @RequestMapping(value = "payment.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Payment> payment(Payment payment){
        return iUserService.payment(payment);
    }

    @RequestMapping(value = "getPayments.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<PaymentsVO>> getPayments(Integer uid){
        return iUserService.getPayments(uid);
    }

    @RequestMapping(value = "updatePayment.do" ,method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PaymentsVO> updatePayment(int id,int type){
        return iUserService.updatePayment(id,type);
    }

    @RequestMapping(value = "updateAdress.do" ,method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Adress> updateAdress(int id,String adress){
        return iUserService.updateAdress(id,adress);
    }

    @RequestMapping(value = "setDefaultAdress.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Adress>> setDefaultAdress(int id,int uid){
        return iUserService.setDefaultAdress(id,uid);
    }

    @RequestMapping(value = "addAdress.do" ,method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addAdress(int uid,String  adress){
        return iUserService.addAdress(uid,adress);
    }
}
