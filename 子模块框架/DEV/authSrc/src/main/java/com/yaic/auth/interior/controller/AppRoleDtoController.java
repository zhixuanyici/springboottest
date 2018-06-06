package com.yaic.auth.interior.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.yaic.auth.interior.dto.AppResourceDto;
import com.yaic.auth.interior.dto.AppRoleDto;
import com.yaic.auth.interior.service.APPRoleDtoService;
import com.yaic.common.DatatablesView;
import com.yaic.common.TreeNodeNew;

/**
 * 内部角色controller
 * @author 宋淑华
 *
 */

@RestController
@RequestMapping("/role")

public class AppRoleDtoController {
	@Autowired
	 private  APPRoleDtoService  aPPRoleDtoService;
	
	/**
	 * 获取角色列表
	 * @param aoData
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/list")
	public DatatablesView<AppRoleDto> getAuthRoleList(@RequestParam String aoData, HttpServletRequest request,
			Model model) throws Exception {
		DatatablesView<AppRoleDto> dataView = new DatatablesView<AppRoleDto>();
		dataView  = aPPRoleDtoService.getList(aoData);
		return dataView;
	} 
	
	  /**
     *  获取角色资源树
     * 
     */
	@PostMapping(value = "/getResource/{roleId}")
    public String  getResource(@PathVariable String roleId,Model model,HttpServletRequest request) throws Exception {
		AppRoleDto roleDto  = new  AppRoleDto();
	     if(!StringUtils.isEmpty(roleId)&& roleId!=null){
	    	 roleDto = aPPRoleDtoService.selectByPrimaryKey(roleId);
	     }
    	 model.addAttribute("roleDto", roleDto);
        return "sys/role/roleResourceManage";
    }
	
	/**
     * 根据角色ID获取角色资源
     * @return
     * @throws Exception
     */
	@PostMapping(value = "/findResourceById/{roleId}")
    public Map<String , Object> toGetRoleResource(@PathVariable String roleId,Model model,HttpServletRequest request) throws Exception {
    	  Map<String , String> paraMap = new HashMap<String, String>();
    	  Map<String , Object> resultMap = new HashMap<String, Object>();
          //查询条件
    	  if(!StringUtils.isEmpty(roleId)&& roleId!=null){
    		  paraMap.put("roleId", roleId);
    	  }
    	  //根据角色ID获取角色资源
    	List<AppResourceDto> resources = this.aPPRoleDtoService.findResourceByRoleId(paraMap);
    	//获取所有的资源
    	List<TreeNodeNew> menuResourceList = aPPRoleDtoService.findAllMenuResourceNew();
    	resultMap.put("roleId",roleId);
    	resultMap.put("resources", resources);
    	resultMap.put("menuResourceList", menuResourceList);
        return resultMap;
    }
	
	
	
	
}
