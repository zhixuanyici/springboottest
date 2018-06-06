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

import com.yaic.auth.thirdParty.dto.CallbackUrlDto;
import com.yaic.auth.thirdParty.service.CallbackUrlDtoService;

/**
 * 回调功能
 * 
 * @Title CallbackUrlController
 * @Description TODO
 * @author wangjs
 * @date 2018/06/04
 * 
 */
@RestController
@RequestMapping( "callback" )
public class CallbackUrlController {
    private static final Logger logger = LoggerFactory.getLogger ( CallbackUrlController.class );
    @Autowired
    private CallbackUrlDtoService callbackUrlDtoService;

    @PostMapping( "/list" )
    public List<CallbackUrlDto> getList ( CallbackUrlDto callbackUrlDto ) {
        return callbackUrlDtoService.getListByConditions ( callbackUrlDto );
    }

    @PostMapping( "changeInfo" )
    public String saveOrUpdParaType ( CallbackUrlDto callbackUrlDto ) {
        StringBuffer msg = new StringBuffer ();
        if ( "add".equals ( callbackUrlDto.getReqType () ) ) {
            callbackUrlDtoService.addInfo ( callbackUrlDto );
        }
        else {
            msg.append ( "添加失败" );
        }
        if ( "edit".equals ( callbackUrlDto.getReqType () ) ) {
            CallbackUrlDto callbackUrlDtoTemp = callbackUrlDtoService
                    .getOneByCallbackUrlId ( callbackUrlDto.getCallbackUrlId () );
            if ( callbackUrlDtoTemp != null ) {
                callbackUrlDtoService.updateInfo ( callbackUrlDtoTemp );
            }
            else {
                msg.append ( "更新失败" );
            }
        }
        return msg.toString ();
    }

    //根据编号删除
    @GetMapping( value = "/delete/{callbackUrlId}" )
    public String delete ( @PathVariable Integer callbackUrlId ) {
        Integer resu = callbackUrlDtoService.deleteInfo ( callbackUrlId );
        return resu.toString ();
    }

}
