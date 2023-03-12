package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TOutboundRecord;

/**
 * 仓库出库记录Service接口
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
public interface ITOutboundRecordService 
{
    /**
     * 查询仓库出库记录
     * 
     * @param id 仓库出库记录主键
     * @return 仓库出库记录
     */
    public TOutboundRecord selectTOutboundRecordById(String id);

    /**
     * 查询仓库出库记录列表
     * 
     * @param tOutboundRecord 仓库出库记录
     * @return 仓库出库记录集合
     */
    public List<TOutboundRecord> selectTOutboundRecordList(TOutboundRecord tOutboundRecord);

    /**
     * 新增仓库出库记录
     * 
     * @param tOutboundRecord 仓库出库记录
     * @return 结果
     */
    public int insertTOutboundRecord(TOutboundRecord tOutboundRecord);

    /**
     * 修改仓库出库记录
     * 
     * @param tOutboundRecord 仓库出库记录
     * @return 结果
     */
    public int updateTOutboundRecord(TOutboundRecord tOutboundRecord);

    /**
     * 批量删除仓库出库记录
     * 
     * @param ids 需要删除的仓库出库记录主键集合
     * @return 结果
     */
    public int deleteTOutboundRecordByIds(String ids);

    /**
     * 删除仓库出库记录信息
     * 
     * @param id 仓库出库记录主键
     * @return 结果
     */
    public int deleteTOutboundRecordById(String id);
}
