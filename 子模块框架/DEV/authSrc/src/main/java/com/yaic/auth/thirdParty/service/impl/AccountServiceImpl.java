package com.yaic.auth.thirdParty.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yaic.auth.thirdParty.dao.AccountDtoMapper;
import com.yaic.auth.thirdParty.dto.AccountDto;
import com.yaic.auth.thirdParty.service.AccountDtoService;
import com.yaic.common.PublicParamters;

@Service
public class AccountServiceImpl implements AccountDtoService {
	
	@Autowired
	AccountDtoMapper accountDtoMapper;

	@Override
	public List<AccountDto> getList(AccountDto dto) {
		
		//使用分页插件,核心代码就这一行
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        // 获取
        List<AccountDto> lists = accountDtoMapper.getLists(dto);
        
		return lists;
	}

	@Override
	public int addInfo(AccountDto dto) {
		
		dto.setCreatedDate(new Date());
		//临时用户
		dto.setCreatedUser("admin1111");
		dto.setUpdatedDate(new Date());
		//临时用户
		dto.setUpdatedUser("admin1111");
		dto.setValidFlag(PublicParamters.VALID_FLAG_Y);
		
		int resu = accountDtoMapper.insert(dto);
		return resu;
	}

	@Override
	public int updateInfo(AccountDto dto) {
		
		dto.setUpdatedDate(new Date());
		//临时用户
		dto.setUpdatedUser("admin1111");
		int resu = accountDtoMapper.updateByPrimaryKeySelective(dto);
		return resu;
	}

	@Override
	public int deleteInfo(Integer accountId) {
		
		AccountDto dto = new AccountDto();
		dto.setAccountId(accountId);
		//将可用标识改为不可用
		dto.setValidFlag(PublicParamters.VALID_FLAG_N);
		int resu = accountDtoMapper.updateByPrimaryKeySelective(dto);
		return resu;
	}

	@Override
	public AccountDto getInfoByAppid(String appId) {
		return accountDtoMapper.getInfoByAppid(appId);
	}

}
