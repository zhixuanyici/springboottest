package com.yaic.auth.thirdParty.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaic.auth.thirdParty.dto.AuthTokenDto;
import com.yaic.auth.thirdParty.service.AuthTokenDtoService;

@RestController
@RequestMapping( "/authtoken" )
public class AuthTokenController {
    private static final Logger logger = LoggerFactory.getLogger ( AuthTokenController.class );
    @Autowired
    private AuthTokenDtoService authTokenDtoService;

    @PostMapping( "/list" )
    public List<AuthTokenDto> getList ( @RequestBody AuthTokenDto authTokenDto ) {
        return authTokenDtoService.getListByConditions ( authTokenDto );
    }

    @PostMapping( "/changeInfo" )
    public String saveOrUpdParaType ( @RequestBody AuthTokenDto authTokenDto ) {
        StringBuffer msg = new StringBuffer ();
        if ( "add".equals ( authTokenDto.getReqType () ) ) {
            authTokenDtoService.addInfo ( authTokenDto );
        }
        else {
            msg.append ( "添加失败" );
        }
        if ( "edit".equals ( authTokenDto.getReqType () ) ) {
            authTokenDtoService.updateInfo ( authTokenDto );
        }
        else {
            msg.append ( "更新失败" );
        }
        return msg.toString ();
    }

    @GetMapping( value = "/delete/{appId}" )
    public int delete ( @PathVariable String appId ) {
        return authTokenDtoService.deleteInfo ( appId );

    }

}
