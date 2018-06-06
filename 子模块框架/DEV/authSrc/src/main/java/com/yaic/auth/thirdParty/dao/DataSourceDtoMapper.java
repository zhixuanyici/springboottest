package com.yaic.auth.thirdParty.dao;

import java.util.List;

import com.yaic.auth.thirdParty.dto.DataSourceDto;

public interface DataSourceDtoMapper {
    int deleteByPrimaryKey ( Integer dataSourceId );

    int insert ( DataSourceDto record );

    int insertSelective ( DataSourceDto record );

    DataSourceDto selectOneByPrimaryKey ( Integer dataSourceId );

    int updateByPrimaryKeySelective ( DataSourceDto record );

    int updateByPrimaryKey ( DataSourceDto record );

    List<DataSourceDto> selectByConditions ( DataSourceDto dto );

    List<DataSourceDto> selectFuzzyByConditions ( DataSourceDto dto );

    DataSourceDto selectOneByDataSource ( String dataSource );
}