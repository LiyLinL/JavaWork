package com.liy.wsclient.service;

import SFCProductionService.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;


public class WsClient extends WebServiceGatewaySupport {

    public JAXBElement<CreateSfcResponse> Creat() {

        ObjectFactory objectFactory = new ObjectFactory();

        SfcProductionRequest sfcProductionRequest = objectFactory.createSfcProductionRequest();
        sfcProductionRequest.setSite("1001");
        sfcProductionRequest.setMaterial("TRAINING_MATERIAL");
        sfcProductionRequest.setVersion("A");
        sfcProductionRequest.setExpTime("10");

        CreateSfc createSfc = objectFactory.createCreateSfc();
        createSfc.setSfcRequest(sfcProductionRequest);

        JAXBElement<CreateSfc> JaxbCreatSfc = objectFactory.createCreateSfc(createSfc);

        JAXBElement<CreateSfcResponse> response = (JAXBElement<CreateSfcResponse>) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:50000/sapdevwebservice/SFCProductionServiceService?wsdl", JaxbCreatSfc);
        return response;
    }

}