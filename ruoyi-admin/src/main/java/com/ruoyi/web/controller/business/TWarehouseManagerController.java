package com.ruoyi.web.controller.business;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.TDrugInfo;
import com.ruoyi.system.dto.req.WareHouseOutBoundReq;
import com.ruoyi.system.service.ITDrugInfoService;
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
import com.ruoyi.system.domain.TWarehouseManager;
import com.ruoyi.system.service.ITWarehouseManagerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库入库记录Controller
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
@Controller
@RequestMapping("/business/warehouse/manager")
public class TWarehouseManagerController extends BaseController
{
    private String prefix = "business/wareHousing";

    @Autowired
    private ITWarehouseManagerService tWarehouseManagerService;

    @Autowired
    private ITDrugInfoService tDrugInfoService;

    @RequiresPermissions("warehouse:manager:view")
    @GetMapping()
    public String manager()
    {
        return prefix + "/manager";
    }

    /**
     * 查询仓库入库记录列表
     */
    @RequiresPermissions("warehouse:manager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TWarehouseManager tWarehouseManager)
    {
        startPage();
        List<TWarehouseManager> list = tWarehouseManagerService.selectTWarehouseManagerList(tWarehouseManager);
        return getDataTable(list);
    }

    /**
     * 导出仓库入库记录列表
     */
    @RequiresPermissions("warehouse:manager:export")
    @Log(title = "仓库入库记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TWarehouseManager tWarehouseManager)
    {
        List<TWarehouseManager> list = tWarehouseManagerService.selectTWarehouseManagerList(tWarehouseManager);
        ExcelUtil<TWarehouseManager> util = new ExcelUtil<TWarehouseManager>(TWarehouseManager.class);
        return util.exportExcel(list, "仓库入库记录数据");
    }

    /**
     * 新增仓库入库记录
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        TDrugInfo tDrugInfo = new TDrugInfo();
        tDrugInfo.setIsDelete("0");
        List<TDrugInfo> list = tDrugInfoService.selectTDrugInfoList(tDrugInfo);
        mmap.put("drugList", list);
        return prefix + "/add";
    }

    /**
     * 新增保存仓库入库记录
     */
    @RequiresPermissions("warehouse:manager:add")
    @Log(title = "仓库入库记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TWarehouseManager tWarehouseManager)
    {
        SysUser user = ShiroUtils.getSysUser();
        return toAjax(tWarehouseManagerService.insertTWarehouseManager(tWarehouseManager,user));
    }

    /**
     * 修改仓库入库记录
     */
    @RequiresPermissions("warehouse:manager:outbound")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TWarehouseManager tWarehouseManager = tWarehouseManagerService.selectTWarehouseManagerById(id);
        mmap.put("tWarehouseManager", tWarehouseManager);
        return prefix + "/edit";
    }

    @RequiresPermissions("warehouse:manager:edit")
    @Log(title = "仓库入库记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TWarehouseManager tWarehouseManager)
    {
        return toAjax(tWarehouseManagerService.updateTWarehouseManager(tWarehouseManager));
    }

    /**
     * 删除仓库入库记录
     */
    @RequiresPermissions("warehouse:manager:remove")
    @Log(title = "仓库入库记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tWarehouseManagerService.deleteTWarehouseManagerByIds(ids));
    }

    /**
     * 制定具体的入库记录出库
     * @param wareHouseOutBoundReq
     * @return
     */
    @RequiresPermissions("warehouse:manager:outbound")
    @PostMapping("/wareHouseLogOutBound")
    @ResponseBody
    public AjaxResult wareHouseLogOutBound(WareHouseOutBoundReq wareHouseOutBoundReq)
    {
        SysUser user = ShiroUtils.getSysUser();
        return toAjax(tWarehouseManagerService.wareHouseLogOutBound(wareHouseOutBoundReq, user));
    }

    @RequiresPermissions("warehouse:manager:outbound")
    @GetMapping("/expiringSoonDrug")
    public String expiringSoonView()
    {
        return prefix + "/expiringSoonDrug";
    }

    /**
     * 查询仓库入库记录列表
     */
    @RequiresPermissions("warehouse:manager:expiringSoonList")
    @PostMapping("/expiringSoonList")
    @ResponseBody
    public TableDataInfo expiringSoonList(TWarehouseManager tWarehouseManager)
    {
        startPage();
        Date date = DateUtils.addDays(DateUtils.getNowDate(), 180);
        tWarehouseManager.setExpirationTime(date);
        List<TWarehouseManager> list = tWarehouseManagerService.selectTWarehouseManagerList(tWarehouseManager);
        return getDataTable(list);
    }
}
