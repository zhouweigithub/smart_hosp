package com.ruoyi.system.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 处方信息对象 t_prescription_records
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
public class TPrescriptionRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增ID */
    private Long id;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String name;

    /** 患者身份证号码 */
    @Excel(name = "患者身份证号码")
    private String idNumber;

    /** 患者年龄 */
    @Excel(name = "患者年龄")
    private Long age;

    /** 患者性别 */
    @Excel(name = "患者性别")
    private String sex;

    /** 患者住址 */
    @Excel(name = "患者住址")
    private String address;

    /** 患者手机号 */
    @Excel(name = "患者手机号")
    private String phone;

    /** 医生诊断结果 */
    @Excel(name = "医生诊断结果")
    private String diagnosis;

    /** 皮试结果 */
    @Excel(name = "皮试结果")
    private String skinTest;

    /** 状态 0医生可见 1药房可见 2护士可见 3已完结 */
    @Excel(name = "状态", readConverterExp = "未=完结、已完结")
    private String status;

    /** 医生ID */
    @Excel(name = "医生ID")
    private Long doctorid;

    /** 药房ID */
    @Excel(name = "药房ID")
    private Long pharmacyid;

    /** 护士ID */
    @Excel(name = "护士ID")
    private Long nurseid;

    /** 注射金额 */
    @Excel(name = "注射金额")
    private float zsAmount;

    /** 药品金额 */
    @Excel(name = "药品金额")
    private float drugAmount;

    /** 总金额 */
    @Excel(name = "总金额")
    private float totalAmount;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date crtime;

    /** 处方的药品信息信息 */
    private List<TPrescriptionDrugInfo> tPrescriptionDrugInfoList;

    public float getZsAmount() {
        return zsAmount;
    }

    public void setZsAmount(float zsAmount) {
        this.zsAmount = zsAmount;
    }

    public float getDrugAmount() {
        return drugAmount;
    }

    public void setDrugAmount(float drugAmount) {
        this.drugAmount = drugAmount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIdNumber(String idNumber) 
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber() 
    {
        return idNumber;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setDiagnosis(String diagnosis) 
    {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() 
    {
        return diagnosis;
    }
    public void setSkinTest(String skinTest) 
    {
        this.skinTest = skinTest;
    }

    public String getSkinTest() 
    {
        return skinTest;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDoctorid(Long doctorid) 
    {
        this.doctorid = doctorid;
    }

    public Long getDoctorid() 
    {
        return doctorid;
    }
    public void setPharmacyid(Long pharmacyid) 
    {
        this.pharmacyid = pharmacyid;
    }

    public Long getPharmacyid() 
    {
        return pharmacyid;
    }
    public void setNurseid(Long nurseid) 
    {
        this.nurseid = nurseid;
    }

    public Long getNurseid() 
    {
        return nurseid;
    }
    public void setCrtime(Date crtime) 
    {
        this.crtime = crtime;
    }

    public Date getCrtime() 
    {
        return crtime;
    }

    public List<TPrescriptionDrugInfo> getTPrescriptionDrugInfoList()
    {
        return tPrescriptionDrugInfoList;
    }

    public void setTPrescriptionDrugInfoList(List<TPrescriptionDrugInfo> tPrescriptionDrugInfoList)
    {
        this.tPrescriptionDrugInfoList = tPrescriptionDrugInfoList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("idNumber", getIdNumber())
            .append("age", getAge())
            .append("sex", getSex())
            .append("address", getAddress())
            .append("phone", getPhone())
            .append("diagnosis", getDiagnosis())
            .append("skinTest", getSkinTest())
            .append("status", getStatus())
            .append("doctorid", getDoctorid())
            .append("pharmacyid", getPharmacyid())
            .append("nurseid", getNurseid())
            .append("crtime", getCrtime())
            .append("zs_amount", getZsAmount())
            .append("drug_amount", getDrugAmount())
            .append("total_amount", getTotalAmount())
            .append("tPrescriptionDrugInfoList", getTPrescriptionDrugInfoList())
            .toString();
    }
}
