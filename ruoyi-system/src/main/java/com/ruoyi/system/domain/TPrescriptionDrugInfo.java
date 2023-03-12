package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 处方的药品信息对象 t_prescription_drug_info
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
public class TPrescriptionDrugInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 处方ID */
    private Long prescriptionid;

    /** 药品ID */
    private String drugid;

    /** 药品单价 */
    @Excel(name = "药品单价")
    private Long drugPrice;

    /** 药品数量 */
    @Excel(name = "药品数量")
    private Long counts;

    /** 用药天数 */
    @Excel(name = "用药天数")
    private Long days;

    /** 药品金额 */
    @Excel(name = "药品金额")
    private Long amount;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date crtime;

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
    public void setDrugPrice(Long drugPrice) 
    {
        this.drugPrice = drugPrice;
    }

    public Long getDrugPrice() 
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
    public void setAmount(Long amount) 
    {
        this.amount = amount;
    }

    public Long getAmount() 
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
    public void setCrtime(Date crtime) 
    {
        this.crtime = crtime;
    }

    public Date getCrtime() 
    {
        return crtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("prescriptionid", getPrescriptionid())
            .append("drugid", getDrugid())
            .append("drugPrice", getDrugPrice())
            .append("counts", getCounts())
            .append("days", getDays())
            .append("amount", getAmount())
            .append("remarks", getRemarks())
            .append("crtime", getCrtime())
            .toString();
    }
}
