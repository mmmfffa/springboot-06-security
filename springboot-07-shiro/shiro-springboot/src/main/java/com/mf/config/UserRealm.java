package com.mf.config;

import com.mf.pojo.User;
import com.mf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//自定义的Realm对象

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Override//授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行==》授权PrincipalCollection");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user:add");
        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        User currUser = (User) subject.getPrincipal();
        info.addStringPermission(currUser.getPerms());//设置当前用户权限
        return info;
    }

    @Override//认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行==》认证AuthenticationToken");
        //用户名 ，密码~  数据读取
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        User user = userService.queryUserByName(userToken.getUsername());
        if (user==null) return null;//抛出异常

        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("USER_SESSION",user);

        //密码认证交给shiro做，密码加密了
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
