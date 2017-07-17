package com.ywgroup.iecloud.bagshare.service.impl;

import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.dao.CategoryMapper;
import com.ywgroup.iecloud.bagshare.pojo.Category;
import com.ywgroup.iecloud.bagshare.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-7-11.
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ServerResponse<List<Category>> selectAll() {
        List<Category> categoryList = categoryMapper.selectAll();
        if(categoryList!=null){
            return ServerResponse.createBySuccess("成功",categoryList);
        }
        return ServerResponse.createBySuccessMessage("失败");
    }
}
