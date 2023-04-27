package com.ruoyi.framework.web.service;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysDictTypeService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RuoYi首创 html调用 thymeleaf 实现字典读取
 * 
 * @author ruoyi
 */
@Service("sysuser")
public class SysUserService
{
    @Autowired
    private ISysUserService userService;

    /**
     * 根据部门id获取用户
     * 
     * @param deptId 部门id
     * @return 参数键值
     */
    public List<SysUser> getUsers(Long deptId)
    {
        return userService.selectByDeptId(deptId);
    }


}
