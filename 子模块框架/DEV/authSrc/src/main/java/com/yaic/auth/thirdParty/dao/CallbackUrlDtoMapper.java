package com.yaic.auth.thirdParty.dao;

import java.util.List;

import com.yaic.auth.thirdParty.dto.CallbackUrlDto;

public interface CallbackUrlDtoMapper {
    int deleteByPrimaryKey ( Integer callbackUrlId );

    int insert ( CallbackUrlDto callbackUrlDto );

    int insertSelective ( CallbackUrlDto callbackUrlDto );

    CallbackUrlDto selectByPrimaryKey ( Integer callbackUrlId );

    int updateByPrimaryKeySelective ( CallbackUrlDto callbackUrlDto );

    int updateByPrimaryKey ( CallbackUrlDto callbackUrlDto );

    List<CallbackUrlDto> selectByConditions ( CallbackUrlDto callbackUrlDto );

    //Î´¶¨ÒåÄ£ºý×Ö¶Î
    List<CallbackUrlDto> selectFuzzyByConditions ( CallbackUrlDto callbackUrlDto );
}