package com.yaic.auth.interior.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaic.auth.interior.dto.AppResourceDto;
import com.yaic.auth.interior.service.AppResourceDtoService;
import com.yaic.common.TreeNode;

/**
 * 内部资源表功能
 * @author zhaoZD
 * 2018-06-01
 *
 */
@RestController
@RequestMapping("/resource")
public class AppResourceController {

	@Autowired
	AppResourceDtoService appResourceDtoService;
	
	//条件查询
	@PostMapping(value = "/list")
	public Map<String, Object> getResourceList(@RequestBody AppResourceDto dto) throws Exception {
		
	//        List<AppResourceDto> dataList = AppResourceDtoService.getList(dto);
	
		Map<String, Object> result = new HashMap<String, Object>();
		//查询所有资源
//		Map<String , String> paraMap = new HashMap<String, String>();
		List<TreeNode> menuResourceList =  appResourceDtoService.findAllMenuResource();
		List<TreeNode> serviceResourceList =  appResourceDtoService.findAllServiceResource();
		
		//封装树
		List<TreeNode> copyMenuNodes = new ArrayList<TreeNode>();
		List<TreeNode> copyServiceNodes = new ArrayList<TreeNode>();
		copyMenuNodes.addAll(menuResourceList); 
		copyServiceNodes.addAll(serviceResourceList);
		
		//得到菜单树
		for(TreeNode treeNode : menuResourceList){
			for(int i = 0 ;i<copyMenuNodes.size() ;i++ ){
				if(treeNode.getParentId().equals(copyMenuNodes.get(i).getId())){
					copyMenuNodes.get(i).addChild(treeNode);
					copyMenuNodes.remove(treeNode);
				}
			}
		}       
		
		//得到服务树
		for(TreeNode treeNode : serviceResourceList){
			for(int i = 0 ;i<copyServiceNodes.size() ;i++ ){
				if(treeNode.getParentId().equals(copyServiceNodes.get(i).getId())){
					copyServiceNodes.get(i).addChild(treeNode);
					copyServiceNodes.remove(treeNode);
				}
			}
		}
		//auditLogger.info("查询所有资源" );
		//logger.info("查询所有资源");       
		result.put("menuResourceTree", copyMenuNodes);
		result.put("serviceResourceTree", copyServiceNodes);
		return result;
	}
	
	//添加或者编辑
	@PostMapping(value="/changeInfo")
	public String saveOrUpdParaType(@RequestBody AppResourceDto dto) throws Exception {

		StringBuffer msg = new StringBuffer();
		msg.append(dto.getReqType()+"    ");
		Integer result = 0;
		
		//判断操作类型
		if("add".equals(dto.getReqType())){
			//先判断资源名称唯一
			AppResourceDto d = appResourceDtoService.getInfoByResourceName(dto.getResourceName());
			if(d != null){
				msg.append(dto.getResourceName()+"已存在！");
			}else{
				result = appResourceDtoService.addInfo(dto);
			}
		}else if("edit".equals(dto.getReqType())){
			
			//判断资源编号是否存在
			AppResourceDto d = appResourceDtoService.getInfoByResourceId(dto.getResourceId());
			if(d != null){
				result = appResourceDtoService.updateInfo(dto);
			}else{
				msg.append(dto.getResourceId()+"不存在！");
			}
		}
		
		msg.append(result == 1 ? "操作成功!" : "操作失败!");
		return msg.toString();
	}
	
	
	
	
	//根据编号删除
	@GetMapping(value="/delete/{resourceId}")
	public String delete(@PathVariable String resourceId){
		
		Integer result = 0;
		StringBuffer msg = new StringBuffer();
		
		//判断资源编号是否存在
		AppResourceDto d = appResourceDtoService.getInfoByResourceId(resourceId);
		if(d != null){
			result = appResourceDtoService.deleteInfo(resourceId);
		}else{
			msg.append(resourceId + "不存在！");
		}
		
		msg.append(result == 1 ? "操作成功!" : "操作失败!");
		return msg.toString();
	}
	
//	//根据编号查询对象详细信息
//	@GetMapping(value="/show/{userId}")
//	public AppResourceDto show(@PathVariable String userId){
//		
//		return appResourceDtoService.showInfo(userId);
//	}
}
