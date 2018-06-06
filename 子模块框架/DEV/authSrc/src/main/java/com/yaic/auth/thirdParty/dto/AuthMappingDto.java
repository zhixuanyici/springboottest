package com.yaic.auth.thirdParty.dto;

import java.io.Serializable;
import java.util.Date;

import com.yaic.common.BaseDto;

/** t_auth_mapping */
public class AuthMappingDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = -2248718237433904709L;
    /** */
    private Integer mappingId;
    /** 方案id */
    private Integer projectId;
    /** 请求类型 */
    private String requestType;
    /** 请求url */
    private String requestUrl;
    /** 服务id */
    private Integer serverId;
    /** 有效标识,1有效,0无效 */
    private Integer validFlag;
    /** 创建时间,默认插入时间 */
    private Date createdDate;
    /** 创建用户,插入用户 */
    private String createdUser;
    /** 更新时间,默认插入更新时间 */
    private Date updatedDate;
    /** 更新用户 */
    private String updatedUser;

    public AuthMappingDto () {
        super ();
    }

    public Integer getMappingId () {
        return mappingId;
    }

    public void setMappingId ( Integer mappingId ) {
        this.mappingId = mappingId;
    }

    public Integer getProjectId () {
        return projectId;
    }

    public void setProjectId ( Integer projectId ) {
        this.projectId = projectId;
    }

    public String getRequestType () {
        return requestType;
    }

    public void setRequestType ( String requestType ) {
        this.requestType = requestType;
    }

    public String getRequestUrl () {
        return requestUrl;
    }

    public void setRequestUrl ( String requestUrl ) {
        this.requestUrl = requestUrl;
    }

    public Integer getServerId () {
        return serverId;
    }

    public void setServerId ( Integer serverId ) {
        this.serverId = serverId;
    }

    public Integer getValidFlag () {
        return validFlag;
    }

    public void setValidFlag ( Integer validFlag ) {
        this.validFlag = validFlag;
    }

    public Date getCreatedDate () {
        return createdDate;
    }

    public void setCreatedDate ( Date createdDate ) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser () {
        return createdUser;
    }

    public void setCreatedUser ( String createdUser ) {
        this.createdUser = createdUser;
    }

    public Date getUpdatedDate () {
        return updatedDate;
    }

    public void setUpdatedDate ( Date updatedDate ) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedUser () {
        return updatedUser;
    }

    public void setUpdatedUser ( String updatedUser ) {
        this.updatedUser = updatedUser;
    }

    @Override
    public String toString () {
        return "AuthMappingDto [mappingId=" + mappingId + ", projectId=" + projectId + ", requestType=" + requestType
                + ", requestUrl=" + requestUrl + ", serverId=" + serverId + ", validFlag=" + validFlag
                + ", createdDate=" + createdDate + ", createdUser=" + createdUser + ", updatedDate=" + updatedDate
                + ", updatedUser=" + updatedUser + "]";
    }

}