package com.yaic.auth.interior.dao;

import com.yaic.auth.interior.dto.AppParamDto;

public interface AppParamDtoMapper {
    int deleteByPrimaryKey(String parameterId);

    int insert(AppParamDto record);

    int insertSelective(AppParamDto record);

    AppParamDto selectByPrimaryKey(String parameterId);

    int updateByPrimaryKeySelective(AppParamDto record);

    int updateByPrimaryKey(AppParamDto record);
}