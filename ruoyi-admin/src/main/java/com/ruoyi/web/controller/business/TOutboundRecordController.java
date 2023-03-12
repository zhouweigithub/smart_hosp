package com.ruoyi.web.controller.business;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TOutboundRecord;
import com.ruoyi.system.service.ITOutboundRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库出库记录Controller
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
@Controller
@RequestMapping("/outbound/record")
public class TOutboundRecordController extends BaseController
{
    private String prefix = "business/outbound";

    @Autowired
    private ITOutboundRecordService tOutboundRecordService;

    @RequiresPermissions("system:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询仓库出库记录列表
     */
    @RequiresPermissions("outbound:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TOutboundRecord tOutboundRecord)
    {
        startPage();
        List<TOutboundRecord> list = tOutboundRecordService.selectTOutboundRecordList(tOutboundRecord);
        return getDataTable(list);
    }

    /**
     * 导出仓库出库记录列表
     */
    @RequiresPermissions("outbound:record:export")
    @Log(title = "仓库出库记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TOutboundRecord tOutboundRecord)
    {
        List<TOutboundRecord> list = tOutboundRecordService.selectTOutboundRecordList(tOutboundRecord);
        ExcelUtil<TOutboundRecord> util = new ExcelUtil<TOutboundRecord>(TOutboundRecord.class);
        return util.exportExcel(list, "仓库出库记录数据");
    }

    /**
     * 新增仓库出库记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存仓库出库记录
     */
    @RequiresPermissions("outbound:record:add")
    @Log(title = "仓库出库记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TOutboundRecord tOutboundRecord)
    {
        return toAjax(tOutboundRecordService.insertTOutboundRecord(tOutboundRecord));
    }

    /**
     * 修改仓库出库记录
     */
    @RequiresPermissions("outbound:record:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TOutboundRecord tOutboundRecord = tOutboundRecordService.selectTOutboundRecordById(id);
        mmap.put("tOutboundRecord", tOutboundRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存仓库出库记录
     */
    @RequiresPermissions("outbound:record:edit")
    @Log(title = "仓库出库记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TOutboundRecord tOutboundRecord)
    {
        return toAjax(tOutboundRecordService.updateTOutboundRecord(tOutboundRecord));
    }

    /**
     * 删除仓库出库记录
     */
    @RequiresPermissions("outbound:record:remove")
    @Log(title = "仓库出库记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tOutboundRecordService.deleteTOutboundRecordByIds(ids));
    }
}
