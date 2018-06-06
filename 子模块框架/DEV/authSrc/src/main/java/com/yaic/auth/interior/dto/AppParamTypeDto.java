package com.yaic.auth.interior.dto;

import java.util.Date;

public class AppParamTypeDto {

	/** 参数类型ID */
	private String parameterTypeId;
	
	/** 创建日期 */
	private Date createdDate;
	
	/** 创建人 */
	private String createdBy;
	
	/** 更新日期 */
	private Date updatedDate;
	
	/** 更新人 */
	private String updatedBy;
	
	/** 参数类型类型 */
	private String parameterType;
	
	/** 参数类型简体名称 */
	private String parameterTypeCname;
	
	/** 参数类型英文名称 */
	private String parameterTypeEname;
	
	/** 参数类型繁体名称 */
	private String parameterTypeTname;
	
	/** 是否有效：0无效，1 有效 */
	private Integer validFlag;
	
	/** 备注 */
	private String remark;
	
	/** 其他标志 */
	private String flag;

    public String getParameterTypeId() {
        return parameterTypeId;
    }

    public void setParameterTypeId(String parameterTypeId) {
        this.parameterTypeId = parameterTypeId == null ? null : parameterTypeId.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType == null ? null : parameterType.trim();
    }

    public String getParameterTypeCname() {
        return parameterTypeCname;
    }

    public void setParameterTypeCname(String parameterTypeCname) {
        this.parameterTypeCname = parameterTypeCname == null ? null : parameterTypeCname.trim();
    }

    public String getParameterTypeEname() {
        return parameterTypeEname;
    }

    public void setParameterTypeEname(String parameterTypeEname) {
        this.parameterTypeEname = parameterTypeEname == null ? null : parameterTypeEname.trim();
    }

    public String getParameterTypeTname() {
        return parameterTypeTname;
    }

    public void setParameterTypeTname(String parameterTypeTname) {
        this.parameterTypeTname = parameterTypeTname == null ? null : parameterTypeTname.trim();
    }

    public Integer getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}