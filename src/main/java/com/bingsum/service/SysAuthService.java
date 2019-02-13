/**
 * @filename:SysAuthServiceImpl 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

import com.bingsum.model.SysAuth;
import com.bingsum.model.SysRole;
import com.bingsum.util.ApiUtil;
import com.bingsum.util.ParaData;
import com.bingsum.annotation.Api;
import com.bingsum.mapper.SysAuthMapper;

/**   
 *  
 * @Description:  权限——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("sysAuthService")
@Transactional(readOnly = true)
public class SysAuthService{

    @Autowired
    private SysAuthMapper sysAuthMapper;
	
    public List<SysAuth> getAll(SysAuth sysAuth) {
        if (sysAuth.getPage() != null && sysAuth.getRows() != null) {
            PageHelper.startPage(sysAuth.getPage(), sysAuth.getRows());
        }
        return sysAuthMapper.selectAll();
    }

    public SysAuth getById(Integer id) {
        return sysAuthMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        sysAuthMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(SysAuth sysAuth) {
        if (sysAuth.getId() != null) {
            sysAuthMapper.updateByPrimaryKey(sysAuth);
        } else {
            sysAuthMapper.insert(sysAuth);
        }
    }
    

    /**
     * 分页查询权限设置
     * @param pd
     * @return
     */
    @Api
    public Object getSysAuthList(ParaData pd){
        Page<?> page = PageHelper.startPage(pd.getInteger("currentPage"), 20);
        this.sysAuthMapper.selectAllWithDt();
        return ApiUtil.returnObject(pd, page);
    }

    /**
     * 根据id查询
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    public Object getSysAuth(ParaData pd) {
    	SysAuth res = this.sysAuthMapper.selectByPrimaryKey(pd.getInteger("id"));
        if (res == null){
            return ApiUtil.returnDescFail(pd,"没有该数据！");
        }
        return ApiUtil.returnOK(pd,res);
    }

    /**
     * 新增权限
     * @param pd
     * @return
     */
    @Api
    @Transactional(readOnly = false)
    public Object addSysAuth(ParaData pd) {
    	SysAuth record = pd.toAddBean(SysAuth.class);
    	this.sysAuthMapper.insert(record);
        return ApiUtil.returnOK(pd, record);
    }

    /**
     * 根据id修改权限设置
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object updateSysAuth(ParaData pd) {
    	SysAuth record = pd.toUpdateBean(SysAuth.class);
    	this.sysAuthMapper.updateByPrimaryKeySelective(record);
        return ApiUtil.returnOK(pd, record);
    }

    /**
     * 删除权限设置
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object delSysAuth(ParaData pd) {
    	SysAuth record = pd.toDeleteBean(SysAuth.class);
    	this.sysAuthMapper.updateByPrimaryKeySelective(record);
        return ApiUtil.returnOK(pd, record);
    }

}