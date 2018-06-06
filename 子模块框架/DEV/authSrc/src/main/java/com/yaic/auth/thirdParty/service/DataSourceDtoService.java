package com.yaic.auth.thirdParty.service;

import java.util.List;

import com.yaic.auth.thirdParty.dto.DataSourceDto;

public interface DataSourceDtoService {
    /**
     * 条件查询
     * 
     * @param dto
     * @return
     */
    public List<DataSourceDto> getList ( DataSourceDto dataSourceDto );

    /**
     * 新增记录
     * 
     * @param dto
     * @return
     */
    public int addInfo ( DataSourceDto dataSourceDto );

    /**
     * 修改记录信息
     * 
     * @param dto
     * @return
     */
    public int updateInfo ( DataSourceDto dataSourceDto );

    /**
     * 根据主键编号删除数据
     * 
     * @param accountId
     * @return
     */
    public int deleteInfo ( Integer dataSourceId );

    /**
     * 根据dataSource精确查询对象
     * 
     * @param DataSource
     * @return
     */
    public DataSourceDto getOneByDataSource ( String DataSource );
    

    /**
     * 根据dataSource精确查询对象
     * @param dataSourceDto
     * @return 
     */
    public DataSourceDto getOneByDataSourceId(DataSourceDto dataSourceDto);
}
