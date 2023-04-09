package com.ruoyi.web.controller.business;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.base.BaseException;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.dto.req.DrugInfoOutBoundReq;
import com.ruoyi.system.dto.req.WareHouseOutBoundReq;
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
import com.ruoyi.system.domain.TDrugInfo;
import com.ruoyi.system.service.ITDrugInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品信息Controller
 * 
 * @author ruoyi
 * @date 2023-02-12
 */
@Controller
@RequestMapping("/business/drugInfo")
public class TDrugInfoController extends BaseController
{
    private String prefix = "business/drugInfo";

    @Autowired
    private ITDrugInfoService tDrugInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询药品信息列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TDrugInfo tDrugInfo)
    {
        startPage();
        tDrugInfo.setIsDelete("0");
        List<TDrugInfo> list = tDrugInfoService.selectTDrugInfoList(tDrugInfo);
        return getDataTable(list);
    }

    /**
     * 根据药品名称查询药品信息
     */
    @RequiresPermissions("system:info:getByName")
    @PostMapping("/getByName")
    @ResponseBody
    public TDrugInfo getByName(String drugName)
    {
        TDrugInfo tDrugInfo = tDrugInfoService.selectTDrugInfo(drugName);
        return tDrugInfo;
    }

    /**
     * 导出药品信息列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "药品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TDrugInfo tDrugInfo)
    {
        List<TDrugInfo> list = tDrugInfoService.selectTDrugInfoList(tDrugInfo);
        ExcelUtil<TDrugInfo> util = new ExcelUtil<TDrugInfo>(TDrugInfo.class);
        return util.exportExcel(list, "药品信息数据");
    }

    /**
     * 新增药品信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存药品信息
     */
    @RequiresPermissions("system:info:add")
    @Log(title = "药品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TDrugInfo tDrugInfo)
    {
        SysUser user = ShiroUtils.getSysUser();
        return toAjax(tDrugInfoService.insertTDrugInfo(tDrugInfo, user));
    }

    /**
     * 修改药品信息
     */
    @RequiresPermissions("system:info:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TDrugInfo tDrugInfo = tDrugInfoService.selectTDrugInfoById(id);
        tDrugInfo.setUnitPrice(tDrugInfo.getUnitPrice().divide(new BigDecimal(100)));
        tDrugInfo.setRetailPrice(tDrugInfo.getRetailPrice().divide(new BigDecimal(100)));
        mmap.put("tDrugInfo", tDrugInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存药品信息
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "药品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TDrugInfo tDrugInfo)
    {
        SysUser user = ShiroUtils.getSysUser();
        tDrugInfo.setUnitPrice(tDrugInfo.getUnitPrice().multiply(new BigDecimal(100)));
        tDrugInfo.setRetailPrice(tDrugInfo.getRetailPrice().multiply(new BigDecimal(100)));
        return toAjax(tDrugInfoService.updateTDrugInfo(tDrugInfo));
    }

    /**
     * 删除药品信息
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "药品信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tDrugInfoService.deleteTDrugInfoByIds(ids));
    }


    /**
     * 查询药品信息列表
     */
    @PostMapping("/drugList")
    @ResponseBody
    public AjaxResult drugList(TDrugInfo tDrugInfo)
    {
        tDrugInfo.setIsDelete("0");
        List<TDrugInfo> list = tDrugInfoService.selectTDrugInfoList(tDrugInfo);
        return AjaxResult.success(list);
    }


    @RequiresPermissions("system:info:view")
    @GetMapping("/drugInfoOutBound/{id}")
    public String drugInfoOutBound(@PathVariable("id") String id, ModelMap mmap)
    {
        TDrugInfo tDrugInfo = tDrugInfoService.selectTDrugInfoById(id);
        tDrugInfo.setUnitPrice(tDrugInfo.getUnitPrice().divide(new BigDecimal(100)));
        tDrugInfo.setRetailPrice(tDrugInfo.getRetailPrice().divide(new BigDecimal(100)));
        mmap.put("tDrugInfo", tDrugInfo);
        return prefix + "/drugInfoOutBound";
    }


    /**
     * 药品出库
     * @param drugInfoOutBoundReq
     * @return
     */
    @RequiresPermissions("system:info:outbound")
    @Log(title = "药品出库", businessType = BusinessType.UPDATE)
    @PostMapping("/drugInfoOutBound")
    @ResponseBody
    public AjaxResult wareHouseLogOutBound(DrugInfoOutBoundReq drugInfoOutBoundReq)
    {
        if(drugInfoOutBoundReq.getNum() <= 0){
            throw new BaseException("请输入正确的出库数量！");
        }
        SysUser user = ShiroUtils.getSysUser();
        return toAjax(tDrugInfoService.drugInfoOutBound(drugInfoOutBoundReq, user));
    }

}
