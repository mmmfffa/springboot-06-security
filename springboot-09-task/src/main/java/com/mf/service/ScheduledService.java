package com.mf.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //cron表达式
    //秒，分，时，日，月，周几
    //0 27 23 * * ? 每天的23点27分执行
    //0 2/7 2,3 * * ? 每天的2点和3点2分执行，每隔7分钟
    //0 15 10 ? * 1-6 每月的周1到6  10点15分执行
    @Scheduled(cron = "0 27 23 * * ?")//周一到周天的每天的0秒执行
    public void schedule(){
        System.out.println("在特定时间被执行了");
    }
}
