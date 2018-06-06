package com.yaic.auth.thirdParty.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaic.auth.thirdParty.dto.DataSourceDto;
import com.yaic.auth.thirdParty.dto.ProjectDto;
import com.yaic.auth.thirdParty.service.ProjectDtoService;

/**
 * 方案基本功能 未测试controller
 * 
 * @Title ProjectController
 * @Description TODO
 * @author wangjs
 * @date 2018/06/01
 *
 */
@RestController
@RequestMapping( "/project" )
public class ProjectController {
    private static final Logger logger = LoggerFactory.getLogger ( ProjectController.class );
    @Autowired
    private ProjectDtoService projectDtoService;

    @PostMapping( "/list" )
    public List<ProjectDto> getList ( @RequestHeader Map map ) {
        List<ProjectDto> projectList = projectDtoService.getList ( map );
        return projectList;
    }

    @PostMapping( value = "/changeInfo" )
    public String saveOrUpdParaType ( @RequestBody ProjectDto projectDto ) {
        StringBuffer msg = new StringBuffer ();
        msg.append ( projectDto.getReqType () + "    " );
        Integer result = 0;
        //判断操作类型
        if ( "add".equals ( projectDto.getReqType () ) ) {
            //先判断资源名称唯一
            ProjectDto projectDtoTemp = projectDtoService.getOneByProjectName ( projectDto );
            if ( projectDtoTemp != null ) {
                msg.append ( projectDto.getProjectName () + "已存在！" );
            }
            else {
                result = projectDtoService.addInfo ( projectDto );
            }
        }
        else if ( "edit".equals ( projectDto.getReqType () ) ) {

            //判断资源编号是否存在
            ProjectDto projectDtoTemp = projectDtoService.getOneByProjectId ( projectDto.getProjectId () );
            if ( projectDtoTemp != null ) {
                result = projectDtoService.updateInfo ( projectDto );
            }
            else {
                msg.append ( projectDto.getProjectId () + "不存在！" );
            }
        }

        msg.append ( result == 1 ? "操作成功!" : "操作失败!" );
        return msg.toString ();
    }

    //根据编号删除
    @GetMapping( value = "/delete/{projectId}" )
    public String delete ( @PathVariable Integer projectId ) {
        Integer resu = projectDtoService.deleteInfo ( projectId );
        return resu.toString ();
    }

}
