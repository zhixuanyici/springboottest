package com.yaic.auth.thirdParty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaic.auth.thirdParty.dto.AccountDto;
import com.yaic.auth.thirdParty.service.AccountDtoService;

/**
 * 第三方 用户账户表基本功能
 * @author zhaoZD
 * 2018-05-31
 *
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountDtoService accountDtoService;
	
	//条件查询
	@PostMapping(value = "/list")
    public List<AccountDto> getOauthUserList(@RequestBody AccountDto dto) throws Exception {
		
        List<AccountDto> dataList = accountDtoService.getList(dto);
        return dataList;
    }
	
	//添加或者编辑
	@PostMapping(value="/changeInfo")
    public String saveOrUpdParaType(@RequestBody AccountDto dto) throws Exception {
        
		Integer result = 0;
		//判断操作类型
        if("add".equals(dto.getReqType())){
        	//先判断appId唯一
        	AccountDto dto1 = accountDtoService.getInfoByAppid(dto.getAppId());
        	if(dto1 != null && !"".equals(dto1.getAccountId())){
        		result = 0;
        	}else{
        		result = accountDtoService.addInfo(dto);
        	}
        }else if("edit".equals(dto.getReqType())){   
        	result = accountDtoService.updateInfo(dto);
        }
        
        return result == 1 ? "操作成功!" : "操作失败!";
    }
	
	//根据编号删除
	@GetMapping(value="/delete/{accountId}")
	public String delete(@PathVariable Integer accountId){
		
		Integer resu = accountDtoService.deleteInfo(accountId);
		return resu.toString();
	}
}
