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
import com.yaic.auth.thirdParty.dao.DataSourceDtoMapper;
import com.yaic.auth.thirdParty.dto.DataSourceDto;
import com.yaic.auth.thirdParty.service.DataSourceDtoService;
import com.yaic.common.PublicParamters;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = Run.class )
@WebAppConfiguration
public class DataSource {
    private static final Logger logger = LoggerFactory.getLogger ( DataSource.class );
    @Autowired
    private DataSourceDtoMapper dataSourceDtoMapper;
    @Autowired
    private DataSourceDtoService dataSourceDtoService;

    @Test
    public void selectAll () {
        DataSourceDto dto = new DataSourceDto ();
        //        dto.setSourceName ( "data" );
        //        dto.setDataSource ( "data" );
//        List<DataSourceDto> list = dataSourceDtoMapper.selectFuzzyByConditions ( dto ) ;
//        for ( DataSourceDto dto1 : list ) {
//            //String str = dto1.getDataSource ();
//            logger.info ( "str:" + dto1 );
//
//        }
        logger.info ( "All", dataSourceDtoService.getList ( dto ) );
    }

    @Test
    public void insert () {
        DataSourceDto dto = new DataSourceDto ();
        dto.setDataSourceId ( 1 );
        dto.setDataSource ( "dataSourceTest1" );
        dto.setSourceName ( "dataSourceNameTest1" );
        dto.setValidFlag ( 1 );
        dto.setCreatedDate ( new Date () );
        dto.setCreatedUser ( "js" );
        dto.setUpdatedDate ( new Date () );
        dto.setUpdatedUser ( "js" );
        logger.info ( "开始" );
        int i = dataSourceDtoMapper.insert ( dto );
        logger.info ( "i:" + i );
    }

    @Test
    public void update () {
        DataSourceDto dto = new DataSourceDto ();
        dto.setDataSourceId ( 2 );
        dto.setUpdatedDate ( new Date () );
        dto.setUpdatedUser ( "js" );
        dto.setSourceName ( "dataSourceNameTest2" );
        int i = dataSourceDtoMapper.updateByPrimaryKeySelective ( dto );
        logger.info ( "i:" + i );

    }

    @Test
    public void delete () {
        DataSourceDto dto = new DataSourceDto ();
        dto.setDataSourceId ( 2 );
        //将可用标识改为不可用
        dto.setValidFlag ( PublicParamters.VALID_FLAG_Y );
        int resu = dataSourceDtoMapper.updateByPrimaryKeySelective ( dto );
        logger.info ( "resu:" + resu );

    }

    @Test
    public void selectByDataSource () {

       // logger.info ( "end:" + dataSourceDtoMapper.selectOneByDataSource ( "dataSourceTest1" ) );
        logger.info ( "end:" + dataSourceDtoMapper.selectOneByPrimaryKey ( 1 ) );
    }

}
