package com.yaic.auth.interior.dao;

import java.util.List;
import java.util.Map;

import com.yaic.auth.interior.dto.AppUserDto;

public interface AppUserDtoMapper {
	
    int deleteByPrimaryKey(String userId);

    int insert(AppUserDto record);

    int insertSelective(AppUserDto record);

    AppUserDto selectByPrimaryKey(String userId);

    AppUserDto getInfoByUserCode(String userCode);

    List<AppUserDto> getLists(Map<String, Object> paraMap);
    
    int updateByPrimaryKeySelective(AppUserDto record);

    int updateByPrimaryKey(AppUserDto record);

	int getTotal(Map<String, Object> paraMap);
     
	void delete(String userCode);

}