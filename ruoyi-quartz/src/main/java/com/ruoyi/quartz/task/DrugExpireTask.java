package com.ruoyi.quartz.task;

import com.ruoyi.system.mapper.TWarehouseManagerMapper;
import com.ruoyi.system.service.ITWarehouseManagerService;
import com.ruoyi.system.service.impl.TWarehouseManagerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务-药品过期
 * 
 * @author ruoyi
 */
@Component("drugExpireTask")
public class DrugExpireTask
{
    static Logger log = LoggerFactory.getLogger(DrugExpireTask.class);

    @Autowired
    private ITWarehouseManagerService tWarehouseManagerService;

    public void exec()
    {
        log.info("药品定时任务开始执行");
        tWarehouseManagerService.execDrugExpire();
        log.info("药品定时任务结束执行");
    }
}
