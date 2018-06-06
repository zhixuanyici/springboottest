package com.yaic.auth.thirdParty.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaic.auth.thirdParty.dto.DataSourceDto;
import com.yaic.auth.thirdParty.dto.ProjectDto;
import com.yaic.auth.thirdParty.service.DataSourceDtoService;

/**
 * 渠道基本功能
 * 
 * @Title DataSourceController
 * @Description TODO
 * @author wangjs
 * @date 2018/06/01
 *
 */

@RestController
@RequestMapping( "/source" )
public class DataSourceController {
    private static final Logger logger = LoggerFactory.getLogger ( DataSourceController.class );

    @Autowired
    private DataSourceDtoService dataSourceDtoService;

    //条件查询
    @PostMapping( value = "/list" )
    public List<DataSourceDto> getList ( @RequestBody DataSourceDto dataSourceDto ) throws Exception {

        List<DataSourceDto> dataList = dataSourceDtoService.getList ( dataSourceDto );
        return dataList;
    }

    //添加或者编辑
    @PostMapping( value = "/changeInfo" )
    public String saveOrUpdParaType ( @RequestBody DataSourceDto dataSourceDto ) throws Exception {
        StringBuffer msg = new StringBuffer ();
        msg.append ( dataSourceDto.getReqType () + "    " );

        Integer result = 0;
        //判断操作类型
        if ( "add".equals ( dataSourceDto.getReqType () ) ) {
            //判断唯一
            DataSourceDto dataSourceDtoTemp = dataSourceDtoService
                    .getOneByDataSource ( dataSourceDto.getDataSource () );
            if ( dataSourceDtoTemp != null ) {
                msg.append ( dataSourceDto.getDataSource () + "已存在！" );
            }
            else {
                result = dataSourceDtoService.addInfo ( dataSourceDto );
            }
        }
        else if ( "edit".equals ( dataSourceDto.getReqType () ) ) {
            //根据id判断是否存在
            DataSourceDto dataSourceDtoTemp = dataSourceDtoService.getOneByDataSourceId ( dataSourceDto );
            if ( dataSourceDtoTemp != null ) {
                result = dataSourceDtoService.updateInfo ( dataSourceDto );
            }
            else {
                msg.append ( dataSourceDto.getDataSourceId () + "不存在！" );
            }

        }
        msg.append ( result == 1 ? "操作成功!" : "操作失败!" );

        return msg.toString ();
    }

    //根据编号删除
    @GetMapping( value = "/delete/{dataSourceId}" )
    public String delete ( @PathVariable Integer dataSourceId ) {
        Integer resu = dataSourceDtoService.deleteInfo ( dataSourceId );
        return resu.toString ();
    }

}
