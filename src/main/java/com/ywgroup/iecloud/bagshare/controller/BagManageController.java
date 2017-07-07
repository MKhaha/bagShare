package com.ywgroup.iecloud.bagshare.controller;

import com.ywgroup.iecloud.bagshare.common.ServerResponse;
import com.ywgroup.iecloud.bagshare.service.ITransferBagInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/7/6.
 */
@Controller
@RequestMapping("/bagManage/")
public class BagManageController {

    @Autowired
    private ITransferBagInfoService iTransferBagInfo;

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

}
