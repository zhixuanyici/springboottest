package com.yaic.auth.thirdParty.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaic.auth.thirdParty.dto.ProjectDto;
import com.yaic.auth.thirdParty.dto.ServerDto;
import com.yaic.auth.thirdParty.service.ServerDtoService;

/**
 * 服务功能
 * 
 * @Title ServerController
 * @Description TODO
 * @author wangjs
 * @date 2018/06/04
 * 
 */
@RestController
@RequestMapping( "/server" )
public class ServerController {
    private static final Logger logger = LoggerFactory.getLogger ( ServerController.class );
    @Autowired
    private ServerDtoService serverService;

    @PostMapping( "/list" )
    public List<ServerDto> getList ( ServerDto serverDto ) {
        return serverService.getList ( serverDto );
    }

    @PostMapping( "/changeInfo" )
    public String saveOrUpdParaType ( ServerDto serverDto ) {
        StringBuffer msg = new StringBuffer ();
        msg.append ( serverDto.getReqType () + "    " );
        Integer result = 0;
        //判断操作类型
        if ( "add".equals ( serverDto.getReqType () ) ) {
            //先判断资源唯一
            List<ServerDto> ServerDtoTemp = serverService.getList ( serverDto );
            if ( ServerDtoTemp.size () > 0 ) {
                msg.append ( "此服务已存在！" );
            }
            else {
                result = serverService.addInfo ( serverDto );
            }
        }
        else if ( "edit".equals ( serverDto.getReqType () ) ) {
            //判断资源编号是否存在
            ServerDto serverDtoTemp = serverService.getOneByServerId ( serverDto.getServerId () );
            if ( serverDtoTemp != null ) {
                result = serverService.updateInfo ( serverDto );
            }
            else {
                msg.append ( "此服务不存在！" );
            }
        }

        msg.append ( result == 1 ? "操作成功!" : "操作失败!" );
        return msg.toString ();
    }

    //根据编号删除
    @GetMapping( value = "/delete/{serverId}" )
    public String delete ( @PathVariable Integer serverId ) {
        Integer resu = serverService.deleteInfo ( serverId );
        return resu.toString ();
    }

}
