package com.yaic.auth.thirdParty.service;

import java.util.List;

import com.yaic.auth.thirdParty.dto.AccountDto;

public interface AccountDtoService {

	/**
	 * 条件查询
	 * @param dto
	 * @return
	 */
	public List<AccountDto> getList(AccountDto dto);

	/**
	 * 新增记录
	 * @param dto
	 * @return
	 */
	public int addInfo(AccountDto dto);

	/**
	 * 修改记录信息
	 * @param dto
	 * @return
	 */
	public int updateInfo(AccountDto dto);

	/**
	 * 根据主键编号删除数据
	 * @param accountId
	 * @return
	 */
	public int deleteInfo(Integer accountId);

	/**
	 * 根据appId精确查询对象
	 * @param appId
	 * @return
	 */
	public AccountDto getInfoByAppid(String appId);
}
