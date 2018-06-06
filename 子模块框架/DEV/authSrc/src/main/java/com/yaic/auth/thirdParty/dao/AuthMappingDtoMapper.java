package com.yaic.auth.thirdParty.dao;

import java.util.List;

import com.yaic.auth.thirdParty.dto.AuthMappingDto;

public interface AuthMappingDtoMapper {
    int deleteByPrimaryKey ( Integer mappingId );

    int insert ( AuthMappingDto authMappingDto );

    int insertSelective ( AuthMappingDto authMappingDto );

    AuthMappingDto selectByPrimaryKey ( Integer mappingId );

    int updateByPrimaryKeySelective ( AuthMappingDto authMappingDto );

    int updateByPrimaryKey ( AuthMappingDto authMappingDto );

    List<AuthMappingDto> selectByConditions ( AuthMappingDto authMappingDto );
}