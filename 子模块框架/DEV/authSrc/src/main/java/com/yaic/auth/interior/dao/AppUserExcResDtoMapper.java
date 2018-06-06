package com.yaic.auth.interior.dao;

import com.yaic.auth.interior.dto.AppUserExcResDto;

public interface AppUserExcResDtoMapper {
    int deleteByPrimaryKey(Integer userExcludeResourceId);

    int insert(AppUserExcResDto record);

    int insertSelective(AppUserExcResDto record);

    AppUserExcResDto selectByPrimaryKey(Integer userExcludeResourceId);

    int updateByPrimaryKeySelective(AppUserExcResDto record);

    int updateByPrimaryKey(AppUserExcResDto record);

	void delete(String userCode);
}