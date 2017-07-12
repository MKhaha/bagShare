package com.ywgroup.iecloud.bagshare.service;

import com.ywgroup.iecloud.bagshare.common.ServerResponse;

/**
 * Created by Administrator on 2017-7-11.
 */
public interface IFavouriteService {
    ServerResponse<String> isFavourite(Integer uid,Integer bid);
    ServerResponse<String> favourite(Integer uid,Integer bid);
}
