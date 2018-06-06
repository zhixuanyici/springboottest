package com.yaic.auth.interior.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yaic.auth.interior.dto.AppUserDto;
import com.yaic.auth.interior.service.AppUserDtoService;
import com.yaic.common.Constants;
import com.yaic.common.DatatablesView;
import com.yaic.common.PasswordHelper;
import com.yaic.common.UuidUtils;

/**
 * 内部用户账号表
 * 2018-06-01
 *
 */
@RestController
@RequestMapping("/user")
public class AppUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(AppUserController.class);

	@Autowired
	private AppUserDtoService appUserDtoService;
	
	/**
	 * 获取用户列表
	 * @param aoData
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/list")
	public DatatablesView<AppUserDto> getAuthUserList(@RequestParam String aoData, HttpServletRequest request,
			Model model) throws Exception {
		DatatablesView<AppUserDto> dataView = new DatatablesView<AppUserDto>();
		dataView  = appUserDtoService.getList(aoData);
		return dataView;
	}
		
	
	
	/**
	 * 时间日期格式转换
	 * @param binder
	 */
	@InitBinder  
    public void initBinder(WebDataBinder binder) {  
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
    dateFormat.setLenient(false);  
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值  
    }
	
	
	/**
	 * 用户预编译
	 * @return
	 */
	@PostMapping(value="/preEdit")
	public ModelAndView  preEdit(@RequestParam(required = false)  String userId,HttpServletRequest request,
			HttpServletResponse response,ModelAndView  view){
		HttpSession session = request.getSession();
		String loginUserId = (String) session
				.getAttribute(Constants.LOGIN_USER_ID_KEY);
		AppUserDto userDto = new AppUserDto();
		if (userId != null && !"undefined".equals(userId)
				&& !"null".equals(userId)) {
			userDto = appUserDtoService.selectByPrimaryKey(userId);
			view.addObject("userDto", userDto);
			view.setViewName("sys/user/updateUser");
			
			return view;
		} else {
			userDto.setCreatedBy(loginUserId);
			userDto.setCreatedDate(new Date());
			userDto.setPasswordSetDate(new Date());
			view.addObject("userDto", userDto);
			view.setViewName("sys/user/addUser");
			Map<String, Object> map = new HashMap<String, Object>();
			userDto.setPassword(null);
			map.put("userDto", userDto);
	         
			return view;
		}
	}
	
	//添加或者编辑
	@PostMapping(value="/changeInfo")
	public Map<String, Object> saveOrUpdParaType(@RequestBody AppUserDto dto ,HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String loginUserId = (String) session
				.getAttribute(Constants.LOGIN_USER_ID_KEY);
		String userId = dto.getUserId();
		AppUserDto user = new AppUserDto();
		user.setUserId(userId);
		user = appUserDtoService.selectByPrimaryKey(userId);
		  if (user == null) {
			  AppUserDto userDtoTmp = new AppUserDto();
			  userDtoTmp = appUserDtoService.getInfoByUserCode(user.getUserCode());
			if(userDtoTmp != null ){
				map.put("flag", "N");
				map.put("msg", "处理失败，该用户已存在");
				return map;
			}
			PasswordHelper passwordHelper = new PasswordHelper();
			passwordHelper.encryptPassword( dto) ;
			String userIds = UuidUtils.getUuid(); 
			dto.setUserId(userIds);
			dto.setUpdatedBy(loginUserId);
			dto.setUpdatedDate(new Date());
			appUserDtoService.addInfo(dto);
			//logger.info("用户 " + "[" + loginUserId + "] 添加 用户 [" + userId +  "]");    
			map.put("flag", "Y");
			map.put("msg", "用户添加成功");
			return map;
		   } else {
		    if(dto.getPassword() != null && !"".equals(dto.getPassword())) {
		        PasswordHelper passwordHelper = new PasswordHelper();
	            passwordHelper.encryptPassword( dto) ;
		    }
		    dto.setUpdatedBy(loginUserId);
		    dto.setUpdatedDate(new Date());
			appUserDtoService.updateInfo(dto);
			//logger.info("用户 " + "[" + loginUserId + "] 修改 用户 [" + userDto.getUserId() +  "]");    
			map.put("flag", "Y");
			map.put("msg", "用户修改成功");
			return map;
	     }  
	}
	
	//根据编号删除
	@GetMapping(value="/delete/{userCode}")
	public Map<String, Object> delete(@PathVariable String userCode,HttpServletRequest request){
		HttpSession session = request.getSession();
		String loginUserId = (String) session
		.getAttribute(Constants.LOGIN_USER_ID_KEY);
		Map<String, Object> map = new HashMap<String, Object>();
		int deleteCount = 0;
		 String[]  userCodes=  userCode.split(",");
		   List<String> userIdList = Arrays.asList(userCodes);
		   List<AppUserDto>  userList  = new ArrayList<AppUserDto>();
			for (String codes : userIdList) {
				AppUserDto user = new AppUserDto();
				user.setUserCode(codes);
				userList.add(user);
			}
			
 		if (userList != null) {
			deleteCount = appUserDtoService.deleteInfo(userList);
		} 
		//shiroCacheService.clearAllCache();
		logger.info("用户 " + "[" + loginUserId + "] 删除 用户数：" +  deleteCount );    
		map.put("deleteCount", deleteCount);
		map.put("msg", "删除成功");
		map.put("flag", "Y");
		return map;
		/*
		Integer resu = appUserDtoService.deleteInfo(userId);
		return resu.toString();*/
	}
	
	//根据编号查询对象详细信息
	@GetMapping(value="/show/{userId}")
	public AppUserDto show(@PathVariable String userId){
		
		return appUserDtoService.selectByPrimaryKey(userId);
	}
}
