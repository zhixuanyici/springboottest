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
import com.yaic.auth.thirdParty.dto.ServerDto;
import com.yaic.auth.thirdParty.service.ServerDtoService;
import com.yaic.auth.thirdParty.service.impl.ProjectDtoServiceImpl;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = Run.class )
@WebAppConfiguration
public class Server {
    private static final Logger logger = LoggerFactory.getLogger ( ProjectDtoServiceImpl.class );
    @Autowired
    private ServerDtoService serverDtoService;

    @Test
    public void insert () {
        ServerDto serverDto = new ServerDto ();
        serverDto.setServerId ( 2 );
        serverDto.setServerType ( "Type2" );
        serverDto.setServerVersion ( "Version2" );
        serverDto.setServerEnv ( "Env2" );
        serverDto.setServerStatus ( "2" );
        serverDto.setServerUrl ( "Url2" );

        int i = serverDtoService.addInfo ( serverDto );
        logger.info ( "i:" + i );
    }

    @Test
    public void select () {
        ServerDto serverDto = new ServerDto ();
        //serverDto.setServerId ( 2 );
        //serverDto.setServerType ( "Type2" );
        //  serverDto.setServerVersion ( "Version" );
        //serverDto.setServerEnv ( "Env2" );
        //serverDto.setServerStatus ( "2" );
        // serverDto.setServerUrl ( "Url" );
        List<ServerDto> list = serverDtoService.getList ( serverDto );
        logger.info ( "list:" + list );

    }

    @Test
    public void update () {
        ServerDto serverDto = new ServerDto ();
        serverDto.setServerId ( 2 );
        serverDto.setServerType ( "T22" );
        serverDto.setServerVersion ( "Version" );
        serverDto.setServerEnv ( "Env2" );
        serverDto.setServerStatus ( "22" );
        serverDto.setServerUrl ( "Url2" );
        int i = serverDtoService.updateInfo ( serverDto );
        logger.info ( "i:" + i );
    }

}
