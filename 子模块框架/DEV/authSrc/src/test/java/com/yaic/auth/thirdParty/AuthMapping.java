package com.yaic.auth.thirdParty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yaic.auth.Run;
import com.yaic.auth.thirdParty.dto.AuthMappingDto;
import com.yaic.auth.thirdParty.service.AuthMappingDtoService;
import com.yaic.common.PublicParamters;

@RunWith( SpringJUnit4ClassRunner.class )
@WebAppConfiguration
@SpringBootTest( classes = Run.class )
public class AuthMapping {
    private static final Logger logger = LoggerFactory.getLogger ( AuthMapping.class );
    @Autowired
    private AuthMappingDtoService authMappingDtoService;

    @Test
    public void insert () {
        AuthMappingDto authMappingDto = new AuthMappingDto ();
        authMappingDto.setMappingId ( 123456111 );
        authMappingDto.setProjectId ( 123456111 );
        authMappingDto.setValidFlag ( PublicParamters.VALID_FLAG_Y );
        authMappingDto.setCreatedUser ( "JS" );
        authMappingDto.setUpdatedUser ( "JS" );
        authMappingDtoService.addInfo ( authMappingDto );
        logger.info ( "success" );
    }

    @Test
    public void select () {
        AuthMappingDto authMappingDto = new AuthMappingDto ();
        //        authMappingDto.setMappingId ( 123456111 );
        //        authMappingDto.setProjectId ( 123456111 );
        //        authMappingDto.setValidFlag ( PublicParamters.VALID_FLAG_Y );
        //        authMappingDto.setCreatedUser ( "JS" );
        //        authMappingDto.setUpdatedUser ( "JS" );
        //        authMappingDtoService.getList ( authMappingDto );
        logger.info ( "success：" + authMappingDtoService.getList ( authMappingDto ) );

    }

}
