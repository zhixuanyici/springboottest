package com.yaic.fa.shiro.shiro.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.yaic.auth.interior.dto.AppUserDto;
import com.yaic.auth.interior.service.AppUserDtoService;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import com.yaic.common.Constants;

/**
 * <p>Author:lujicong
 * <p>Date: 2015-12-9
 * <p>Version: 1.0
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private AppUserDtoService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String userCode = (String)SecurityUtils.getSubject().getPrincipal();
        AppUserDto userDto = new AppUserDto();
        userDto = userService.getInfoByUserCode(userCode);
        
        request.setAttribute(Constants.CURRENT_USER, userDto);
        return true;
    }
}
