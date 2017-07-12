package com.ywgroup.iecloud.bagshare.service.impl;

import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.dao.BrandsMapper;
import com.ywgroup.iecloud.bagshare.pojo.Brands;
import com.ywgroup.iecloud.bagshare.service.IBransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-7-10.
 */
@Service("iBransService")
public class BrandsServiceImpl implements IBransService{

    @Autowired
    private BrandsMapper brandsMapper;

    @Override
    public ServerResponse<List<Brands>> getAllBrands(){
        List<Brands> brandsList = brandsMapper.selectAll();
        if(brandsList!=null){
            return ServerResponse.createBySuccess("成功",brandsList);
        }
        return ServerResponse.createBySuccessMessage("失败");
    }

    @Override
    public ServerResponse<Brands> getBrandsById(int id) {
        Brands brands = brandsMapper.selectByPrimaryKey(id);
        if(brands!=null){
            return ServerResponse.createBySuccess("成功",brands);
        }
        return ServerResponse.createBySuccessMessage("失败");
    }

//    @Override
//    public ServerResponse<Brands> getBrandsById(String name) {
//        Brands brands = brandsMapper.selectByName(name);
//        if(brands!=null){
//            return ServerResponse.createBySuccess("成功",brands);
//        }
//        return ServerResponse.createBySuccessMessage("失败");
//    }


}
