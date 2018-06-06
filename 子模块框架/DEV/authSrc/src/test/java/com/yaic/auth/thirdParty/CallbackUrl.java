package com.yaic.auth.thirdParty;

import java.util.Date;
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
import com.yaic.auth.thirdParty.dto.CallbackUrlDto;
import com.yaic.auth.thirdParty.service.CallbackUrlDtoService;
import com.yaic.common.PublicParamters;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = Run.class )
@WebAppConfiguration
public class CallbackUrl {
    private static final Logger logger = LoggerFactory.getLogger ( DataSource.class );
    @Autowired
    private CallbackUrlDtoService callbackUrlDtoService;

    @Test
    public void insert () {
        CallbackUrlDto callbackUrlDto = new CallbackUrlDto ();
        for ( int i = 1 ; i < 10 ; i++ ) {
            callbackUrlDto.setCallbackUrlId ( i );
            callbackUrlDto.setProjectId ( 1 );
            callbackUrlDto.setValidFlag ( PublicParamters.VALID_FLAG_Y );
            callbackUrlDto.setCreatedUser ( "JS" );
            callbackUrlDto.setCreatedDate ( new Date () );
            callbackUrlDto.setUpdatedUser ( "JS" );
            callbackUrlDto.setUpdatedDate ( new Date () );
            callbackUrlDtoService.addInfo ( callbackUrlDto );
        }

        logger.info ( "success" );
    }

    @Test
    public void select () {
        CallbackUrlDto callbackUrlDto = new CallbackUrlDto ();
//        callbackUrlDto.setCallbackUrlId ( 1 );
//        callbackUrlDto.setProjectId ( 1 );
//        callbackUrlDto.setValidFlag ( PublicParamters.VALID_FLAG_Y );
//        callbackUrlDto.setCreatedUser ( "JS" );
//        callbackUrlDto.setUpdatedUser ( "JS" );
        List<CallbackUrlDto> list = callbackUrlDtoService.getListByConditions ( callbackUrlDto );
        logger.info ( "list" + list );
    }

    @Test
    public void update () {
        CallbackUrlDto callbackUrlDto = new CallbackUrlDto ();
        callbackUrlDto.setCallbackUrlId ( 1 );
        callbackUrlDto.setProjectId ( 1 );
        callbackUrlDto.setValidFlag ( PublicParamters.VALID_FLAG_Y );
        callbackUrlDto.setCreatedUser ( "JSJS" );
        callbackUrlDto.setUpdatedUser ( "JSJS" );
        callbackUrlDtoService.updateInfo ( callbackUrlDto );
        logger.info ( "success" );
    }

    @Test
    public void delete () {
        CallbackUrlDto callbackUrlDto = new CallbackUrlDto ();
        callbackUrlDto.setCallbackUrlId ( 5 );
        callbackUrlDtoService.deleteInfo ( callbackUrlDto.getCallbackUrlId () );
        logger.info ( "success" );

    }

}
