package com.ywgroup.iecloud.bagshare.service.impl;

import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.dao.FavouriteMapper;
import com.ywgroup.iecloud.bagshare.service.IFavouriteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-7-11.
 */
@Service("iFavouriteService")
public class FavouriteServiceImpl implements IFavouriteService{

    @Autowired
    private FavouriteMapper favouriteMapper;
    @Override
    public ServerResponse<String> isFavourite(Integer uid, Integer bid) {
        String status = "0";
        int a = favouriteMapper.selectByUidAndBid(uid,bid);
        if (a>0){
            status = "1";
            return ServerResponse.createBySuccess("成功",status);
        }else {
            status = "0";
            return ServerResponse.createByError("失败",status);
        }
    }

    @Override
    public ServerResponse<String> favourite(Integer uid, Integer bid) {
       String status = "0";
        int a = favouriteMapper.selectByUidAndBid(uid,bid);
        if (a>0){
            int b = favouriteMapper.deleteByUidAndBid(uid,bid);
            if (b>0){
                status ="0";
                return ServerResponse.createBySuccess("成功",status);
            }
            else {
                status = "1";
                return ServerResponse.createByError("失败", status);
            }
        }
        else {
            int b = favouriteMapper.insertByUidAndBid(uid,bid);
            if (b>0) {
                status = "1";
                return ServerResponse.createBySuccess("成功", status);
            }
            else {
                status = "0";
                return ServerResponse.createByError("失败",status);
            }
        }
    }
}
