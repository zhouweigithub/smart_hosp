package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.TPrescriptionDrugInfo;
import com.ruoyi.system.mapper.TPrescriptionRecordsMapper;
import com.ruoyi.system.domain.TPrescriptionRecords;
import com.ruoyi.system.service.ITPrescriptionRecordsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 处方信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
@Service
public class TPrescriptionRecordsServiceImpl implements ITPrescriptionRecordsService 
{
    @Autowired
    private TPrescriptionRecordsMapper tPrescriptionRecordsMapper;

    /**
     * 查询处方信息
     * 
     * @param id 处方信息主键
     * @return 处方信息
     */
    @Override
    public TPrescriptionRecords selectTPrescriptionRecordsById(Long id)
    {
        return tPrescriptionRecordsMapper.selectTPrescriptionRecordsById(id);
    }

    /**
     * 查询处方信息列表
     * 
     * @param tPrescriptionRecords 处方信息
     * @return 处方信息
     */
    @Override
    public List<TPrescriptionRecords> selectTPrescriptionRecordsList(TPrescriptionRecords tPrescriptionRecords)
    {
        return tPrescriptionRecordsMapper.selectTPrescriptionRecordsList(tPrescriptionRecords);
    }

    /**
     * 新增处方信息
     * 
     * @param tPrescriptionRecords 处方信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTPrescriptionRecords(TPrescriptionRecords tPrescriptionRecords)
    {
        int rows = tPrescriptionRecordsMapper.insertTPrescriptionRecords(tPrescriptionRecords);
        insertTPrescriptionDrugInfo(tPrescriptionRecords);
        return rows;
    }

    /**
     * 修改处方信息
     * 
     * @param tPrescriptionRecords 处方信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateTPrescriptionRecords(TPrescriptionRecords tPrescriptionRecords)
    {
        tPrescriptionRecordsMapper.deleteTPrescriptionDrugInfoByPrescriptionid(tPrescriptionRecords.getId());
        insertTPrescriptionDrugInfo(tPrescriptionRecords);
        return tPrescriptionRecordsMapper.updateTPrescriptionRecords(tPrescriptionRecords);
    }

    /**
     * 批量删除处方信息
     * 
     * @param ids 需要删除的处方信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTPrescriptionRecordsByIds(String ids)
    {
        tPrescriptionRecordsMapper.deleteTPrescriptionDrugInfoByPrescriptionids(Convert.toStrArray(ids));
        return tPrescriptionRecordsMapper.deleteTPrescriptionRecordsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除处方信息信息
     * 
     * @param id 处方信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTPrescriptionRecordsById(Long id)
    {
        tPrescriptionRecordsMapper.deleteTPrescriptionDrugInfoByPrescriptionid(id);
        return tPrescriptionRecordsMapper.deleteTPrescriptionRecordsById(id);
    }

    /**
     * 新增处方的药品信息信息
     * 
     * @param tPrescriptionRecords 处方信息对象
     */
    public void insertTPrescriptionDrugInfo(TPrescriptionRecords tPrescriptionRecords)
    {
        List<TPrescriptionDrugInfo> tPrescriptionDrugInfoList = tPrescriptionRecords.getTPrescriptionDrugInfoList();
        Long id = tPrescriptionRecords.getId();
        if (StringUtils.isNotNull(tPrescriptionDrugInfoList))
        {
            List<TPrescriptionDrugInfo> list = new ArrayList<TPrescriptionDrugInfo>();
            for (TPrescriptionDrugInfo tPrescriptionDrugInfo : tPrescriptionDrugInfoList)
            {
                tPrescriptionDrugInfo.setPrescriptionid(id);
                list.add(tPrescriptionDrugInfo);
            }
            if (list.size() > 0)
            {
                tPrescriptionRecordsMapper.batchTPrescriptionDrugInfo(list);
            }
        }
    }
}
