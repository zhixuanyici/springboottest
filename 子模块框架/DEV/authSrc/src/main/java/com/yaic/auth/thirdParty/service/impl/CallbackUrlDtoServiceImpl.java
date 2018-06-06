package com.yaic.auth.thirdParty.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yaic.auth.thirdParty.controller.CallbackUrlController;
import com.yaic.auth.thirdParty.dao.CallbackUrlDtoMapper;
import com.yaic.auth.thirdParty.dto.CallbackUrlDto;
import com.yaic.auth.thirdParty.service.CallbackUrlDtoService;
import com.yaic.common.PublicParamters;

@Service
public class CallbackUrlDtoServiceImpl implements CallbackUrlDtoService {
    private static final Logger logger = LoggerFactory.getLogger ( CallbackUrlDtoServiceImpl.class );
    @Autowired
    private CallbackUrlDtoMapper callbackUrlDtoMapper;

    @Override
    public int addInfo ( CallbackUrlDto callbackUrlDto ) {
        // TODO Auto-generated method stub
        return callbackUrlDtoMapper.insertSelective ( callbackUrlDto );
    }

    @Override
    public List<CallbackUrlDto> getListByConditions ( CallbackUrlDto callbackUrlDto ) {
        //临时分页
        PageHelper.startPage ( 2, 2 );
        List<CallbackUrlDto> list = callbackUrlDtoMapper.selectByConditions ( callbackUrlDto );
        return list;
    }

    @Override
    public int updateInfo ( CallbackUrlDto callbackUrlDto ) {
        // TODO Auto-generated method stub
        return callbackUrlDtoMapper.updateByPrimaryKeySelective ( callbackUrlDto );
    }

    @Override
    public int deleteInfo ( Integer callbackUrlId ) {
        CallbackUrlDto callbackUrlDto = new CallbackUrlDto ();
        callbackUrlDto.setCallbackUrlId ( callbackUrlId );
        callbackUrlDto.setValidFlag ( PublicParamters.VALID_FLAG_N );
        return callbackUrlDtoMapper.updateByPrimaryKeySelective ( callbackUrlDto );
    }

    @Override
    public CallbackUrlDto getOneByCallbackUrlId ( Integer callbackUrlId ) {
        // TODO Auto-generated method stub
        return callbackUrlDtoMapper.selectByPrimaryKey ( callbackUrlId );
    }

}
