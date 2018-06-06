package com.yaic.auth.thirdParty;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yaic.auth.Run;
import com.yaic.auth.thirdParty.dto.AuthTokenDto;
import com.yaic.auth.thirdParty.service.AuthTokenDtoService;
import com.yaic.common.PublicParamters;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = Run.class )
@WebAppConfiguration
public class AuthToken {
    private static final Logger logger = LoggerFactory.getLogger ( AuthToken.class );
    @Autowired
    private AuthTokenDtoService authTokenDtoService;

    @Test
    public void insert () {
        AuthTokenDto authTokenDto = new AuthTokenDto ();
        authTokenDto.setAppId ( "1234567111" );
        authTokenDto.setAppSecret ( "1234567111" );
        authTokenDto.setValidFlag ( PublicParamters.VALID_FLAG_Y );
        authTokenDto.setCreatedUser ( "JS" );
        authTokenDto.setUpdatedUser ( "JS" );
        authTokenDtoService.addInfo ( authTokenDto );
        logger.info ( "success" );

    }

    @Test
    public void select () {
        AuthTokenDto authTokenDto = new AuthTokenDto ();
//        authTokenDto.setAppId ( "1234567" );
//        authTokenDto.setAppSecret ( "1234567" );
//        authTokenDto.setValidFlag ( PublicParamters.VALID_FLAG_Y );
//        authTokenDto.setCreatedUser ( "JS" );
//        authTokenDto.setUpdatedUser ( "JS" );
        List list = authTokenDtoService.getListByConditions ( authTokenDto );
        logger.info ( "list:" + list );
    }

    @Test
    public void update () {
        AuthTokenDto authTokenDto = new AuthTokenDto ();
        authTokenDto.setAppId ( "1234567" );
        authTokenDto.setAppSecret ( "1234567222" );
        authTokenDto.setValidFlag ( PublicParamters.VALID_FLAG_Y );
        authTokenDto.setCreatedUser ( "JSJS11" );
        authTokenDto.setUpdatedUser ( "JSJS" );
        int i = authTokenDtoService.updateInfo ( authTokenDto );
        logger.info ( "i:" + i );

    }

}
