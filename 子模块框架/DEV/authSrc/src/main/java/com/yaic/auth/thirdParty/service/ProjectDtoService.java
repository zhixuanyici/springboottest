package com.yaic.auth.thirdParty.service;

import java.util.List;
import java.util.Map;

import com.yaic.auth.thirdParty.dto.ProjectDto;

public interface ProjectDtoService {
    /**
     * ������ѯ
     * 
     * @param dto
     * @return
     */
    public List<ProjectDto> getList ( Map<String, String> map );

    /**
     * ������¼
     * 
     * @param dto
     * @return
     */
    public int addInfo ( ProjectDto projectDto );

    /**
     * �޸ļ�¼��Ϣ
     * 
     * @param dto
     * @return
     */
    public int updateInfo ( ProjectDto projectDto );

    /**
     * �����������ɾ������
     * 
     * @param projectId
     * @return
     */
    public int deleteInfo ( Integer projectId );

    /**
     * ����projectId��ȷ��ѯ����
     * 
     * @param appId
     * @return
     */
    public ProjectDto getOneByProjectId ( Integer projectId );

    /**
     * @Description ����ProjectNaem��ȷ��ѯ����
     * @Title getOneByProjectNaem
     * @author WANGJS-PC
     * @param projectName
     * @return ProjectDto
     */
    public ProjectDto getOneByProjectName ( ProjectDto projectDto );
}
