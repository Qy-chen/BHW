/**
 * @filename:ManufacturerServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.Manufacturer;
import com.bingsum.mapper.ManufacturerMapper;
import tk.mybatis.mapper.entity.Example;

/**   
 *  
 * @Description:  工厂信息——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("manufacturerService")
@Transactional(readOnly = true)
public class ManufacturerService{

    @Autowired
    private ManufacturerMapper manufacturerMapper;
	
    public List<Manufacturer> getAll(Manufacturer manufacturer) {
        if (manufacturer.getPage() != null && manufacturer.getRows() != null) {
            PageHelper.startPage(manufacturer.getPage(), manufacturer.getRows());
        }
        return manufacturerMapper.selectAll();
    }

    public Manufacturer getById(Integer id) {
        return manufacturerMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        manufacturerMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(Manufacturer manufacturer) {
        if (manufacturer.getId() != null) {
            manufacturerMapper.updateByPrimaryKey(manufacturer);
        } else {
            manufacturerMapper.insert(manufacturer);
        }
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    public Object getManufacturerInfoList(ParaData pd){
        Page<?> page = PageHelper.startPage(pd.getInteger("currentPage"), 20);
        Example example = new Example(Manufacturer.class);
        Example.Criteria criteria = example.createCriteria();
        example.orderBy("createTime").desc();
        manufacturerMapper.selectByExample(example);
        return ApiUtil.returnObject(pd, page);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    public Object getManufacturerInfo(ParaData pd) {
        Example example = new Example(Manufacturer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", pd.getString("id"));
        Manufacturer manufacturer = manufacturerMapper.selectOneByExample(example);

        if (manufacturer == null){
            return ApiUtil.returnDescFail(pd,"没有该数据！");
        }
        return ApiUtil.returnOK(pd,manufacturer);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    @Transactional(readOnly = false)
    public Object newManufacturerInfo(ParaData pd) {
        Manufacturer manufacturer = pd.toAddBean(Manufacturer.class);
        manufacturer.setCreateBy(pd.getLoginStaff().getId());
        this.manufacturerMapper.insert(manufacturer);
        return ApiUtil.returnOK(pd,manufacturer);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object setManufacturerInfo(ParaData pd) {
        Manufacturer manufacturer = pd.toUpdateBean(Manufacturer.class);
        manufacturer.setUpdateBy(pd.getLoginStaff().getId());
        this.manufacturerMapper.updateByPrimaryKeySelective(manufacturer);
        return ApiUtil.returnOK(pd,manufacturer);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object delSysRole(ParaData pd) {
        Manufacturer manufacturer = pd.toDeleteBean(Manufacturer.class);
        manufacturerMapper.updateByPrimaryKeySelective(manufacturer);
        return ApiUtil.returnOK(pd,manufacturer);
    }
}