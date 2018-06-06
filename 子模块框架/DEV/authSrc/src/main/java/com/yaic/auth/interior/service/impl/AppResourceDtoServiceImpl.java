package com.yaic.auth.interior.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.auth.interior.dao.AppResourceDtoMapper;
import com.yaic.auth.interior.dto.AppResourceDto;
import com.yaic.auth.interior.service.AppResourceDtoService;
import com.yaic.common.TreeNode;

@Service
public class AppResourceDtoServiceImpl implements AppResourceDtoService {
	
	@Autowired
	AppResourceDtoMapper appResourceDtoMapper;
	
	
	
	
	@Override
    public List<TreeNode> findAllMenuResource(){
        return appResourceDtoMapper.findAllMenuResource();
    }
    
    /**
     * 查找所有服务资源
     */
	@Override
    public List<TreeNode> findAllServiceResource(){
        return appResourceDtoMapper.findAllServiceResource();
    }
    
    /**
     * 查询最大资源ID
     * @return
     */
	@Override
    public List<AppResourceDto> findMaxResourceId(){
    	return appResourceDtoMapper.findMaxResourceId();
    }
    
    /**
     * 
     */
	@Override
	public AppResourceDto getInfoByResourceName(String resourceName) {
		return appResourceDtoMapper.getInfoByResourceName(resourceName);
	}
    

	@Override
	public Integer addInfo(AppResourceDto dto) {
		
//		dto.(PublicParamters.VALID_FLAG_Y);
		//临时用户
		dto.setCreatedBy("admin1111");
		dto.setCreatedDate(new Date());
		//临时用户
		dto.setUpdatedBy("admin1111");
		dto.setUpdatedDate(new Date());
		
		int resu = appResourceDtoMapper.insert(dto);
		return resu;
	}

	@Override
	public Integer updateInfo(AppResourceDto dto) {
		
		dto.setUpdatedDate(new Date());
		//临时用户
		dto.setUpdatedBy("admin1111");
		int resu = appResourceDtoMapper.updateByPrimaryKeySelective(dto);
		return resu;
	}

	@Override
	public Integer deleteInfo(String resourceId) {
		
		int resu = appResourceDtoMapper.deleteByPrimaryKey(resourceId);
		
//		//删除用户排除资源
//		 userExcludeResourceDao.delete(userExcludeResourceDto);
//		//删除用户角色
//		 userRoleDao.delete(userRoleDto);
		
		return resu;
	}

	@Override
	public AppResourceDto getInfoByResourceId(String resourceId) {
		return appResourceDtoMapper.getInfoByResourceId(resourceId);
	}

}
