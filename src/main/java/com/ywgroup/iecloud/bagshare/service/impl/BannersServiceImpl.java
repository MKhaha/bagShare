package com.ywgroup.iecloud.bagshare.service.impl;

import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.dao.BannersMapper;
import com.ywgroup.iecloud.bagshare.pojo.Banners;
import com.ywgroup.iecloud.bagshare.service.IBannersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-7-11.
 */
@Service("iBannersService")
public class BannersServiceImpl implements IBannersService{

    @Autowired
    private BannersMapper bannersMapper;

    public ServerResponse<List<Banners>> getBanner(int pageSize){
        List<Banners> bannersList = bannersMapper.selectByPageNumber(pageSize);
        if(bannersList!=null){
            return ServerResponse.createBySuccess("成功",bannersList);
        }
        return ServerResponse.createByErrorMessage("失败");
    }
}
