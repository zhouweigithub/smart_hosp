package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TPrescriptionRecords;

/**
 * 处方信息Service接口
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
public interface ITPrescriptionRecordsService 
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
     * 批量删除处方信息
     * 
     * @param ids 需要删除的处方信息主键集合
     * @return 结果
     */
    public int deleteTPrescriptionRecordsByIds(String ids);

    /**
     * 删除处方信息信息
     * 
     * @param id 处方信息主键
     * @return 结果
     */
    public int deleteTPrescriptionRecordsById(Long id);
}
