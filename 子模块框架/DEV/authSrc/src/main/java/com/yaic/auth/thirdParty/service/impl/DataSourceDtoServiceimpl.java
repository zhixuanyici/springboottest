package com.yaic.auth.thirdParty.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yaic.auth.thirdParty.dao.DataSourceDtoMapper;
import com.yaic.auth.thirdParty.dto.AccountDto;
import com.yaic.auth.thirdParty.dto.DataSourceDto;
import com.yaic.auth.thirdParty.service.DataSourceDtoService;
import com.yaic.common.PublicParamters;

@Service
public class DataSourceDtoServiceimpl implements DataSourceDtoService {
    private static final Logger logger = LoggerFactory.getLogger ( DataSourceDtoServiceimpl.class );
    @Autowired
    private DataSourceDtoMapper dataSourceDtoMapper;

    @Override
    public List<DataSourceDto> getList ( DataSourceDto dto ) {
        PageHelper.offsetPage (dto.getPageNum (),dto.getPageSize ());
        List<DataSourceDto> list = dataSourceDtoMapper.selectFuzzyByConditions ( dto );

        return list;
    }

    @Override
    public int addInfo ( DataSourceDto dto ) {
        if ( dto.getDataSourceId () == null || dto.getSourceName () == null || dto.getDataSource () == null ) {
            return 0;
        }
        int resu = dataSourceDtoMapper.insertSelective ( dto );
        return resu;
    }

    @Override
    public int updateInfo ( DataSourceDto dto ) {
        if ( dto.getDataSourceId () == null || dto.getSourceName () == null || dto.getDataSource () == null ) {
            return 0;
        }
        int resu = dataSourceDtoMapper.updateByPrimaryKeySelective ( dto );
        return resu;

    }

    @Override
    public int deleteInfo ( Integer dataSourceId ) {
        DataSourceDto dataSourceDto = new DataSourceDto ();
        dataSourceDto.setValidFlag ( PublicParamters.VALID_FLAG_N );
        dataSourceDto.setDataSourceId ( dataSourceId );
        return dataSourceDtoMapper.updateByPrimaryKeySelective ( dataSourceDto );
    }

    @Override
    public DataSourceDto getOneByDataSource ( String dataSource ) {

        return dataSourceDtoMapper.selectOneByDataSource ( dataSource );
    }

    @Override
    public DataSourceDto getOneByDataSourceId ( DataSourceDto dataSourceDto ) {

        return dataSourceDtoMapper.selectOneByPrimaryKey ( dataSourceDto.getDataSourceId () );
    }

}
