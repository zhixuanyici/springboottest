package com.yaic.auth.thirdParty.dao;

import java.util.List;

import com.yaic.auth.thirdParty.dto.ServerDto;

public interface ServerDtoMapper {
    int deleteByPrimaryKey ( Integer serverId );

    int insert ( ServerDto serverDto );

    int insertSelective ( ServerDto serverDto );

    ServerDto selectOneByPrimaryKey ( Integer serverId );

    int updateByPrimaryKeySelective ( ServerDto serverDto );

    int updateByPrimaryKey ( ServerDto serverDto );
    
    List<ServerDto> selectByConditions(ServerDto serverDto);
    
    List<ServerDto> selectFuzzyByConditions(ServerDto serverDto);
   
}