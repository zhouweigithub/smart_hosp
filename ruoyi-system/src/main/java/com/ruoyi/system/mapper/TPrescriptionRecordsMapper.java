package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TPrescriptionRecords;
import com.ruoyi.system.domain.TPrescriptionDrugInfo;

/**
 * 处方信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
public interface TPrescriptionRecordsMapper 
{
    /**
     * 查询处方信息
     * 
     * @param id 处方信息主键
     * @return 处方信息
     */
    public TPrescriptionRecords selectTPrescriptionRecordsById(Long id);

    /**
     * 查询处方信息列表
     * 
     * @param tPrescriptionRecords 处方信息
     * @return 处方信息集合
     */
    public List<TPrescriptionRecords> selectTPrescriptionRecordsList(TPrescriptionRecords tPrescriptionRecords);

    /**
     * 新增处方信息
     * 
     * @param tPrescriptionRecords 处方信息
     * @return 结果
     */
    public int insertTPrescriptionRecords(TPrescriptionRecords tPrescriptionRecords);

    /**
     * 修改处方信息
     * 
     * @param tPrescriptionRecords 处方信息
     * @return 结果
     */
    public int updateTPrescriptionRecords(TPrescriptionRecords tPrescriptionRecords);

    /**
     * 删除处方信息
     * 
     * @param id 处方信息主键
     * @return 结果
     */
    public int deleteTPrescriptionRecordsById(Long id);

    /**
     * 批量删除处方信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTPrescriptionRecordsByIds(String[] ids);

    /**
     * 批量删除处方的药品信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTPrescriptionDrugInfoByPrescriptionids(String[] ids);
    
    /**
     * 批量新增处方的药品信息
     * 
     * @param tPrescriptionDrugInfoList 处方的药品信息列表
     * @return 结果
     */
    public int batchTPrescriptionDrugInfo(List<TPrescriptionDrugInfo> tPrescriptionDrugInfoList);
    

    /**
     * 通过处方信息主键删除处方的药品信息信息
     * 
     * @param id 处方信息ID
     * @return 结果
     */
    public int deleteTPrescriptionDrugInfoByPrescriptionid(Long id);
}
