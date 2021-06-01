package com.mf.service;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //想拿到provider-server提供的服务，要去注册中心拿
    @Reference
    GetTicketService getTicketService;
    public void buy(){
        getTicketService.buy();
        System.out.println("在注册中心拿到票");
    }

}
