/**
 * @filename:SysRoleServiceImpl 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.service;

import com.bingsum.annotation.Api;
import com.bingsum.util.ApiUtil;
import com.bingsum.util.ParaData;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;

import java.util.List;

import com.bingsum.model.SysRole;
import com.bingsum.mapper.SysRoleMapper;
import tk.mybatis.mapper.entity.Example;

/**   
 *  
 * @Description:  角色——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("sysRoleService")
@Transactional(readOnly = true)
public class SysRoleService{

    @Autowired
    private SysRoleMapper sysRoleMapper;
	
    public List<SysRole> getAll(SysRole sysRole) {
        if (sysRole.getPage() != null && sysRole.getRows() != null) {
            PageHelper.startPage(sysRole.getPage(), sysRole.getRows());
        }
        return sysRoleMapper.selectAll();
    }

    public SysRole getById(Integer id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(SysRole sysRole) {
        if (sysRole.getId() != null) {
            sysRoleMapper.updateByPrimaryKey(sysRole);
        } else {
            sysRoleMapper.insert(sysRole);
        }
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    public Object getSysRoleInfoList(ParaData pd){
        Page<?> page = PageHelper.startPage(pd.getInteger("currentPage"), 20);
        Example example = new Example(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        example.orderBy("createTime").desc();
        sysRoleMapper.selectByExample(example);
        return ApiUtil.returnObject(pd, page);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    public Object getSysRoleInfo(ParaData pd) {
        Example example = new Example(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", pd.getString("id"));
        SysRole role = sysRoleMapper.selectOneByExample(example);

        if (role == null){
            return ApiUtil.returnDescFail(pd,"没有该数据！");
        }
        return ApiUtil.returnOK(pd,role);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    @Transactional(readOnly = false)
    public Object newSysRoleInfo(ParaData pd) {
        SysRole role = pd.toAddBean(SysRole.class);
        role.setCreateBy(pd.getLoginStaff().getId());
        this.sysRoleMapper.insert(role);
        return ApiUtil.returnOK(pd,role);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object setSysRoleInfo(ParaData pd) {
        SysRole role = pd.toUpdateBean(SysRole.class);
        role.setUpdateBy(pd.getLoginStaff().getId());
        this.sysRoleMapper.updateByPrimaryKeySelective(role);
        return ApiUtil.returnOK(pd,role);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object delSysRole(ParaData pd) {
        SysRole role = pd.toDeleteBean(SysRole.class);
        sysRoleMapper.updateByPrimaryKeySelective(role);
        return ApiUtil.returnOK(pd,role);
    }

}