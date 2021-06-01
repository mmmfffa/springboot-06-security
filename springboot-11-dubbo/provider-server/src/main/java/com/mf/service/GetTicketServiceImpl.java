package com.mf.service;

import org.apache.dubbo.config.annotation.DubboService;
//zookeeper：服务注册与发现
@DubboService
public class GetTicketServiceImpl implements GetTicketService{

    @Override
    public String buy() {
        return "恭喜买到了票";
    }
}
