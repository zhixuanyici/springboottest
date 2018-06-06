package com.yaic.auth.thirdParty.dao;

import com.yaic.auth.thirdParty.dto.AuthEncryptDto;

public interface AuthEncryptDtoMapper {
    int deleteByPrimaryKey(Integer authId);

    int insert(AuthEncryptDto record);

    int insertSelective(AuthEncryptDto record);

    AuthEncryptDto selectByPrimaryKey(Integer authId);

    int updateByPrimaryKeySelective(AuthEncryptDto record);

    int updateByPrimaryKey(AuthEncryptDto record);
}