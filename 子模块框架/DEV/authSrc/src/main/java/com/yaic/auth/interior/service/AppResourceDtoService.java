package com.yaic.auth.interior.service;

import java.util.List;

import com.yaic.auth.interior.dto.AppResourceDto;
import com.yaic.common.TreeNode;

public interface AppResourceDtoService {
	
	
	
    /**
     * 查找所有菜单资源
     */
    public List<TreeNode> findAllMenuResource();
    
    /**
     * 查找所有服务资源
     */
    public List<TreeNode> findAllServiceResource();
    
    /**
     * 查询最大资源ID
     * @return
     */
    public List<AppResourceDto> findMaxResourceId();

//	/**
//	 * 条件查询
//	 * @param dto
//	 * @return
//	 */
//	public List<AppUserDto> getList(AppUserDto dto);

	/**
	 * 新增记录
	 * @param dto
	 * @return
	 */
	public Integer addInfo(AppResourceDto dto);

	/**
	 * 修改记录信息
	 * @param dto
	 * @return
	 */
	public Integer updateInfo(AppResourceDto dto);

	/**
	 * 根据主键编号删除数据
	 * @param userId
	 * @return
	 */
	public Integer deleteInfo(String resourceId);

	/**
	 * 根据userCode精确查询对象
	 * @param userCode
	 * @return
	 */
	public AppResourceDto getInfoByResourceName(String resourceName);
	
	
	/**
	 * 根据resourceId查询对象信息
	 * @param userId
	 * @return
	 */
	public AppResourceDto getInfoByResourceId(String resourceId);

}
