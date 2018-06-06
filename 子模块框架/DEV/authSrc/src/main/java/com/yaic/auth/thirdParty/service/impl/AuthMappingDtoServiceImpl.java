package com.yaic.auth.thirdParty.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yaic.auth.thirdParty.dao.AuthMappingDtoMapper;
import com.yaic.auth.thirdParty.dto.AuthMappingDto;
import com.yaic.auth.thirdParty.dto.AuthTokenDto;

import com.yaic.auth.thirdParty.service.AuthMappingDtoService;

@Service
public class AuthMappingDtoServiceImpl implements AuthMappingDtoService {
    private static final Logger logger = LoggerFactory.getLogger ( AuthMappingDtoServiceImpl.class );
    @Autowired
    private AuthMappingDtoMapper authMappingDtoMapper;

    @Override
    public List<AuthMappingDto> getList ( AuthMappingDto authMappingDto ) {
        //临时分页
        PageHelper.startPage ( 2, 2 );
        List<AuthMappingDto> list = authMappingDtoMapper.selectByConditions ( authMappingDto );
        return list;
    }

    @Override
    public int addInfo ( AuthMappingDto authMappingDto ) {
        return authMappingDtoMapper.insertSelective ( authMappingDto );
    }

}
