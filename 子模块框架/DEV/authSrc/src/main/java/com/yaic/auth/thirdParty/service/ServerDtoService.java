package com.yaic.auth.thirdParty.service;

import java.util.List;

import com.yaic.auth.thirdParty.dto.ServerDto;

public interface ServerDtoService {
    /**
     *
     * 
     * @param dto
     * @return
     */
    public List<ServerDto> getList ( ServerDto serverDto );

    /**
     * 新增记录
     * 
     * @param dto
     * @return
     */
    public int addInfo ( ServerDto serverDto );

    /**
     * 修改记录信息
     * 
     * @param dto
     * @return
     */
    public int updateInfo ( ServerDto serverDto );

    /**
     * 根据主键编号删除数据
     * 
     * @param projectId
     * @return
     */
    public int deleteInfo ( Integer serverId);

    /**
     * 根据projectId精确查询对象
     * 
     * @param appId
     * @return
     */
    public ServerDto getOneByServerId ( Integer serverId );

    /**
     * @Description 根据ProjectNaem精确查询对象
     * @Title getOneByProjectNaem
     * @author WANGJS-PC
     * @param projectName
     * @return ServerDto
     */
    public List<ServerDto> getOneByProjectName ( ServerDto serverDto );

}
