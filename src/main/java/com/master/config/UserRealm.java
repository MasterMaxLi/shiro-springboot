package com.master.config;

import com.master.pojo.User;
import com.master.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
;

/**
 * Creqated by Limingxuan on 2021/3/2
 */
//自定义Realm extends AuthorizingRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");

        //SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user.add");
        //拿到当前登陆用户对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();    //拿到User对象
        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthorizationInfo");

        //String userName = "root";
        //String password = "123456";

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        //连接真实数据库
        User user = userService.queryUserByName(userToken.getUsername());

        if(user == null){
            return null;
        }

        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser", user);
        //可加密：MD5   MD5盐值加密
       //密码验证由Shiro执行
        return new SimpleAuthenticationInfo(user, user.getPassword(),"");
    }
}
