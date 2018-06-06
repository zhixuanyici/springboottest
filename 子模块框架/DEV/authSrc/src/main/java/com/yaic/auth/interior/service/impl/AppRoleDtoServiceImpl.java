package com.yaic.auth.interior.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yaic.auth.interior.dao.AppRoleDtoMapper;
import com.yaic.auth.interior.dto.AppResourceDto;
import com.yaic.auth.interior.dto.AppRoleDto;
import com.yaic.auth.interior.service.APPRoleDtoService;
import com.yaic.common.DatatablesView;
import com.yaic.common.TreeNodeNew;

@Service
public class AppRoleDtoServiceImpl implements APPRoleDtoService{
    @Autowired
	AppRoleDtoMapper   appRoleDtoMapper;
	
	/**
	 * 多条件查询获取角色列表
	 */
	@Override
	public DatatablesView<AppRoleDto> getList(String aoData) {
		// TODO Auto-generated method stub
		DatatablesView<AppRoleDto> dataView = new DatatablesView<AppRoleDto>();
		Map<String, Object> paraMap = new HashMap<String, Object>();
		JSONArray ja = JSONArray.parseArray(aoData);
		int pageNumber = 0;
		int iDisplayLength = 0;
		String roleName = null;
		String validFlag = null;
		String 	sEcho = null;
		String roleId = null;		
		  if(ja.size()!=0&& ja!= null ){
		for (int i = 0; i < ja.size(); i++) {
			JSONObject jobj = ja.getJSONObject(i);
			if (jobj.get("name").equals("sEcho"))
				 sEcho = jobj.get("value").toString();

			if (jobj.get("name").equals("pageNumber"))
				pageNumber = jobj.getIntValue("value");

			if (jobj.get("name").equals("iDisplayLength"))
				iDisplayLength = jobj.getIntValue("value");

			if (jobj.get("name").equals("roleName"))
				roleName = jobj.get("value").toString();
			paraMap.put("roleName", roleName);
			
			if (jobj.get("name").equals("roleId"))
				roleId = jobj.get("value").toString();
			paraMap.put("roleId", roleId);
			
			if (jobj.get("name").equals("validFlag"))
				validFlag = jobj.get("value").toString();
			paraMap.put("validFlag", validFlag);
			
		}
		paraMap.put("iDisplayLength", iDisplayLength);
		paraMap.put("iDisplayStart", (pageNumber*iDisplayLength));
		List<AppRoleDto> list = appRoleDtoMapper.getLists(paraMap);
		int count = appRoleDtoMapper.getTotals(paraMap);
		dataView.setsEcho(Integer.parseInt(sEcho==null?"0":sEcho)+1);
		dataView.setData(list);
		dataView.setRecordsFiltered(count);
		dataView.setRecordsTotal(count);
		  }
		  return dataView;
	}

	/**
	 * 根据角色主键ID获取角色
	 */
	@Override
	public AppRoleDto selectByPrimaryKey(String roleId) {
		// TODO Auto-generated method stub
		
		AppRoleDto  roleDto = appRoleDtoMapper.selectByPrimaryKey(roleId);
		
		return roleDto;
	}
    
	/**
	 * 根据角色ID获取角色对应的资源
	 */
	@Override
	public List<AppResourceDto> findResourceByRoleId(Map<String, String> paraMap) {
		// TODO Auto-generated method stub
//		List<AppResourceDto>  resourceList =  appRoleDtoMapper.findResourceByRoleId(paraMap);
//		return resourceList;
		return null;
	}
    
	/**
	 * 获取所有的菜单资源
	 */
	@Override
	public List<TreeNodeNew> findAllMenuResourceNew() {
		// TODO Auto-generated method stub
		return appRoleDtoMapper.findAllMenuResourceNew();
	}

}
