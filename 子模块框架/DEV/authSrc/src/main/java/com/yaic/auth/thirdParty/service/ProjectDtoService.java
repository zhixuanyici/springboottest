package com.yaic.auth.thirdParty.service;

import java.util.List;
import java.util.Map;

import com.yaic.auth.thirdParty.dto.ProjectDto;

public interface ProjectDtoService {
    /**
     * 条件查询
     * 
     * @param dto
     * @return
     */
    public List<ProjectDto> getList ( Map<String, String> map );

    /**
     * 新增记录
     * 
     * @param dto
     * @return
     */
    public int addInfo ( ProjectDto projectDto );

    /**
     * 修改记录信息
     * 
     * @param dto
     * @return
     */
    public int updateInfo ( ProjectDto projectDto );

    /**
     * 根据主键编号删除数据
     * 
     * @param projectId
     * @return
     */
    public int deleteInfo ( Integer projectId );

    /**
     * 根据projectId精确查询对象
     * 
     * @param appId
     * @return
     */
    public ProjectDto getOneByProjectId ( Integer projectId );

    /**
     * @Description 根据ProjectNaem精确查询对象
     * @Title getOneByProjectNaem
     * @author WANGJS-PC
     * @param projectName
     * @return ProjectDto
     */
    public ProjectDto getOneByProjectName ( ProjectDto projectDto );
}
