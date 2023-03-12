package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TOutboundRecordMapper;
import com.ruoyi.system.domain.TOutboundRecord;
import com.ruoyi.system.service.ITOutboundRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 仓库出库记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
@Service
public class TOutboundRecordServiceImpl implements ITOutboundRecordService 
{
    @Autowired
    private TOutboundRecordMapper tOutboundRecordMapper;

    /**
     * 查询仓库出库记录
     * 
     * @param id 仓库出库记录主键
     * @return 仓库出库记录
     */
    @Override
    public TOutboundRecord selectTOutboundRecordById(String id)
    {
        return tOutboundRecordMapper.selectTOutboundRecordById(id);
    }

    /**
     * 查询仓库出库记录列表
     * 
     * @param tOutboundRecord 仓库出库记录
     * @return 仓库出库记录
     */
    @Override
    public List<TOutboundRecord> selectTOutboundRecordList(TOutboundRecord tOutboundRecord)
    {
        tOutboundRecord.setIsDelete("0");
        return tOutboundRecordMapper.selectTOutboundRecordList(tOutboundRecord);
    }

    /**
     * 新增仓库出库记录
     * 
     * @param tOutboundRecord 仓库出库记录
     * @return 结果
     */
    @Override
    public int insertTOutboundRecord(TOutboundRecord tOutboundRecord)
    {
        tOutboundRecord.setCreateTime(DateUtils.getNowDate());
        return tOutboundRecordMapper.insertTOutboundRecord(tOutboundRecord);
    }

    /**
     * 修改仓库出库记录
     * 
     * @param tOutboundRecord 仓库出库记录
     * @return 结果
     */
    @Override
    public int updateTOutboundRecord(TOutboundRecord tOutboundRecord)
    {
        return tOutboundRecordMapper.updateTOutboundRecord(tOutboundRecord);
    }

    /**
     * 批量删除仓库出库记录
     * 
     * @param ids 需要删除的仓库出库记录主键
     * @return 结果
     */
    @Override
    public int deleteTOutboundRecordByIds(String ids)
    {
        return tOutboundRecordMapper.deleteTOutboundRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除仓库出库记录信息
     * 
     * @param id 仓库出库记录主键
     * @return 结果
     */
    @Override
    public int deleteTOutboundRecordById(String id)
    {
        return tOutboundRecordMapper.deleteTOutboundRecordById(id);
    }
}
