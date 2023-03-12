package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库入库记录对象 t_warehouse_manager
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
public class TWarehouseManager extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 药品种类Id */
    @Excel(name = "药品种类Id")
    private String drugId;

    /** 入库编号 */
    @Excel(name = "入库编号")
    private String warehouseCode;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String drugName;

    /** 药品别名 */
    @Excel(name = "药品别名")
    private String drugAlisa;

    /** 过期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "过期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expirationTime;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Integer insertNum;

    /** 剩余数量 */
    @Excel(name = "剩余数量")
    private Integer residueNum;

    /** 是否过期 0-否 1-是 */
    private String expireStatus;

    /** 是否删除 0-否 1-是 */
    @Excel(name = "是否删除 0-否 1-是")
    private String isDelete;

    private String userName;

    private String beginTime;

    private String endTime;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDrugId(String drugId) 
    {
        this.drugId = drugId;
    }

    public String getDrugId() 
    {
        return drugId;
    }
    public void setWarehouseCode(String warehouseCode) 
    {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseCode() 
    {
        return warehouseCode;
    }
    public void setDrugName(String drugName) 
    {
        this.drugName = drugName;
    }

    public String getDrugName() 
    {
        return drugName;
    }
    public void setDrugAlisa(String drugAlisa) 
    {
        this.drugAlisa = drugAlisa;
    }

    public String getDrugAlisa() 
    {
        return drugAlisa;
    }
    public void setExpirationTime(Date expirationTime) 
    {
        this.expirationTime = expirationTime;
    }

    public Date getExpirationTime() 
    {
        return expirationTime;
    }
    public void setInsertNum(Integer insertNum) 
    {
        this.insertNum = insertNum;
    }

    public Integer getInsertNum() 
    {
        return insertNum;
    }
    public void setResidueNum(Integer residueNum) 
    {
        this.residueNum = residueNum;
    }

    public Integer getResidueNum() 
    {
        return residueNum;
    }
    public void setIsDelete(String isDelete) 
    {
        this.isDelete = isDelete;
    }

    public String getIsDelete() 
    {
        return isDelete;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime + " 23:59:59";
    }

    public String getExpireStatus() {
        return expireStatus;
    }

    public void setExpireStatus(String expireStatus) {
        this.expireStatus = expireStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("drugId", getDrugId())
            .append("warehouseCode", getWarehouseCode())
            .append("drugName", getDrugName())
            .append("drugAlisa", getDrugAlisa())
            .append("expirationTime", getExpirationTime())
            .append("insertNum", getInsertNum())
            .append("residueNum", getResidueNum())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
