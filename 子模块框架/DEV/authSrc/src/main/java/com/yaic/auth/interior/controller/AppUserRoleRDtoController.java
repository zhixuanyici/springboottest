package com.yaic.auth.interior.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaic.auth.interior.dto.AppRoleDto;
import com.yaic.auth.interior.service.AppUserRoleDtoService;


/**
 * 角色分配资源
 * @author 宋淑华
 *
 */
@RestController
@RequestMapping("/userRole")
public class AppUserRoleRDtoController {
    
	
	@Autowired
	private AppUserRoleDtoService appuserRoleDtoService;
	
	/**
	 * 用户分配角色页面跳转
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/userRole")
	public String loadUserRole(String userCode, HttpServletRequest request, Model model) {
		model.addAttribute("userCode", userCode);
		List<AppRoleDto> roleList = appuserRoleDtoService.getAllRoles();
		model.addAttribute("roleList", roleList);
		return "sys/user/userRole";
	}

	
	
	
	
	
	
	
	
	
}
