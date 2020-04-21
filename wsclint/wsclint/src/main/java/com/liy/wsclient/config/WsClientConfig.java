package com.liy.wsclient.config;

import com.liy.wsclient.auth.WebServiceMessageSendWithAuth;
import com.liy.wsclient.service.WsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsClientConfig {

    @Value("${sap.nwa.usr}")
    private String usr;

    @Value("${sap.nwa.passwd}")
    private String passwd;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        //会扫描此类下面的对应的 jaxb2实体类 因为是使用 Marshaller和 unmarshaller来进行xml和bean直接转换的
        //具体是判断此路径下是否包含 ObjectFactory.class 文件
        //设置 JAXBContext 对象
        marshaller.setContextPath("SFCProductionService");
        //或者使用 以下方式设置
        //marshaller.setPackagesToScan(packagesToScan);
        //marshaller.setClassesToBeBound(classesToBeBound);
        return marshaller;
    }

    /*
     * 创建bean
     */
    @Bean
    public WsClient wsClient(Jaxb2Marshaller marshaller) {
        WsClient client = new WsClient();
        //默认对应的ws服务地址 client请求中还能动态修改
        //client.setDefaultUri("http://localhost:8080/ws");
        client.setDefaultUri("http://localhost:50000/sapdevwebservice/SFCProductionServiceService?wsdl");
        client.setMarshaller(marshaller);//指定转换类
        client.setUnmarshaller(marshaller);
        client.setMessageSender(new WebServiceMessageSendWithAuth(usr, passwd));
        return client;
    }
}
