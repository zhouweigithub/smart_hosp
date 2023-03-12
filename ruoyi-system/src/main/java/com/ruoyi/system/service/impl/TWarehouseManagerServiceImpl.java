package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.base.BaseException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.common.utils.uuid.Seq;
import com.ruoyi.system.domain.TDrugInfo;
import com.ruoyi.system.domain.TOutboundRecord;
import com.ruoyi.system.domain.TWarehouseManager;
import com.ruoyi.system.dto.req.WareHouseOutBoundReq;
import com.ruoyi.system.mapper.TWarehouseManagerMapper;
import com.ruoyi.system.service.ITDrugInfoService;
import com.ruoyi.system.service.ITOutboundRecordService;
import com.ruoyi.system.service.ITWarehouseManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 仓库入库记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
@Service
public class TWarehouseManagerServiceImpl implements ITWarehouseManagerService 
{
    private static final String DRUG_WAREHOUSE_PREFIX = "YPRK";

    static Logger log = LoggerFactory.getLogger(TWarehouseManagerServiceImpl.class);

    @Autowired
    private TWarehouseManagerMapper tWarehouseManagerMapper;

    @Autowired
    private ITDrugInfoService tDrugInfoService;

    @Autowired
    private ITOutboundRecordService outboundRecordService;

    /**
     * 查询仓库入库记录
     * 
     * @param id 仓库入库记录主键
     * @return 仓库入库记录
     */
    @Override
    public TWarehouseManager selectTWarehouseManagerById(String id)
    {
        return tWarehouseManagerMapper.selectTWarehouseManagerById(id);
    }

    /**
     * 查询仓库入库记录列表
     * 
     * @param tWarehouseManager 仓库入库记录
     * @return 仓库入库记录
     */
    @Override
    public List<TWarehouseManager> selectTWarehouseManagerList(TWarehouseManager tWarehouseManager)
    {
        tWarehouseManager.setIsDelete("0");
        return tWarehouseManagerMapper.selectTWarehouseManagerList(tWarehouseManager);
    }

    /**
     * 新增仓库入库记录
     * 
     * @param tWarehouseManager 仓库入库记录
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertTWarehouseManager(TWarehouseManager tWarehouseManager, SysUser user)
    {
        TDrugInfo tDrugInfot = tDrugInfoService.selectTDrugInfoById(tWarehouseManager.getDrugId());
        if(Objects.isNull(tDrugInfot)){
            throw new BaseException("药品信息不存在");
        }

        tWarehouseManager.setId(IdUtils.simpleUUID());
        tWarehouseManager.setWarehouseCode(DRUG_WAREHOUSE_PREFIX + Seq.getId());
        tWarehouseManager.setCreateBy(String.valueOf(user.getUserId()));
        tWarehouseManager.setDrugName(tDrugInfot.getDrugName());
        tWarehouseManager.setDrugAlisa(tDrugInfot.getDrugAlias());
        tWarehouseManager.setCreateTime(DateUtils.getNowDate());
        tWarehouseManager.setResidueNum(tWarehouseManager.getInsertNum());
        tWarehouseManagerMapper.insertTWarehouseManager(tWarehouseManager);

        //更新药品列表
        long num  = tDrugInfot.getStock();
        num += tWarehouseManager.getInsertNum();
        tDrugInfot.setStock(num);
        tDrugInfoService.updateTDrugInfo(tDrugInfot);
        return 1;
    }

    /**
     * 修改仓库入库记录
     * 
     * @param tWarehouseManager 仓库入库记录
     * @return 结果
     */
    @Override
    public int updateTWarehouseManager(TWarehouseManager tWarehouseManager)
    {
        tWarehouseManager.setUpdateTime(DateUtils.getNowDate());
        return tWarehouseManagerMapper.updateTWarehouseManager(tWarehouseManager);
    }

    /**
     * 批量删除仓库入库记录
     * 
     * @param ids 需要删除的仓库入库记录主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseManagerByIds(String ids)
    {
        return tWarehouseManagerMapper.deleteTWarehouseManagerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除仓库入库记录信息
     * 
     * @param id 仓库入库记录主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseManagerById(String id)
    {
        return tWarehouseManagerMapper.deleteTWarehouseManagerById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int wareHouseLogOutBound(WareHouseOutBoundReq wareHouseOutBoundReq, SysUser user) {
        TWarehouseManager tWarehouseManager = tWarehouseManagerMapper.selectTWarehouseManagerById(wareHouseOutBoundReq.getId());
        if(tWarehouseManager.getResidueNum() < wareHouseOutBoundReq.getNum()){
            throw new BaseException("出库失败,剩余药品数量不足！");
        }

        int residueNum = tWarehouseManager.getResidueNum() - wareHouseOutBoundReq.getNum();
        tWarehouseManager.setResidueNum(residueNum);
        tWarehouseManager.setUpdateBy(String.valueOf(user.getUserId()));
        tWarehouseManager.setUpdateTime(DateUtils.getNowDate());
        tWarehouseManagerMapper.updateTWarehouseManager(tWarehouseManager);

        //更新药品列表
        TDrugInfo tDrugInfot = tDrugInfoService.selectTDrugInfoById(tWarehouseManager.getDrugId());
        long num  = tDrugInfot.getStock();
        num -= wareHouseOutBoundReq.getNum();
        tDrugInfot.setStock(num);
        tDrugInfoService.updateTDrugInfo(tDrugInfot);

        //插入出库记录表
        TOutboundRecord tOutboundRecord = new TOutboundRecord();
        tOutboundRecord.setId(IdUtils.simpleUUID());
        tOutboundRecord.setDrugId(tWarehouseManager.getDrugId());
        tOutboundRecord.setWarehouseCode(tWarehouseManager.getWarehouseCode());
        tOutboundRecord.setDrugName(tDrugInfot.getDrugName());
        tOutboundRecord.setDrugAlisa(tDrugInfot.getDrugAlias());
        tOutboundRecord.setOutboundNum(wareHouseOutBoundReq.getNum());
        tOutboundRecord.setCreateBy(String.valueOf(user.getUserId()));
        outboundRecordService.insertTOutboundRecord(tOutboundRecord);
        return 1;
    }

    @Override
    public int execDrugExpire() {
        List<TWarehouseManager> list = tWarehouseManagerMapper.selectExpireDrugList();
        for(TWarehouseManager tWarehouseManager : list){
            try {
                execExpireTask(tWarehouseManager);
            }catch (Exception e){
                log.error("执行药品过期任务失败", e);
            }
        }
        return 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void execExpireTask(TWarehouseManager tWarehouseManager){
        //更新入库记录
        tWarehouseManager.setExpireStatus("1");
        tWarehouseManagerMapper.updateTWarehouseManager(tWarehouseManager);

        //更新药品列表
        TDrugInfo tDrugInfot = tDrugInfoService.selectTDrugInfoById(tWarehouseManager.getDrugId());
        long num  = tDrugInfot.getStock();
        num -= tWarehouseManager.getResidueNum();
        tDrugInfot.setStock(num);
        tDrugInfoService.updateTDrugInfo(tDrugInfot);
    }
}
