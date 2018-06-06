package com.yaic.auth.interior.service;

import java.util.List;

import com.yaic.auth.interior.dto.AppUserDto;
import com.yaic.common.DatatablesView;

public interface AppUserDtoService {

	/**
	 * 条件查询获取列表
	 * @param dto
	 * @return
	 */
	/*public List<AppUserDto> getList(AppUserDto dto);*/
	public DatatablesView<AppUserDto> getList(String aoData);
	

	/**
	 * 新增记录
	 * @param dto
	 * @return
	 */
	public Integer addInfo(AppUserDto dto);

	/**
	 * 修改记录信息
	 * @param dto
	 * @return
	 */
	public Integer updateInfo(AppUserDto dto);

	/**
	 * 根据主键编号删除数据
	 * @param userId
	 * @return
	 */
	public Integer deleteInfo(List<AppUserDto> userList);

	/**
	 * 根据userCode精确查询对象
	 * @param userCode
	 * @return
	 */
	public AppUserDto getInfoByUserCode(String userCode);

	/**
	 * 根据userId查询对象信息
	 * @param userId
	 * @return
	 */
	public AppUserDto selectByPrimaryKey(String userId);
	
	
	
	

	
}
