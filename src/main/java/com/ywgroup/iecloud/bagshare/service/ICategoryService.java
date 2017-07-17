package com.ywgroup.iecloud.bagshare.service;

import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.pojo.Category;

import java.util.List;

/**
 * Created by Administrator on 2017-7-11.
 */
public interface ICategoryService {
    ServerResponse<List<Category>> selectAll();
}
