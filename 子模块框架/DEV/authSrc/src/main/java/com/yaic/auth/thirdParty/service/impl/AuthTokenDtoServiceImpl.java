package com.yaic.auth.thirdParty.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yaic.auth.thirdParty.dao.AuthTokenDtoMapper;
import com.yaic.auth.thirdParty.dto.AuthTokenDto;
import com.yaic.auth.thirdParty.service.AuthTokenDtoService;
import com.yaic.common.PublicParamters;

@Service
public class AuthTokenDtoServiceImpl implements AuthTokenDtoService {
    private static final Logger logger = LoggerFactory.getLogger ( AuthTokenDtoServiceImpl.class );
    @Autowired
    private AuthTokenDtoMapper authTokenDtoMapper;

    @Override
    public int addInfo ( AuthTokenDto authTokenDto ) {
        // TODO Auto-generated method stub
        return authTokenDtoMapper.insertSelective ( authTokenDto );
    }

    @Override
    public List<AuthTokenDto> getListByConditions ( AuthTokenDto authTokenDto ) {
        //临时分页
        PageHelper.offsetPage ( 1, 1 );
        List<AuthTokenDto> list = authTokenDtoMapper.selectByConditions ( authTokenDto );
        return list;
    }

    @Override
    public int updateInfo ( AuthTokenDto authTokenDto ) {

        return authTokenDtoMapper.updateByAppIdSelective ( authTokenDto );
    }

    @Override
    public int deleteInfo ( String appId ) {
        AuthTokenDto authTokenDto = new AuthTokenDto ();
        authTokenDto.setValidFlag ( PublicParamters.VALID_FLAG_N );
        return authTokenDtoMapper.updateByAppIdSelective ( authTokenDto );
    }

}
