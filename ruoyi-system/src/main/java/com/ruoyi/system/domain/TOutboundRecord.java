package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库出库记录对象 t_outbound_record
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
public class TOutboundRecord extends BaseEntity
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

    /** 出库数量 */
    @Excel(name = "出库数量")
    private Integer outboundNum;

    /** 是否删除 0-否 1-是 */
    @Excel(name = "是否删除 0-否 1-是")
    private String isDelete;

    private String userName;

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
    public void setOutboundNum(Integer outboundNum) 
    {
        this.outboundNum = outboundNum;
    }

    public Integer getOutboundNum() 
    {
        return outboundNum;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("drugId", getDrugId())
            .append("warehouseCode", getWarehouseCode())
            .append("drugName", getDrugName())
            .append("drugAlisa", getDrugAlisa())
            .append("outboundNum", getOutboundNum())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
