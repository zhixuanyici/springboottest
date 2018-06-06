package com.yaic.auth.thirdParty.dao;

import java.util.List;

import com.yaic.auth.thirdParty.dto.AuthTokenDto;

public interface AuthTokenDtoMapper {
    int insert ( AuthTokenDto authTokenDto );

    int insertSelective ( AuthTokenDto authTokenDto );

    List<AuthTokenDto> selectByConditions ( AuthTokenDto authTokenDto );

    List<AuthTokenDto> selectFuzzyByConditions ( AuthTokenDto authTokenDto );

    //�˴���Ψһֵ��appId��Ψһ
    int updateByAppIdSelective ( AuthTokenDto authTokenDto );
}