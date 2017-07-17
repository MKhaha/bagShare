package com.ywgroup.iecloud.bagshare.service.impl;

import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.dao.*;
import com.ywgroup.iecloud.bagshare.pojo.*;
import com.ywgroup.iecloud.bagshare.pojo.vo.BagBriefInfoVO;
import com.ywgroup.iecloud.bagshare.pojo.vo.PaymentsVO;
import com.ywgroup.iecloud.bagshare.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-7-13.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FavouriteMapper favouriteMapper;
    @Autowired
    private BagInfoMapper bagInfoMapper;
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private AdressMapper adressMapper;

    @Override
    public ServerResponse<User> login(String phone, String password) {
        User u =userMapper.selectByPhoneAndPassword(phone,password);
        if(u!=null){
            u.setPassword("");
            return ServerResponse.createBySuccess("登陆成功",u);
        }
        return ServerResponse.createByErrorMessage("登陆失败");
    }

    @Override
    public ServerResponse<List<BagBriefInfoVO>> getFavourites(Integer uid) {
//        PageHelper.startPage(, pageSize);
        List<Favourite> favouriteList = favouriteMapper.selectByUid(uid);
//        PageInfo p =new PageInfo(favouriteList);

        if(favouriteList!=null){
            List<BagBriefInfoVO> bagBriefInfoVOList = new ArrayList();
            for (Favourite f:favouriteList){
                BagInfo b = bagInfoMapper.selectByPrimaryKey(Integer.parseInt(f.getBagid()));
                if(b!=null){
                    BagBriefInfoVO bo = new BagBriefInfoVO();
                    bo.setId(b.getId());
                    bo.setName(b.getName());
                    bo.setEngname(b.getBrand());
                    bo.setImg(b.getMajorPictureAddress());
                    bo.setPriceya(b.getPriceya());
                    bo.setPricezu(b.getPricezu());
                    bo.setContent(b.getContent());
                    bo.setStatus(b.getStatus());
                    bagBriefInfoVOList.add(bo);
                }
            }
            return ServerResponse.createBySuccess("成功",bagBriefInfoVOList);
        }
        return ServerResponse.createBySuccessMessage("没有收藏");
    }

    @Override
    public ServerResponse<List<Adress>> getAdress(Integer uid) {
        List<Adress> adressList = adressMapper.selectAdressByUid(uid);
        if(adressList!=null){
            return ServerResponse.createBySuccess("成功",adressList);
        }
        return ServerResponse.createBySuccessMessage("地址为空");
    }

    @Override
    @Transactional
    public ServerResponse<Payment> payment(Payment payment) {
        String status = bagInfoMapper.selectStatusById(payment.getBid());
        if ("1".equals(status)){
            return ServerResponse.createByErrorMessage("改商品已经被定走");
        }
        else {
            if(payment.getType()==null){
                payment.setType(0);
            }
            int resultCount2 = paymentMapper.insertPay(payment);
            if (resultCount2>0) {
                int resultCount3 = bagInfoMapper.updateStatusById(payment.getBid());
                if (resultCount3>0) {
                    return ServerResponse.createBySuccess("下单成功",payment);
                }
                else {
                    paymentMapper.deleteByPrimaryKey(payment.getId());
                    return ServerResponse.createByErrorMessage("下单失败");
                }
            }
            return ServerResponse.createByErrorMessage("下单失败");
        }
    }


    @Override
    public ServerResponse<List<PaymentsVO>> getPayments(Integer uid) {
        List<Payment> paymentList = paymentMapper.selectByUid(uid);
        if(paymentList!=null){
            List<PaymentsVO> paymentsVOList = new ArrayList<>();
            for(Payment p :paymentList){
                BagInfo bagInfo = bagInfoMapper.selectByPrimaryKey(p.getBid());
                PaymentsVO vo = this.setPayment(p, bagInfo);
                paymentsVOList.add(vo);
            }
            return ServerResponse.createBySuccess("成功",paymentsVOList);
        }
        return ServerResponse.createBySuccessMessage("订单为空");
    }

    @Override
    @Transactional
    public ServerResponse<PaymentsVO> updatePayment(Integer id, Integer type) {
        Payment payment = paymentMapper.selectByPrimaryKey(id);
        if((payment.getType()==1&&type==0)||(payment.getType()==4&&type==5)){
            bagInfoMapper.updateStatusById2(payment.getBid());
        }
        if((payment.getType()==0&&type==1)||(payment.getType()==5&&type==1)){
            bagInfoMapper.updateStatusById(payment.getBid());
        }
        BagInfo bagInfo = bagInfoMapper.selectByPrimaryKey(payment.getBid());
        payment.setType(type);
        int resultCount = paymentMapper.updateByPrimaryKey(payment);
        if(resultCount>0){
            PaymentsVO vo = this.setPayment(payment, bagInfo);
            return ServerResponse.createBySuccess("成功",vo);
        }
        return ServerResponse.createByErrorMessage("失败");
    }

    @Override
    @Transactional
    public ServerResponse<Adress> updateAdress(Integer id, String adress) {
        Adress adress1 = adressMapper.selectByPrimaryKey(id);
        adress1.setAdress(adress);
        int resultCount = adressMapper.updateByPrimaryKey(adress1);
        if(resultCount>0){
            return ServerResponse.createBySuccess("更新成功",adress1);
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    @Transactional
    public ServerResponse<List<Adress>> setDefaultAdress(Integer id,Integer uid) {
        List<Adress> adressList = adressMapper.selectAdressByUid(uid);
        for (Adress a : adressList){
            if(a.getId()==id){
                a.setType(1);
                adressMapper.updateByPrimaryKey(a);
                continue;
            }
            a.setType(0);
            adressMapper.updateByPrimaryKey(a);
        }
        return ServerResponse.createBySuccess("设置成功",adressList);
    }

    @Override
    public ServerResponse<String> addAdress(Integer uid,String adress1) {
        Adress adress = new Adress();
        adress.setUid(uid);
        adress.setAdress(adress1);
        adress.setType(0);
        int resultCount = adressMapper.insertSelective(adress);
        if(resultCount>0)
            return ServerResponse.createBySuccessMessage("增加成功");
        return ServerResponse.createByErrorMessage("增加失败");
    }

    @Override
    public ServerResponse<User> updateName(Integer id, String name) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setUsername(name);
        int resultCount = userMapper.updateByPrimaryKey(user);
        if(resultCount>0) {
            user.setPassword("");
            return ServerResponse.createBySuccess("修改成功", user);
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse<User> updateUserType(Integer id, String type) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setType(type);
        int resultCount = userMapper.updateByPrimaryKey(user);
        if(resultCount>0){
            user.setPassword("");
            return ServerResponse.createBySuccess("修改成功",user);
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    public PaymentsVO setPayment(Payment payment,BagInfo bagInfo){
        PaymentsVO vo = new PaymentsVO();
        vo.setId(payment.getId());
        vo.setAdress(payment.getAdress());
        vo.setContent(bagInfo.getContent());
        vo.setEngname(bagInfo.getBrand());
        vo.setImg(bagInfo.getMajorPictureAddress());
        vo.setName(bagInfo.getName());
        vo.setPhone(payment.getPhone());
        vo.setPrice(payment.getPrice());
        vo.setPriceya(bagInfo.getPriceya());
        vo.setPricezu(bagInfo.getPricezu());
        vo.setStatus(bagInfo.getStatus());
        vo.setTimes(payment.getTimes());
        vo.setBid(bagInfo.getId());
        vo.setType(payment.getType());
        return vo;
    }

}
