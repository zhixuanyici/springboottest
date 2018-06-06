package com.yaic.auth.thirdParty.dto;

import java.io.Serializable;
import java.util.Date;

import com.yaic.common.BaseDto;

/** t_callback_url */
public class CallbackUrlDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = -286715540267253833L;
    /**  */
    private Integer callbackUrlId;
    /**  */
    private Integer projectId;
    /**  */
    private String callbackType;
    /**  */
    private String callbackUrl;
    /** */
    private String callbackMethod;
    /** 有效标识,1有效,0无效 */
    private Integer validFlag;
    /** 创建时间,默认插入时间 */
    private Date createdDate;
    /** 创建用户,插入用户 */
    private String createdUser;
    /**  */
    private Date updatedDate;
    /** 更新时间,默认插入更新时间 */
    private String updatedUser;

    public CallbackUrlDto () {
        super ();
    }

    public Integer getCallbackUrlId () {
        return callbackUrlId;
    }

    public void setCallbackUrlId ( Integer callbackUrlId ) {
        this.callbackUrlId = callbackUrlId;
    }

    public Integer getProjectId () {
        return projectId;
    }

    public void setProjectId ( Integer projectId ) {
        this.projectId = projectId;
    }

    public String getCallbackType () {
        return callbackType;
    }

    public void setCallbackType ( String callbackType ) {
        this.callbackType = callbackType;
    }

    public String getCallbackUrl () {
        return callbackUrl;
    }

    public void setCallbackUrl ( String callbackUrl ) {
        this.callbackUrl = callbackUrl;
    }

    public String getCallbackMethod () {
        return callbackMethod;
    }

    public void setCallbackMethod ( String callbackMethod ) {
        this.callbackMethod = callbackMethod;
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
        return "CallbackUrlDto [callbackUrlId=" + callbackUrlId + ", projectId=" + projectId + ", callbackType="
                + callbackType + ", callbackUrl=" + callbackUrl + ", callbackMethod=" + callbackMethod + ", validFlag="
                + validFlag + ", createdDate=" + createdDate + ", createdUser=" + createdUser + ", updatedDate="
                + updatedDate + ", updatedUser=" + updatedUser + "]";
    }

}