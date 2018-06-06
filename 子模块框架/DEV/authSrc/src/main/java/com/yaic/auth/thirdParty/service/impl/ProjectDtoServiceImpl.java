package com.yaic.auth.thirdParty.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yaic.auth.thirdParty.dao.ProjectDtoMapper;

import com.yaic.auth.thirdParty.dto.ProjectDto;
import com.yaic.auth.thirdParty.service.ProjectDtoService;
import com.yaic.common.PublicParamters;

@Service
public class ProjectDtoServiceImpl implements ProjectDtoService {
    private static final Logger logger = LoggerFactory.getLogger ( ProjectDtoServiceImpl.class );
    @Autowired
    private ProjectDtoMapper projectDtoMapper;

    @Override
    public List<ProjectDto> getList ( Map<String, String> map ) {
        /*
         * 临时测试分页显示
         */
        //设置分页
        PageHelper.offsetPage ( 1, 1 );
        List<ProjectDto> list = projectDtoMapper.selectFuzzyByConditions ( map.get ( "projectCode" ),
                map.get ( "projectName" ), map.get ( "sourceName" ) );
        return list;
    }

    @Override
    public int addInfo ( ProjectDto projectDto ) {

        return projectDtoMapper.insertSelective ( projectDto );
    }

    @Override
    public int updateInfo ( ProjectDto projectDto ) {

        return projectDtoMapper.updateByPrimaryKeySelective ( projectDto );
    }

    @Override
    public int deleteInfo ( Integer projectId ) {
        ProjectDto projectDto = new ProjectDto ();
        projectDto.setValidFlag ( PublicParamters.VALID_FLAG_N );
        projectDto.setProjectId ( projectId );
        return projectDtoMapper.updateByPrimaryKeySelective ( projectDto );
    }

    @Override
    public ProjectDto getOneByProjectId ( Integer projectId ) {
        // TODO Auto-generated method stub
        return projectDtoMapper.selectOneByPrimaryKey ( projectId );
    }

    @Override
    public ProjectDto getOneByProjectName ( ProjectDto projectDto ) {
        // TODO Auto-generated method stub
        return projectDtoMapper.selectOneByProjectName ( projectDto );
    }

}
