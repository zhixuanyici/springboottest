package com.yaic.auth.thirdParty.service.impl;

import java.util.List;

import org.apache.catalina.servlet4preview.http.PushBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yaic.auth.thirdParty.dao.ServerDtoMapper;
import com.yaic.auth.thirdParty.dto.AccountDto;
import com.yaic.auth.thirdParty.dto.ProjectDto;
import com.yaic.auth.thirdParty.dto.ServerDto;
import com.yaic.auth.thirdParty.service.ServerDtoService;
import com.yaic.common.PublicParamters;

@Service
public class ServiceServiceImpl implements ServerDtoService {
    private static final Logger logger = LoggerFactory.getLogger ( ServiceServiceImpl.class );

    @Autowired
    private ServerDtoMapper serverDtoMapper;

    @Override
    public List<ServerDto> getList ( ServerDto serverDto ) {
        /*
         * 临时测试分页显示
         */
        //设置分页
        PageHelper.offsetPage ( 1, 2 );
        List<ServerDto> list = serverDtoMapper.selectByConditions ( serverDto );
        return list;

    }

    @Override
    public int addInfo ( ServerDto serverDto ) {
        serverDto.setCreatedUser ( "JS" );
        serverDto.setUpdatedUser ( "JS" );
        serverDto.setValidFlag ( PublicParamters.VALID_FLAG_Y );
        int i = serverDtoMapper.insertSelective ( serverDto );
        return i;
    }

    @Override
    public int updateInfo ( ServerDto serverDto ) {

        return serverDtoMapper.updateByPrimaryKeySelective ( serverDto );
    }

    @Override
    public int deleteInfo ( Integer serverId ) {
        ServerDto serverDto = new ServerDto ();
        serverDto.setServerId ( serverId );
        serverDto.setValidFlag ( PublicParamters.VALID_FLAG_N );
        return serverDtoMapper.updateByPrimaryKeySelective ( serverDto );
    }

    @Override
    public ServerDto getOneByServerId ( Integer serverId ) {
        // TODO Auto-generated method stub
        return serverDtoMapper.selectOneByPrimaryKey ( serverId );
    }

    @Override
    public List<ServerDto> getOneByProjectName ( ServerDto serverDto ) {
        // TODO Auto-generated method stub
        return serverDtoMapper.selectByConditions ( serverDto );
    }

}
