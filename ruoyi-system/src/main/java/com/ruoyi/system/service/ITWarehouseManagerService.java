package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.TWarehouseManager;
import com.ruoyi.system.dto.req.WareHouseOutBoundReq;

/**
 * 仓库入库记录Service接口
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
public interface ITWarehouseManagerService 
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
    public int insertTWarehouseManager(TWarehouseManager tWarehouseManager, SysUser user);

    /**
     * 修改仓库入库记录
     * 
     * @param tWarehouseManager 仓库入库记录
     * @return 结果
     */
    public int updateTWarehouseManager(TWarehouseManager tWarehouseManager);

    /**
     * 批量删除仓库入库记录
     * 
     * @param ids 需要删除的仓库入库记录主键集合
     * @return 结果
     */
    public int deleteTWarehouseManagerByIds(String ids);

    /**
     * 删除仓库入库记录信息
     * 
     * @param id 仓库入库记录主键
     * @return 结果
     */
    public int deleteTWarehouseManagerById(String id);

    /**
     * 入库记录出库
     * @param wareHouseOutBoundReq
     * @return
     */
    public int wareHouseLogOutBound(WareHouseOutBoundReq wareHouseOutBoundReq, SysUser user);


    public int execDrugExpire();

}
