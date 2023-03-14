package com.ruoyi.web.controller.business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
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
import com.ruoyi.system.domain.TPrescriptionRecords;
import com.ruoyi.system.service.ITPrescriptionRecordsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 处方信息Controller
 *
 * @author ruoyi
 * @date 2023-03-11
 */
@Controller
@RequestMapping("/system/records")
public class TPrescriptionRecordsController extends BaseController {
    private String prefix = "system/records";

    @Autowired
    private ITPrescriptionRecordsService tPrescriptionRecordsService;

    @RequiresPermissions("system:records:view")
    @GetMapping()
    public String records() {
        return prefix + "/records";
    }

    /**
     * 查询处方信息列表
     */
    @RequiresPermissions("system:records:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TPrescriptionRecords tPrescriptionRecords) {
        startPage();
        List<TPrescriptionRecords> list = tPrescriptionRecordsService.selectTPrescriptionRecordsList(tPrescriptionRecords);
        return getDataTable(list);
    }

    /**
     * 导出处方信息列表
     */
    @RequiresPermissions("system:records:export")
    @Log(title = "处方信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TPrescriptionRecords tPrescriptionRecords) {
        List<TPrescriptionRecords> list = tPrescriptionRecordsService.selectTPrescriptionRecordsList(tPrescriptionRecords);
        ExcelUtil<TPrescriptionRecords> util = new ExcelUtil<TPrescriptionRecords>(TPrescriptionRecords.class);
        return util.exportExcel(list, "处方信息数据");
    }

    /**
     * 新增处方信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存处方信息
     */
    @RequiresPermissions("system:records:add")
    @Log(title = "处方信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TPrescriptionRecords tPrescriptionRecords) {
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        tPrescriptionRecords.setSkinTest("");
        tPrescriptionRecords.setCrtime(DateUtils.getNowDate());
        tPrescriptionRecords.setStatus("未完结");
        tPrescriptionRecords.setDoctorid(getSysUser().getUserId());
        System.out.println(tPrescriptionRecords.getCrtime()+" getCrtime******************");
        System.out.println(tPrescriptionRecords.getSex()+" getSex******************");
        System.out.println(tPrescriptionRecords.getTPrescriptionDrugInfoList().get(0).getDrugid()+" getDrugid******************");
        return toAjax(tPrescriptionRecordsService.insertTPrescriptionRecords(tPrescriptionRecords));
    }

    /**
     * 修改处方信息
     */
    @RequiresPermissions("system:records:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TPrescriptionRecords tPrescriptionRecords = tPrescriptionRecordsService.selectTPrescriptionRecordsById(id);
        mmap.put("tPrescriptionRecords", tPrescriptionRecords);
        return prefix + "/edit";
    }

    /**
     * 修改保存处方信息
     */
    @RequiresPermissions("system:records:edit")
    @Log(title = "处方信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TPrescriptionRecords tPrescriptionRecords) {
        return toAjax(tPrescriptionRecordsService.updateTPrescriptionRecords(tPrescriptionRecords));
    }

    /**
     * 删除处方信息
     */
    @RequiresPermissions("system:records:remove")
    @Log(title = "处方信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tPrescriptionRecordsService.deleteTPrescriptionRecordsByIds(ids));
    }
}
