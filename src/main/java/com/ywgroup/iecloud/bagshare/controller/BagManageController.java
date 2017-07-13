package com.ywgroup.iecloud.bagshare.controller;

import com.github.pagehelper.PageInfo;
import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.pojo.*;
import com.ywgroup.iecloud.bagshare.pojo.vo.BagInfoVO;
import com.ywgroup.iecloud.bagshare.pojo.vo.Luxury;
import com.ywgroup.iecloud.bagshare.pojo.vo.Recommend;
import com.ywgroup.iecloud.bagshare.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 */
@Controller
@RequestMapping("/bagManage/")
public class BagManageController {

    @Autowired
    private ITransferBagInfoService iTransferBagInfo;
    @Autowired
    private IBagShareService iBagShare;
    @Autowired
    private IBransService iBransService;
    @Autowired
    private IBannersService iBannersService;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IFavouriteService iFavouriteService;

    private Logger logger = LoggerFactory.getLogger(BagManageController.class);

    @RequestMapping(value = "test.do")
    @ResponseBody
    public ServerResponse<String> login(){
        return ServerResponse.createByErrorMessage("hello ~~~");
    }

    @RequestMapping(value = "transferBagInfo.do")
    @ResponseBody
    public ServerResponse<String> transferBagInfo(){
        iTransferBagInfo.transferBagInfo();
        return ServerResponse.createByErrorMessage("hello ~~~");
    }

    @RequestMapping("up.do")
    @ResponseBody
    public ServerResponse<String> updateBaginfo(){
        iTransferBagInfo.updateBagInfo3();
        return ServerResponse.createBySuccessMessage("ok");
    }

    //1.获得首页轮播图信息
    @RequestMapping(value = "getBanner.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Banners>> getBanner(int pageSize){

        return iBannersService.getBanner(pageSize);
    }

    //2.获得首页推荐商品信息
    @RequestMapping(value = "getRecommend.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Recommend>> getRecommend(int pageSize){

        return iBagShare.getRecommend(pageSize);
    }

    //3.首页显示商品信息
    @RequestMapping(value = "getLuxury.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Luxury>> getLuxury(int pageSize){

        return iBagShare.getLuxury(pageSize);
    }

    //4.获得所有品牌
    @RequestMapping(value = "getBrands.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Brands>> getBrands(){
        return iBransService.getAllBrands();
    }

    //5.获取商品分类
    @RequestMapping(value = "getGoodsCategory.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Category>> getGoodsCategory(){
        return iCategoryService.selectAll();
    }

    //6.获得商品列表（按价格排序）
    @RequestMapping(value = "getAllGoodsByPrice.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getAllGoodsByPrice(@RequestParam(value = "types",defaultValue = "") Integer[] types,
                                                       @RequestParam(value = "status",defaultValue = "")String status,
                                                       @RequestParam("bid") int bid,
                                                       int start,
                                                       int end,
                                                       @RequestParam(value="pageNumber",defaultValue = "1") int pageNumber,
                                                       @RequestParam(value="pageSize",defaultValue = "10") int pageSize){

        if(org.apache.commons.lang3.ArrayUtils.isEmpty(types)&&org.apache.commons.lang3.StringUtils.isBlank(status)){
            status = null;
            Integer[] i = new Integer[5];
            for (int j = 1;j<6;j++){
                i[j-1] = j;
            }
            return iBagShare.getBagInfoList(i,status,bid,start,end,pageNumber,pageSize);
        }
        if(org.apache.commons.lang3.ArrayUtils.isEmpty(types)){
            Integer[] i = new Integer[5];
            for (int j = 1;j<6;j++){
                i[j-1] = j;
            }
            return iBagShare.getBagInfoList(i,status,bid,start,end,pageNumber,pageSize);
        }
        if(org.apache.commons.lang3.StringUtils.isBlank(status)){
            status = null;
        }

        return iBagShare.getBagInfoList(types,status,bid,start,end,pageNumber,pageSize);
    }

    //7.获取商品信息
    @RequestMapping(value = "getGoodById.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<BagInfoVO> getGoodById(int id){
        return iBagShare.getGoodById(id);
    }

    //8.获取商品图片

    //9.获取品牌信息
    @RequestMapping(value = "getBrandById.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Brands> getBrandById(int id){
        return iBransService.getBrandsById(id);
    }
//    @RequestMapping(value = "getBrandById.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<Brands> getBrandById(String name){
//        return iBransService.getBrandsById(name);
//    }

    //10.检查是否已收藏
    @RequestMapping(value = "isFavourite.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> isFavourite(int uid,int id){
        uid = 1;
        return iFavouriteService.isFavourite(uid,id);
    }

    //11.收藏/取消收藏
    @RequestMapping(value = "favourite.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> favourite(int uid,int id){
        uid = 1;
        return iFavouriteService.favourite(uid,id);
    }

}
