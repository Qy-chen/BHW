/**
 * @filename:ManufacturerPatentServiceImpl 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.service;

import com.bingsum.annotation.Api;
import com.bingsum.model.Staff;
import com.bingsum.util.ApiUtil;
import com.bingsum.util.ParaData;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;

import java.util.List;

import com.bingsum.model.ManufacturerPatent;
import com.bingsum.mapper.ManufacturerPatentMapper;
import tk.mybatis.mapper.entity.Example;

/**   
 *  
 * @Description:  [暂未用到]工厂专利——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("manufacturerPatentService")
@Transactional(readOnly = true)
public class ManufacturerPatentService{

    @Autowired
    private ManufacturerPatentMapper manufacturerPatentMapper;
	
    public List<ManufacturerPatent> getAll(ManufacturerPatent manufacturerPatent) {
        if (manufacturerPatent.getPage() != null && manufacturerPatent.getRows() != null) {
            PageHelper.startPage(manufacturerPatent.getPage(), manufacturerPatent.getRows());
        }
        return manufacturerPatentMapper.selectAll();
    }

    public ManufacturerPatent getById(Integer id) {
        return manufacturerPatentMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        manufacturerPatentMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ManufacturerPatent manufacturerPatent) {
        if (manufacturerPatent.getId() != null) {
            manufacturerPatentMapper.updateByPrimaryKey(manufacturerPatent);
        } else {
            manufacturerPatentMapper.insert(manufacturerPatent);
        }
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    public Object getManufacturerPatentInfoList(ParaData pd){
        Example example = new Example(ManufacturerPatent.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        Page<?> page = PageHelper.startPage(pd.getInteger("currentPage"), 20);
        manufacturerPatentMapper.selectByExample(example);
        return ApiUtil.returnObject(pd, page);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    public Object getManufacturerPatentInfo(ParaData pd) {
        Example example = new Example(ManufacturerPatent.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        criteria.andEqualTo("id", pd.getString("id"));
        ManufacturerPatent manufacturerPatent = manufacturerPatentMapper.selectOneByExample(example);

        if (manufacturerPatent == null){
            return ApiUtil.returnDescFail(pd,"没有该数据！");
        }
        return ApiUtil.returnOK(pd,manufacturerPatent);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    @Transactional(readOnly = false)
    public Object newManufacturerPatentInfo(ParaData pd) {
        ManufacturerPatent manufacturerPatent = pd.toAddBean(ManufacturerPatent.class);
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            manufacturerPatent.setManufacturerId(staff.getManufacturer_id());
        }
        this.manufacturerPatentMapper.insert(manufacturerPatent);
        return ApiUtil.returnOK(pd,manufacturerPatent);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object setManufacturerPatentInfo(ParaData pd) {
        ManufacturerPatent manufacturerPatent = pd.toUpdateBean(ManufacturerPatent.class);
        this.manufacturerPatentMapper.updateByPrimaryKeySelective(manufacturerPatent);
        return ApiUtil.returnOK(pd,manufacturerPatent);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object delManufacturerPatent(ParaData pd) {
        ManufacturerPatent manufacturerPatent = pd.toDeleteBean(ManufacturerPatent.class);
        manufacturerPatentMapper.updateByPrimaryKeySelective(manufacturerPatent);
        return ApiUtil.returnOK(pd,manufacturerPatent);
    }
}