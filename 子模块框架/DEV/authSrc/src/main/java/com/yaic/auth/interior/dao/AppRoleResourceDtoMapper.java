package com.yaic.auth.interior.dao;

import com.yaic.auth.interior.dto.AppRoleResourceDto;

public interface AppRoleResourceDtoMapper {
    int deleteByPrimaryKey(Integer roleResourceId);

    int insert(AppRoleResourceDto record);

    int insertSelective(AppRoleResourceDto record);

    AppRoleResourceDto selectByPrimaryKey(Integer roleResourceId);

    int updateByPrimaryKeySelective(AppRoleResourceDto record);

    int updateByPrimaryKey(AppRoleResourceDto record);
}