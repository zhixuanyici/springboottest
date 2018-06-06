package com.yaic.auth.interior.dao;

import java.util.List;
import java.util.Map;

import com.yaic.auth.interior.dto.AppResourceDto;
import com.yaic.auth.interior.dto.AppRoleDto;
import com.yaic.common.TreeNodeNew;


public interface AppRoleDtoMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(AppRoleDto record);

    int insertSelective(AppRoleDto record);

    AppRoleDto selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(AppRoleDto record);

    int updateByPrimaryKey(AppRoleDto record);
    
    List<AppRoleDto>  getLists(Map<String,Object>  map);

	int getTotals(Map<String, Object> paraMap);

	//List<AppResourceDto> findResourceByRoleId(Map<String, String> paraMap);

	List<TreeNodeNew> findAllMenuResourceNew();

	List<AppRoleDto> getAllRoles();
}