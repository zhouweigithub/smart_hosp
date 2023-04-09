package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.TDrugInfo;
import com.ruoyi.system.dto.req.DrugInfoOutBoundReq;

/**
 * 药品信息Service接口
 * 
 * @author ruoyi
 * @date 2023-02-12
 */
public interface ITDrugInfoService 
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
     * 根据药品名称查询药品信息
     *
     * @param drugName 药品名称
     * @return 药品信息集合
     */
    public TDrugInfo selectTDrugInfo(String drugName);


    /**
     * 新增药品信息
     * 
     * @param tDrugInfo 药品信息
     * @return 结果
     */
    public int insertTDrugInfo(TDrugInfo tDrugInfo, SysUser user);

    /**
     * 修改药品信息
     * 
     * @param tDrugInfo 药品信息
     * @return 结果
     */
    public int updateTDrugInfo(TDrugInfo tDrugInfo);

    /**
     * 批量删除药品信息
     * 
     * @param ids 需要删除的药品信息主键集合
     * @return 结果
     */
    public int deleteTDrugInfoByIds(String ids);

    /**
     * 删除药品信息信息
     * 
     * @param id 药品信息主键
     * @return 结果
     */
    public int deleteTDrugInfoById(String id);

    /**
     * 药品出库
     * @param drugInfoOutBoundReq
     * @param user
     * @return
     */
    public int drugInfoOutBound(DrugInfoOutBoundReq drugInfoOutBoundReq, SysUser user);
}
