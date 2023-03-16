package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 处方的药品信息对象 t_prescription_drug_info
 *
 * @author ruoyi
 * @date 2023-03-16
 */
public class TPrescriptionDrugInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 处方ID */
    private Long prescriptionid;

    /** 药品ID */
    private String drugid;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String drugName;

    /** 药品分类 */
    @Excel(name = "药品分类")
    private String drugType;

    /** 药品规格 */
    @Excel(name = "药品规格")
    private String drugSpecs;

    /** 药品单价 */
    @Excel(name = "药品单价")
    private BigDecimal drugPrice;

    /** 药品数量 */
    @Excel(name = "药品数量")
    private Long counts;

    /** 用药天数 */
    @Excel(name = "用药天数")
    private Long days;

    /** 药品金额 */
    @Excel(name = "药品金额")
    private BigDecimal amount;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setPrescriptionid(Long prescriptionid)
    {
        this.prescriptionid = prescriptionid;
    }

    public Long getPrescriptionid()
    {
        return prescriptionid;
    }
    public void setDrugid(String drugid)
    {
        this.drugid = drugid;
    }

    public String getDrugid()
    {
        return drugid;
    }
    public void setDrugName(String drugName)
    {
        this.drugName = drugName;
    }

    public String getDrugName()
    {
        return drugName;
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
    public void setDrugPrice(BigDecimal drugPrice)
    {
        this.drugPrice = drugPrice;
    }

    public BigDecimal getDrugPrice()
    {
        return drugPrice;
    }
    public void setCounts(Long counts)
    {
        this.counts = counts;
    }

    public Long getCounts()
    {
        return counts;
    }
    public void setDays(Long days)
    {
        this.days = days;
    }

    public Long getDays()
    {
        return days;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("prescriptionid", getPrescriptionid())
                .append("drugid", getDrugid())
                .append("drugName", getDrugName())
                .append("drugType", getDrugType())
                .append("drugSpecs", getDrugSpecs())
                .append("drugPrice", getDrugPrice())
                .append("counts", getCounts())
                .append("days", getDays())
                .append("amount", getAmount())
                .append("remarks", getRemarks())
                .toString();
    }
}
