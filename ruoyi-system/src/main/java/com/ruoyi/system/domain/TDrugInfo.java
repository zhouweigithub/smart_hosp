package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 药品信息对象 t_drug_info
 * 
 * @author ruoyi
 * @date 2023-02-12
 */
public class TDrugInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String drugName;

    /** 药品别名 */
    @Excel(name = "药品别名")
    private String drugAlias;

    /** 药品编号 */
    @Excel(name = "药品编号")
    private String drugCode;

    /** 药品分类 */
    @Excel(name = "药品分类")
    private String drugType;

    /** 药品类别 */
    private String drugCategory;
    /** 药品规格 */
    @Excel(name = "药品规格")
    private String drugSpecs;

    /** 单价（分） */
    @Excel(name = "单价", readConverterExp = "分=")
    private BigDecimal unitPrice;

    /** 零售价（分） */
    @Excel(name = "零售价", readConverterExp = "分=")
    private BigDecimal retailPrice;

    /** 库存 */
    @Excel(name = "库存")
    private Long stock;

    /** 药品单位 */
    @Excel(name = "药品单位")
    private String drugCompany;

    /** 厂家 */
    @Excel(name = "厂家")
    private String manufactor;

    /** 排序 */
    @Excel(name = "排序")
    private String sort;
    /** 删除标识 */
    private String isDelete;

    private String userName;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDrugName(String drugName) 
    {
        this.drugName = drugName;
    }

    public String getDrugName() 
    {
        return drugName;
    }
    public void setDrugAlias(String drugAlias) 
    {
        this.drugAlias = drugAlias;
    }

    public String getDrugAlias() 
    {
        return drugAlias;
    }
    public void setDrugCode(String drugCode) 
    {
        this.drugCode = drugCode;
    }

    public String getDrugCode() 
    {
        return drugCode;
    }
    public void setDrugType(String drugType) 
    {
        this.drugType = drugType;
    }

    public String getDrugType() 
    {
        return drugType;
    }
    public void setDrugSpecs(String drugSpecs) 
    {
        this.drugSpecs = drugSpecs;
    }

    public String getDrugSpecs() 
    {
        return drugSpecs;
    }
    public void setUnitPrice(BigDecimal unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice()
    {
        return unitPrice;
    }
    public void setRetailPrice(BigDecimal retailPrice)
    {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getRetailPrice()
    {
        return retailPrice;
    }
    public void setStock(Long stock) 
    {
        this.stock = stock;
    }

    public Long getStock() 
    {
        return stock;
    }
    public void setDrugCompany(String drugCompany) 
    {
        this.drugCompany = drugCompany;
    }

    public String getDrugCompany() 
    {
        return drugCompany;
    }
    public void setManufactor(String manufactor) 
    {
        this.manufactor = manufactor;
    }

    public String getManufactor() 
    {
        return manufactor;
    }

    public String getDrugCategory() {
        return drugCategory;
    }

    public void setDrugCategory(String drugCategory) {
        this.drugCategory = drugCategory;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
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
            .append("drugName", getDrugName())
            .append("drugAlias", getDrugAlias())
            .append("drugCode", getDrugCode())
            .append("drugType", getDrugType())
            .append("drugSpecs", getDrugSpecs())
            .append("unitPrice", getUnitPrice())
            .append("retailPrice", getRetailPrice())
            .append("stock", getStock())
            .append("drugCompany", getDrugCompany())
            .append("manufactor", getManufactor())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("sort", getSort())
            .toString();
    }
}
