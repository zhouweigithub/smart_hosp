package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.base.BaseException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.common.utils.uuid.Seq;
import com.ruoyi.system.domain.TDrugInfo;
import com.ruoyi.system.domain.TWarehouseManager;
import com.ruoyi.system.dto.req.DrugInfoOutBoundReq;
import com.ruoyi.system.dto.req.WareHouseOutBoundReq;
import com.ruoyi.system.mapper.TDrugInfoMapper;
import com.ruoyi.system.mapper.TWarehouseManagerMapper;
import com.ruoyi.system.service.ITDrugInfoService;
import com.ruoyi.system.service.ITWarehouseManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * 药品信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-12
 */
@Service
public class TDrugInfoServiceImpl implements ITDrugInfoService
{
    private static final String DRUG_PREFIX = "YPBH";

    @Autowired
    private TDrugInfoMapper tDrugInfoMapper;

    @Autowired
    private TWarehouseManagerMapper tWarehouseManagerMapper;

    @Autowired
    private ITWarehouseManagerService tWarehouseManagerService;

    /**
     * 查询药品信息
     * 
     * @param id 药品信息主键
     * @return 药品信息
     */
    @Override
    public TDrugInfo selectTDrugInfoById(String id)
    {
        return tDrugInfoMapper.selectTDrugInfoById(id);
    }

    /**
     * 查询药品信息列表
     * 
     * @param tDrugInfo 药品信息
     * @return 药品信息
     */
    @Override
    public List<TDrugInfo> selectTDrugInfoList(TDrugInfo tDrugInfo)
    {
        return tDrugInfoMapper.selectTDrugInfoList(tDrugInfo);
    }

    /**
     * 根据药品名称查询药品信息
     *
     * @param drugName 药品信息
     * @return 药品信息
     */
    @Override
    public TDrugInfo selectTDrugInfo(String drugName)
    {
        return tDrugInfoMapper.selectTDrugInfoByName(drugName);
    }

    /**
     * 新增药品信息
     * 
     * @param tDrugInfo 药品信息
     * @return 结果
     */
    @Override
    public int insertTDrugInfo(TDrugInfo tDrugInfo, SysUser user)
    {
        tDrugInfo.setId(IdUtils.simpleUUID());
        tDrugInfo.setCreateTime(DateUtils.getNowDate());
        tDrugInfo.setCreateBy(String.valueOf(user.getUserId()));
        tDrugInfo.setUnitPrice(tDrugInfo.getUnitPrice().multiply(new BigDecimal(100)));
        tDrugInfo.setRetailPrice(tDrugInfo.getRetailPrice().multiply(new BigDecimal(100)));
        tDrugInfo.setDrugCode(DRUG_PREFIX + Seq.getId());
        return tDrugInfoMapper.insertTDrugInfo(tDrugInfo);
    }

    /**
     * 修改药品信息
     * 
     * @param tDrugInfo 药品信息
     * @return 结果
     */
    @Override
    public int updateTDrugInfo(TDrugInfo tDrugInfo)
    {
        tDrugInfo.setUpdateTime(DateUtils.getNowDate());
        return tDrugInfoMapper.updateTDrugInfo(tDrugInfo);
    }

    /**
     * 批量删除药品信息
     * 
     * @param ids 需要删除的药品信息主键
     * @return 结果
     */
    @Override
    public int deleteTDrugInfoByIds(String ids)
    {
        return tDrugInfoMapper.deleteTDrugInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除药品信息信息
     * 
     * @param id 药品信息主键
     * @return 结果
     */
    @Override
    public int deleteTDrugInfoById(String id)
    {
        return tDrugInfoMapper.deleteTDrugInfoById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int drugInfoOutBound(DrugInfoOutBoundReq drugInfoOutBoundReq, SysUser user) {
        //判断药品数量
        TDrugInfo tDrugInfo = tDrugInfoMapper.selectTDrugInfoById(drugInfoOutBoundReq.getId());
        if(tDrugInfo.getStock() < drugInfoOutBoundReq.getNum()){
            throw new BaseException("药品库存数量不足！");
        }

        //查询入库记录
        List<TWarehouseManager> list = tWarehouseManagerMapper.selectTWarehouseManagerValidList(drugInfoOutBoundReq.getId());
        //按制定顺序出库相关药品
        int num  = drugInfoOutBoundReq.getNum();
        for(TWarehouseManager tWarehouseManager : list){
            if(num == 0){
                break;
            }

            WareHouseOutBoundReq wareHouseOutBoundReq = new WareHouseOutBoundReq();
            wareHouseOutBoundReq.setId(tWarehouseManager.getId());

            if(num > tWarehouseManager.getResidueNum()){
                num = num - tWarehouseManager.getResidueNum();
                wareHouseOutBoundReq.setNum(tWarehouseManager.getResidueNum());
            }else{
                wareHouseOutBoundReq.setNum(num);
                num = 0;
            }
            tWarehouseManagerService.wareHouseLogOutBound(wareHouseOutBoundReq, user);
        }

        return 1;
    }
}
