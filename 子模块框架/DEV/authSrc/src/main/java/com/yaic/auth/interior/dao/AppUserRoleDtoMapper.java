package com.yaic.auth.interior.dao;


import com.yaic.auth.interior.dto.AppUserRoleDto;

public interface AppUserRoleDtoMapper {
    int deleteByPrimaryKey(String userRoleId);

    int insert(AppUserRoleDto record);

    int insertSelective(AppUserRoleDto record);

    AppUserRoleDto selectByPrimaryKey(String userRoleId);

    int updateByPrimaryKeySelective(AppUserRoleDto record);

    int updateByPrimaryKey(AppUserRoleDto record);

	void delete(String userCode);

}