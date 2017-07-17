package com.ywgroup.iecloud.bagshare.service;

import com.github.pagehelper.PageInfo;
import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.pojo.vo.BagInfoVO;
import com.ywgroup.iecloud.bagshare.pojo.vo.Luxury;
import com.ywgroup.iecloud.bagshare.pojo.vo.Recommend;

import java.util.List;

/**
 * Created by Administrator on 2017-7-10.
 */
public interface IBagShareService {
    ServerResponse<List<Recommend>> getRecommend(int pagesize);
    ServerResponse<List<Luxury>> getLuxury(int pagesize);
    ServerResponse<PageInfo> getBagInfoList(Integer[] types,String status,int bid,int start,int end, int pageNumber, int pageSize);
    ServerResponse<BagInfoVO> getGoodById(int id);
}
