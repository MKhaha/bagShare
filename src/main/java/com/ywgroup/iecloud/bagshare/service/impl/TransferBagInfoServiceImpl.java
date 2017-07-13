package com.ywgroup.iecloud.bagshare.service.impl;

import com.ywgroup.iecloud.bagshare.dao.BagCollectMapper;
import com.ywgroup.iecloud.bagshare.dao.BagInfoMapper;
import com.ywgroup.iecloud.bagshare.dao.BrandsMapper;
import com.ywgroup.iecloud.bagshare.dao.CategoryMapper;
import com.ywgroup.iecloud.bagshare.pojo.BagCollect;
import com.ywgroup.iecloud.bagshare.pojo.BagInfo;
import com.ywgroup.iecloud.bagshare.pojo.Brands;
import com.ywgroup.iecloud.bagshare.service.ITransferBagInfoService;
import com.ywgroup.iecloud.bagshare.util.StringTestUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/7/6.
 */
@Service("iTransferBagInfo")
public class TransferBagInfoServiceImpl implements ITransferBagInfoService {

    @Autowired
    private BagCollectMapper bagCollectMapper;
    @Autowired
    private BagInfoMapper bagInfoMapper;
    @Autowired
    private BrandsMapper brandsMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    private List<String> getElementsContent(Elements elements) {
        List<String> stringList = new ArrayList<>();
        for (Element element : elements) {
            for (Element item : element.children()) {
                stringList.add(item.text());
            }
        }
        return stringList;
    }

    private boolean setBagInfo(BagCollect bagCollect, BagInfo bagInfo) {

        try {
            Document doc = Jsoup.connect(bagCollect.getAddress()).get();

            // 设置包包品牌
            Elements brandElements = doc.select("#parameter-brand");
            List<String> brandStrings = getElementsContent(brandElements);
            String brandTemp = brandStrings.get(0);
            String brands[] = brandTemp.split("[:|：]");
            String brand = brands[1].trim();
            if (StringUtils.isBlank(brand)) {
                return false;
            }
            bagInfo.setBrand(brand);
            System.out.println(brand);
            System.out.println(brands[0] + " " + brands[1]);
            System.out.println(brandStrings);


            // 设置包包主图和辅图地址
            Elements newsHeadlines = doc.select("ul.parameter2.p-parameter-list");
            List<String> detailStrings = getElementsContent(newsHeadlines);
            if (detailStrings.isEmpty()) {
                return false;
            }
            bagInfo.setBagInformation(StringUtils.join(detailStrings.toArray(), ";"));
            System.out.println(detailStrings);

            Elements detailImageElements = doc.select("#J-detail-content > div.ssd-module-wrap > div.ssd-module > div.ssd-widget-pic > img");
            List<String> imageAddressList = new ArrayList<>();
            for (Element element : detailImageElements) {
                String imageAddress = element.attr("data-lazyload");
                if (imageAddress.startsWith("http")) {
                    imageAddressList.add(imageAddress);
                }
                System.out.println(imageAddress);
                System.out.println(element);
            }
            System.out.println(imageAddressList);

            if (imageAddressList.isEmpty()) {
                return false;
            }

            bagInfo.setMajorPictureAddress(imageAddressList.get(0));
            bagInfo.setMinorPictureAddress(StringUtils.join(imageAddressList.toArray(), ";"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }

        // 设置包包的名称
        bagInfo.setName(bagCollect.getName());

        // 设置包包数据的价格
        bagInfo.setPrice(new BigDecimal(bagCollect.getPrice()));
        return true;
    }

    @Override
    public void transferBagInfo() {
        List<BagCollect> bagCollectList = bagCollectMapper.selectAll();

        BagInfo bagInfo = new BagInfo();
        for (BagCollect item : bagCollectList) {
            setBagInfo(item, bagInfo);
            bagInfoMapper.insertSelective(bagInfo);
        }
    }

    @Override
    public void updateBagInfo(){
        List<BagInfo> bagInfoList = bagInfoMapper.selectAll();
        for (BagInfo b : bagInfoList){
            String[] infos = b.getBagInformation().split(";");
            for(int i=0;i<infos.length;i++){
                String[] info = infos[i].split("：");
                switch (info[0]) {
                    case "商品名称":
                        b.setName(info[1]);
                        break;
//                    case "商品产地":
//                        b.setProduce(info[1]);
//                        break;
//                    case "颜色":
//                        b.setColor(info[1]);
//                        break;
//                    case "材质":
//                        b.setMaterial(info[1]);
//                        break;
//                    case "尺寸":
//                        b.setSize(info[1]);
//                        break;
//                    case "功能":
//                        b.setCategory(info[1]);
//                        break;
                    default:
                        break;
                }
            }
            bagInfoMapper.updateByPrimaryKey(b);
        }
    }

    @Override
    public void updateBagInfo2(){
        List<BagInfo> bagInfoList = bagInfoMapper.selectAll();
        for (BagInfo b : bagInfoList){
            Integer bid = brandsMapper.selectIdByName(b.getBrand());
            b.setBid(bid);
            bagInfoMapper.updateByPrimaryKey(b);
        }
    }

    @Override
    public void updateBagInfo3() {
        List<BagInfo> bagInfoList = bagInfoMapper.selectAll();
        for (BagInfo b : bagInfoList){
            Integer cid = categoryMapper.selecyIdByName(b.getCategory());
            b.setCategoryid(cid);
            bagInfoMapper.updateByPrimaryKey(b);
        }
    }

    @Override
    public void updateBagInfo4() {
        List<BagInfo> bagInfoList = bagInfoMapper.selectAll();
        for (BagInfo b : bagInfoList){
            Double i = Double.valueOf(String.valueOf(b.getPrice().toString()));
            b.setPriceya(new BigDecimal(Math.floor(i/5)));
            b.setPricezu(new BigDecimal(Math.floor(i/50)));
            bagInfoMapper.updateByPrimaryKey(b);
        }
    }
}



