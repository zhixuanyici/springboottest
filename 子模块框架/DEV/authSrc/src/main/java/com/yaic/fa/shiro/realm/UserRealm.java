package com.yaic.fa.shiro.realm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yaic.auth.interior.dto.AppRoleResourceDto;
import com.yaic.auth.interior.dto.AppUserDto;
import com.yaic.auth.interior.dto.AppUserRoleDto;
import com.yaic.auth.interior.service.AppUserDtoService;
import com.yaic.common.Constants;

@Service
public class UserRealm extends AuthorizingRealm{
    
    
//    @Log("auditLogger")
//    private Logger auditLogger;
//    
//    @Log
//    private Logger logger;

    @Autowired
    private AppUserDtoService userService;
    

    /**
     * 校验权限
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userCode = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        List<AppUserRoleDto> roles = userService.findUserRoles(userCode) ;
//        String[] roleArr = new String[roles.size()];
//        for(int i=0;i< roles.size() ;i++){
//        	AppUserRoleDto role = roles.get(i) ;
//            if("true".equals(role.getCongfigFlag())){
//                roleArr[i] = role.getRoleId();
//            }
//        }
//        Set<String> roleSet = new HashSet(Arrays.asList(roleArr));
//        if(roleSet.contains(null)){
//            roleSet.remove(null);
//        }
//        authorizationInfo.setRoles(roleSet);
//        
//        List<AppRoleResourceDto> roleResources = userService.findUserResources(userCode) ;
//        String[] roleResourcesArr = new String[roleResources.size()];
//        for(int i=0;i< roleResources.size() ;i++){
//            if(!StringUtils.isEmpty(roleResources.get(i)) && !StringUtils.isEmpty(roleResources.get(i).getResourceId())){
//                roleResourcesArr[i] = roleResources.get(i).getResourceId();
//            }
//        }
//        Set<String> permissionSet = new HashSet(Arrays.asList(roleResourcesArr));
//        if(permissionSet.contains(null)){
//            //非空校验
//            permissionSet.remove(null);
//        }
//        authorizationInfo.setStringPermissions(permissionSet);

        return authorizationInfo;
    }

    /**
     * 用户登录账号校验
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String userCode = (String)token.getPrincipal();
        AppUserDto user = userService.getInfoByUserCode(userCode);


        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if ("0".equals(user.getValidFlag()) ) {
            throw new LockedAccountException(); // 帐号锁定
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserCode(), //用户代码
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getUserCode() + "cms"),//salt=usercode + cms
                getName()  //realm name
        );
        
        Subject currentUser = SecurityUtils.getSubject(); 
        Session session = currentUser.getSession();
        session.setAttribute(Constants.CURRENT_USER,user);
        session.setAttribute(Constants.LOGIN_USER_ID_KEY, user.getUserCode());
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        //clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
  
}
