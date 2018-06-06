package com.yaic.auth.interior.dao;

import java.util.List;

import com.yaic.auth.interior.dto.AppResourceDto;
import com.yaic.common.TreeNode;

public interface AppResourceDtoMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(AppResourceDto record);

    int insertSelective(AppResourceDto record);

    AppResourceDto getInfoByResourceId(String resourceId);

    int updateByPrimaryKeySelective(AppResourceDto record);

    int updateByPrimaryKey(AppResourceDto record);

    /**
     * 根据userCode精确查询对象
     * @param resourceName
     * @return
     */
	AppResourceDto getInfoByResourceName(String resourceName);

	/**
	 * 查找所有菜单资源
	 * @return
	 */
	List<TreeNode> findAllMenuResource();

    /**
     * 查找所有服务资源
     */
	List<TreeNode> findAllServiceResource();

    /**
     * 查询最大资源ID
     * @return
     */
	List<AppResourceDto> findMaxResourceId();
}