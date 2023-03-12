package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TDrugInfo;

/**
 * 药品信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-12
 */
public interface TDrugInfoMapper 
{
    /**
     * 查询药品信息
     * 
     * @param id 药品信息主键
     * @return 药品信息
     */
    public TDrugInfo selectTDrugInfoById(String id);

    /**
     * 查询药品信息列表
     * 
     * @param tDrugInfo 药品信息
     * @return 药品信息集合
     */
    public List<TDrugInfo> selectTDrugInfoList(TDrugInfo tDrugInfo);

    /**
     * 新增药品信息
     * 
     * @param tDrugInfo 药品信息
     * @return 结果
     */
    public int insertTDrugInfo(TDrugInfo tDrugInfo);

    /**
     * 修改药品信息
     * 
     * @param tDrugInfo 药品信息
     * @return 结果
     */
    public int updateTDrugInfo(TDrugInfo tDrugInfo);

    /**
     * 删除药品信息
     * 
     * @param id 药品信息主键
     * @return 结果
     */
    public int deleteTDrugInfoById(String id);

    /**
     * 批量删除药品信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTDrugInfoByIds(String[] ids);
}
