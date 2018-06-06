package com.yaic.auth.interior.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yaic.auth.interior.dao.AppUserDtoMapper;
import com.yaic.auth.interior.dao.AppUserExcResDtoMapper;
import com.yaic.auth.interior.dao.AppUserRoleDtoMapper;
import com.yaic.auth.interior.dto.AppUserDto;
import com.yaic.auth.interior.dto.AppUserExcResDto;
import com.yaic.auth.interior.dto.AppUserRoleDto;
import com.yaic.auth.interior.service.AppUserDtoService;
import com.yaic.common.DatatablesView;
import com.yaic.common.PublicParamters;

@Service
public class AppUserDtoServiceImpl implements AppUserDtoService {
	
	@Autowired
	AppUserDtoMapper appUserDtoMapper;
	@Autowired
	AppUserExcResDtoMapper appUserExcResDtoMapper;
	@Autowired
	AppUserRoleDtoMapper appUserRoleDtoMapper;

	/**
	 * 获取用户列表
	 */
	@Override
	public DatatablesView<AppUserDto> getList(String aoData) {
		
		DatatablesView<AppUserDto> dataView = new DatatablesView<AppUserDto>();
		Map<String, Object> paraMap = new HashMap<String, Object>();
		JSONArray ja = JSONArray.parseArray(aoData);
		String sEcho = null;
		int pageNumber = 0;
		int iDisplayLength = 0;
		String userCname = null;
		String userCode = null;
		String userTname = null;
		for (int i = 0; i < ja.size(); i++) {
			JSONObject  jobj = ja.getJSONObject(i);
			if (jobj.get("name").equals("sEcho"))
				sEcho = jobj.get("value").toString();

			if (jobj.get("name").equals("pageNumber"))
				pageNumber = jobj.getIntValue("value");

			if (jobj.get("name").equals("iDisplayLength"))
				iDisplayLength = jobj.getIntValue("value");
			
			if (jobj.get("name").equals("userCode"))
				userCode = jobj.get("value").toString();
			paraMap.put("userCode", userCode);
			if (jobj.get("name").equals("userCname"))
				userCname = jobj.get("value").toString();
			paraMap.put("userCname", userCname);
			if (jobj.get("name").equals("userTname"))
				userTname = jobj.get("value").toString();
			paraMap.put("userTname", userTname);

		}
		paraMap.put("iDisplayLength", iDisplayLength);
		paraMap.put("iDisplayStart", (pageNumber*iDisplayLength));
		List<AppUserDto> list = appUserDtoMapper.getLists(paraMap);
		int count = appUserDtoMapper.getTotal(paraMap);

		dataView.setsEcho(Integer.parseInt(sEcho==null?"0":sEcho)+1);
		dataView.setData(list);
		dataView.setRecordsFiltered(count);
		dataView.setRecordsTotal(count);
		return dataView;
	}

	
	
	@Override
	public Integer addInfo(AppUserDto dto) {
		
		dto.setValidFlag(PublicParamters.VALID_FLAG_Y);
		//临时用户
		dto.setCreatedBy("admin1111");
		dto.setCreatedDate(new Date());
		//临时用户
		dto.setUpdatedBy("admin1111");
		dto.setUpdatedDate(new Date());
		
		int resu = appUserDtoMapper.insert(dto);
		return resu;
	}

	@Override
	public Integer updateInfo(AppUserDto dto) {
		
		dto.setUpdatedDate(new Date());
		//临时用户
		dto.setUpdatedBy("admin1111");
		int resu = appUserDtoMapper.updateByPrimaryKeySelective(dto);
		return resu;
	}

	@Override
	public Integer deleteInfo(List<AppUserDto> userList) {
		int count = 0; 
		for (AppUserDto userDto : userList) {
			appUserDtoMapper.delete(userDto.getUserCode());
			//删除用户排除资源
			appUserExcResDtoMapper.delete(userDto.getUserCode());
			//删除用户角色
			appUserRoleDtoMapper.delete(userDto.getUserCode());
			count++;
		}
		return count;
	}

	@Override
	public AppUserDto getInfoByUserCode(String userCode) {
		return appUserDtoMapper.getInfoByUserCode(userCode);
	}

	@Override
	public AppUserDto selectByPrimaryKey(String userId) {
		return appUserDtoMapper.selectByPrimaryKey(userId);
	}


}
