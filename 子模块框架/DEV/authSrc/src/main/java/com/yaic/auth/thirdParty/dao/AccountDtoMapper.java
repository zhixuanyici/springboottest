package com.yaic.auth.thirdParty.dao;

import java.util.List;

import com.yaic.auth.thirdParty.dto.AccountDto;

public interface AccountDtoMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(AccountDto record);

    int insertSelective(AccountDto record);

    AccountDto selectByPrimaryKey(Integer accountId);
    
    List<AccountDto> getLists(AccountDto dto);

    int updateByPrimaryKeySelective(AccountDto record);

    int updateByPrimaryKey(AccountDto record);

	AccountDto getInfoByAppid(String appId);
}