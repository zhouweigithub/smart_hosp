package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TWarehouseManager;

/**
 * 仓库入库记录Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
public interface TWarehouseManagerMapper 
{
    /**
     * 查询仓库入库记录
     * 
     * @param id 仓库入库记录主键
     * @return 仓库入库记录
     */
    public TWarehouseManager selectTWarehouseManagerById(String id);

    /**
     * 查询仓库入库记录列表
     * 
     * @param tWarehouseManager 仓库入库记录
     * @return 仓库入库记录集合
     */
    public List<TWarehouseManager> selectTWarehouseManagerList(TWarehouseManager tWarehouseManager);

    /**
     * 新增仓库入库记录
     * 
     * @param tWarehouseManager 仓库入库记录
     * @return 结果
     */
    public int insertTWarehouseManager(TWarehouseManager tWarehouseManager);

    /**
     * 修改仓库入库记录
     * 
     * @param tWarehouseManager 仓库入库记录
     * @return 结果
     */
    public int updateTWarehouseManager(TWarehouseManager tWarehouseManager);

    /**
     * 删除仓库入库记录
     * 
     * @param id 仓库入库记录主键
     * @return 结果
     */
    public int deleteTWarehouseManagerById(String id);

    /**
     * 批量删除仓库入库记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTWarehouseManagerByIds(String[] ids);

    /**
     * 查询药品有效入库记录
     *
     * @param drugId 仓库入库记录
     * @return 仓库入库记录集合
     */
    public List<TWarehouseManager> selectTWarehouseManagerValidList(String drugId);

    /**
     * 获取已过期的药品列表
     * @return
     */
    public List<TWarehouseManager> selectExpireDrugList();
}
