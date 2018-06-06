package com.yaic.auth.interior.dao;

import com.yaic.auth.interior.dto.AppParamTypeDto;

public interface AppParamTypeDtoMapper {
    int deleteByPrimaryKey(String parameterTypeId);

    int insert(AppParamTypeDto record);

    int insertSelective(AppParamTypeDto record);

    AppParamTypeDto selectByPrimaryKey(String parameterTypeId);

    int updateByPrimaryKeySelective(AppParamTypeDto record);

    int updateByPrimaryKey(AppParamTypeDto record);
}