package com.liy.wsclient.controller;

import SFCProductionService.CreateSfcResponse;
import SFCProductionService.SfcProductionResponse;
import com.alibaba.fastjson.JSONObject;
import com.liy.wsclient.service.WsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBElement;


@RestController
public class WsController {

    @Autowired
    private WsClient wsClient;

    @RequestMapping("/index")
    public JSONObject index() {
        JAXBElement<CreateSfcResponse> JaxbCreatResponse = wsClient.Creat();
        SfcProductionResponse response = JaxbCreatResponse.getValue().getReturn();

        JSONObject js = new JSONObject();
        js.put("site", response.getSite());
        js.put("shop_order", response.getShopOrder());
        js.put("routing", response.getRouter());
        js.put("sfc", response.getSfc());

       return js;
    }
}
