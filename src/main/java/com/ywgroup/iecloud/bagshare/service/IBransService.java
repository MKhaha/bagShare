package com.ywgroup.iecloud.bagshare.service;

import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.pojo.Brands;

import java.util.List;

/**
 * Created by Administrator on 2017-7-10.
 */
public interface IBransService {
    ServerResponse<List<Brands>> getAllBrands();
    ServerResponse<Brands> getBrandsById(int id);
    //   ServerResponse<Brands> getBrandsById(String name);
}

