package com.yaic.auth.interior.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.auth.interior.dao.AppRoleDtoMapper;
import com.yaic.auth.interior.dao.AppUserRoleDtoMapper;
import com.yaic.auth.interior.dto.AppRoleDto;
import com.yaic.auth.interior.service.AppUserRoleDtoService;

@Service
public class AppUserRoleDtoServiceImpl implements  AppUserRoleDtoService{
    
	 @Autowired
	 private AppUserRoleDtoMapper  appUserRoleDtoMapper;
	
	 @Autowired
	 private AppRoleDtoMapper  appRoleDtoMapper;
	
	
	
	
	@Override
	public List<AppRoleDto> getAllRoles() {
		// TODO Auto-generated method stub
		return appRoleDtoMapper.getAllRoles();
	}
	
	
	

}
