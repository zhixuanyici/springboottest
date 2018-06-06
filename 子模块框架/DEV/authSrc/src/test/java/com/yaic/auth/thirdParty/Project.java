package com.yaic.auth.thirdParty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.yaic.auth.Run;
import com.yaic.auth.thirdParty.dao.ProjectDtoMapper;
import com.yaic.auth.thirdParty.dto.DataSourceDto;
import com.yaic.auth.thirdParty.dto.ProjectDto;
import com.yaic.auth.thirdParty.service.ProjectDtoService;
import com.yaic.auth.thirdParty.service.impl.ProjectDtoServiceImpl;
import com.yaic.common.PublicParamters;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = Run.class )
@WebAppConfiguration
public class Project {
    private static final Logger logger = LoggerFactory.getLogger ( Project.class );
    @Autowired
    private ProjectDtoMapper projectDtoMapper;
    @Autowired
    private ProjectDtoService projectDtoService;

    @Test
    public void insert () {
        ProjectDto projectDto = new ProjectDto ();
        projectDto.setProjectId ( 123456111 );
        projectDto.setProjectCode ( "ProjectCode1" );
        projectDto.setProjectName ( "projectName1" );
        projectDto.setValidFlag ( 1 );
        projectDto.setIsDefault ( 1 );
        projectDto.setCreatedUser ( "JS" );
        projectDto.setUpdatedUser ( "JS" );
        int i = projectDtoService.addInfo ( projectDto );
        logger.info ( "i:" + i );

    }

    @SuppressWarnings( { "rawtypes" } )
    @Test
    public void select () {

//        Map map = new HashMap ();
//        map.put ( "projectCode", "projectCode1" );
//        map.put ( "projectName", "projectName1" );
//        map.put ( "sourceName", "dataSourceNameTest1" );
        //        List list = projectDtoMapper.getList ("projectCode1","projectName1","dataSourceNameTest1" );
        //        logger.info ( "list:" + list.size () );
        // logger.info ( "list:"+projectDtoMapper.selectFuzzyList ( "projectCode1","projectName1","dataSourceNameTest1" ) );
        //logger.info ( "limit:" + projectDtoService.getList ( map ) );

        //logger.info ( "All:"+projectDtoMapper.selectOneByPrimaryKey ( 2 ) );

        ProjectDto projectDto = new ProjectDto ();
       // projectDto.setProjectName ( "projectName1" );
        logger.info ( "all:" + projectDtoMapper.selectByConditions ( projectDto ) );

    }

    @Test
    public void update () {
        ProjectDto projectDto = new ProjectDto ();
        projectDto.setProjectId ( 2 );
        projectDto.setProjectCode ( "ProjectCode22" );
        projectDto.setProjectName ( "projectName22" );
        projectDto.setValidFlag ( 2 );
        projectDto.setIsDefault ( 2 );
        projectDto.setCreatedUser ( "JS" );
        projectDto.setUpdatedUser ( "JS" );
        projectDtoMapper.updateByPrimaryKeySelective ( projectDto );
    }

    @Test
    public void delete () {
        ProjectDto projectDto = new ProjectDto ();
        projectDto.setDataSourceId ( 2 );
        //将可用标识改为不可用
        projectDto.setValidFlag ( PublicParamters.VALID_FLAG_Y );
        int resu = projectDtoMapper.updateByPrimaryKeySelective ( projectDto );
        logger.info ( "resu:" + resu );

    }

}
