package com.mf.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求中的语言参数
        String language = httpServletRequest.getParameter("l");
        Locale requestLocale = httpServletRequest.getLocale();//如果没有就使用默认的
        if (!StringUtils.isEmpty(language)){//如果不为空就使用我们自己传过来的
             //zh_CN 国家，地区
            String[] split = language.split("_");
            requestLocale = new Locale(split[0], split[1]);
        }
        return requestLocale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
