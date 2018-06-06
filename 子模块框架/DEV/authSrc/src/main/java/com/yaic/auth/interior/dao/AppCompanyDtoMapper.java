package com.yaic.auth.interior.dao;

import com.yaic.auth.interior.dto.AppCompanyDto;

public interface AppCompanyDtoMapper {
    int deleteByPrimaryKey(String companyId);

    int insert(AppCompanyDto record);

    int insertSelective(AppCompanyDto record);

    AppCompanyDto selectByPrimaryKey(String companyId);

    int updateByPrimaryKeySelective(AppCompanyDto record);

    int updateByPrimaryKey(AppCompanyDto record);
}