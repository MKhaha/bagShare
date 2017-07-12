package com.ywgroup.iecloud.bagshare.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.dao.BagCollectMapper;
import com.ywgroup.iecloud.bagshare.dao.BagInfoMapper;
import com.ywgroup.iecloud.bagshare.pojo.BagCollect;
import com.ywgroup.iecloud.bagshare.pojo.BagInfo;
import com.ywgroup.iecloud.bagshare.pojo.vo.BagBriefInfoVO;
import com.ywgroup.iecloud.bagshare.pojo.vo.BagInfoVO;
import com.ywgroup.iecloud.bagshare.pojo.vo.Luxury;
import com.ywgroup.iecloud.bagshare.pojo.vo.Recommend;
import com.ywgroup.iecloud.bagshare.service.IBagShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-7-10.
 */
@Service("iBagShare")
public class BagShareServiceImpl implements IBagShareService{

    @Autowired
    private BagInfoMapper bagInfoMapper;

    public ServerResponse<List<Recommend>> getRecommend(int maxRowsPerPage){
        List<BagInfo> bagInfoList = bagInfoMapper.selectByPageNumber(maxRowsPerPage);
        List<Recommend> recommendList = new ArrayList<>();
        if(bagInfoList!=null){
            for(BagInfo b : bagInfoList) {
                Recommend recommend = new Recommend();
                recommend.setId(b.getId());
                recommend.setName(b.getName());
                recommend.setMajorPictureAddress(b.getMajorPictureAddress());
                recommend.setBagInformation(b.getBagInformation());
                recommendList.add(recommend);
            }
            return ServerResponse.createBySuccess("成功",recommendList);
        }
        return ServerResponse.createByErrorMessage("失败");
    }

    public ServerResponse<List<Luxury>> getLuxury(int maxRowsPerPage){
        List<BagInfo> bagInfoList = bagInfoMapper.selectByPageNumber(maxRowsPerPage);
        List<Luxury> luxuryList = new ArrayList<>();
        if(bagInfoList!=null){
            for(BagInfo b : bagInfoList) {
                Luxury luxury = new Luxury();
                luxury.setId(b.getId());
                luxury.setName(b.getName());
                luxury.setBrands(b.getBrand());
                luxury.setImg(b.getMajorPictureAddress());
                luxury.setPricezu(b.getPricezu());
                luxury.setPriceya(b.getPriceya());
                luxuryList.add(luxury);
            }
            return ServerResponse.createBySuccess("成功",luxuryList);
        }
        return ServerResponse.createByErrorMessage("失败");
    }

    public ServerResponse<PageInfo> getBagInfoList(String[] types,String status,int bid,int start,int end,int pageNumber,int pageSize){
            PageHelper.startPage(pageNumber, pageSize);
            List<String> ty = new ArrayList();
            for (int i=0;i<types.length;i++){
                ty.add(types[i]);
            }
            List<BagInfo> bagInfoList = bagInfoMapper.selectByPrice(ty,status,bid,start,end);
            List<BagBriefInfoVO> bagBriefInfoVOList = new ArrayList<>();
            for(BagInfo b:bagInfoList){
                BagBriefInfoVO bo = new BagBriefInfoVO();
                bo.setId(b.getId());
                bo.setName(b.getName());
                bo.setEngname(b.getBrand());
                bo.setImg(b.getMajorPictureAddress());
                bo.setPricezu(b.getPricezu());
                bo.setPriceya(b.getPriceya());
                bo.setStatus(b.getStatus());
                bagBriefInfoVOList.add(bo);
            }
            PageInfo pageInfo = new PageInfo(bagInfoList);
            pageInfo.setList(bagBriefInfoVOList);
            if(pageInfo!=null){
                return ServerResponse.createBySuccess("成功",pageInfo);
            }
                return ServerResponse.createByErrorMessage("失败");
        }



        @Override
        public ServerResponse<BagInfoVO> getGoodById(int id) {
            BagInfo bagInfo = bagInfoMapper.selectByPrimaryKey(id);
            BagInfoVO bagInfoVO = new BagInfoVO();
            if(bagInfo!=null){
                bagInfoVO.setId(bagInfo.getId());
                bagInfoVO.setName(bagInfo.getName());
                bagInfoVO.setBrand(bagInfo.getBrand());
                bagInfoVO.setPricezu(bagInfo.getPricezu());
                bagInfoVO.setPriceya(bagInfo.getPriceya());
                bagInfoVO.setPrice(bagInfo.getPrice());
                bagInfoVO.setMajorPictureAddress(bagInfo.getMajorPictureAddress());
                bagInfoVO.setMinorPictureAddress(bagInfo.getMinorPictureAddress().split(";"));
                bagInfoVO.setBagInformation(bagInfo.getBagInformation());
                bagInfoVO.setProduce(bagInfo.getProduce());
                bagInfoVO.setColor(bagInfo.getColor());
                bagInfoVO.setMaterial(bagInfo.getMaterial());
                bagInfoVO.setSize(bagInfo.getSize());
                bagInfoVO.setContent(bagInfo.getContent());
                bagInfoVO.setStatus(bagInfo.getStatus());
                bagInfoVO.setBid(bagInfo.getBid());
                return ServerResponse.createBySuccess("正常",bagInfoVO);
            }
            return ServerResponse.createBySuccessMessage("失败");
        }


}
