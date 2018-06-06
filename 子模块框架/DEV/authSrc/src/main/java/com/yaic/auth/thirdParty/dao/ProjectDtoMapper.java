package com.yaic.auth.thirdParty.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yaic.auth.thirdParty.dto.ProjectDto;

public interface ProjectDtoMapper {
    int deleteByPrimaryKey ( Integer projectId );

    int insert ( ProjectDto projectDto );

    int insertSelective ( ProjectDto projectDto );

    ProjectDto selectOneByPrimaryKey ( Integer projectId );

    ProjectDto selectOneByProjectName ( ProjectDto projectDto );

    int updateByPrimaryKeySelective ( ProjectDto projectDto );

    int updateByPrimaryKey ( ProjectDto projectDto );

    //模糊查询（查询条件：project_code，project_name，source_name）
    List<ProjectDto> selectFuzzyByConditions ( @Param("projectCode")String projectCode,
                               @Param("projectName")String projectName,
                               @Param("sourceName")String sourceName );
    
    List<ProjectDto> selectByConditions(ProjectDto projectDto);
    
    
   
}