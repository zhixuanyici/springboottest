package com.yaic.auth.interior.service;

import java.util.List;
import java.util.Map;

import com.yaic.auth.interior.dto.AppResourceDto;
import com.yaic.auth.interior.dto.AppRoleDto;
import com.yaic.common.DatatablesView;
import com.yaic.common.TreeNodeNew;

public interface APPRoleDtoService {

	DatatablesView<AppRoleDto> getList(String aoData);

	AppRoleDto selectByPrimaryKey(String roleId);

	List<AppResourceDto> findResourceByRoleId(Map<String, String> paraMap);

	List<TreeNodeNew> findAllMenuResourceNew();

}
