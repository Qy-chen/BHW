/**
 * @filename:ManufacturerQualificationServiceImpl 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.service;

import com.bingsum.annotation.Api;
import com.bingsum.model.Manufacturer;
import com.bingsum.model.Staff;
import com.bingsum.util.ApiUtil;
import com.bingsum.util.ParaData;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;

import java.util.List;

import com.bingsum.model.ManufacturerQualification;
import com.bingsum.mapper.ManufacturerQualificationMapper;
import tk.mybatis.mapper.entity.Example;

/**   
 *  
 * @Description:  工厂资质——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("manufacturerQualificationService")
@Transactional(readOnly = true)
public class ManufacturerQualificationService{

    @Autowired
    private ManufacturerQualificationMapper manufacturerQualificationMapper;
	
    public List<ManufacturerQualification> getAll(ManufacturerQualification manufacturerQualification) {
        if (manufacturerQualification.getPage() != null && manufacturerQualification.getRows() != null) {
            PageHelper.startPage(manufacturerQualification.getPage(), manufacturerQualification.getRows());
        }
        return manufacturerQualificationMapper.selectAll();
    }

    public ManufacturerQualification getById(Integer id) {
        return manufacturerQualificationMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        manufacturerQualificationMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ManufacturerQualification manufacturerQualification) {
        if (manufacturerQualification.getId() != null) {
            manufacturerQualificationMapper.updateByPrimaryKey(manufacturerQualification);
        } else {
            manufacturerQualificationMapper.insert(manufacturerQualification);
        }
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    public Object getManufacturerQualificationInfoList(ParaData pd){
        Example example = new Example(ManufacturerQualification.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        Page<?> page = PageHelper.startPage(pd.getInteger("currentPage"), 20);
        manufacturerQualificationMapper.selectByExample(example);
        return ApiUtil.returnObject(pd, page);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    public Object getManufacturerQualificationInfo(ParaData pd) {
        Example example = new Example(ManufacturerQualification.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        criteria.andEqualTo("id", pd.getString("id"));
        ManufacturerQualification manufacturerQualification = manufacturerQualificationMapper.selectOneByExample(example);

        if (manufacturerQualification == null){
            return ApiUtil.returnDescFail(pd,"没有该数据！");
        }
        return ApiUtil.returnOK(pd,manufacturerQualification);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    @Transactional(readOnly = false)
    public Object newManufacturerQualificationInfo(ParaData pd) {
        ManufacturerQualification manufacturerQualification = pd.toAddBean(ManufacturerQualification.class);
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            manufacturerQualification.setManufacturerId(staff.getManufacturer_id());
        }
        this.manufacturerQualificationMapper.insert(manufacturerQualification);
        return ApiUtil.returnOK(pd,manufacturerQualification);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object setManufacturerQualificationInfo(ParaData pd) {
        ManufacturerQualification manufacturerQualification = pd.toUpdateBean(ManufacturerQualification.class);
        this.manufacturerQualificationMapper.updateByPrimaryKeySelective(manufacturerQualification);
        return ApiUtil.returnOK(pd,manufacturerQualification);
    }


}