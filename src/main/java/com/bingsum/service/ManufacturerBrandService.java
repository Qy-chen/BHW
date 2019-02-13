/**
 * @filename:ManufacturerBrandServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.ManufacturerBrand;
import com.bingsum.mapper.ManufacturerBrandMapper;
import tk.mybatis.mapper.entity.Example;

/**   
 *  
 * @Description:  工厂旗下品牌——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("manufacturerBrandService")
@Transactional(readOnly = true)
public class ManufacturerBrandService{

    @Autowired
    private ManufacturerBrandMapper manufacturerBrandMapper;
	
    public List<ManufacturerBrand> getAll(ManufacturerBrand manufacturerBrand) {
        if (manufacturerBrand.getPage() != null && manufacturerBrand.getRows() != null) {
            PageHelper.startPage(manufacturerBrand.getPage(), manufacturerBrand.getRows());
        }
        return manufacturerBrandMapper.selectAll();
    }

    public ManufacturerBrand getById(Integer id) {
        return manufacturerBrandMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        manufacturerBrandMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ManufacturerBrand manufacturerBrand) {
        if (manufacturerBrand.getId() != null) {
            manufacturerBrandMapper.updateByPrimaryKey(manufacturerBrand);
        } else {
            manufacturerBrandMapper.insert(manufacturerBrand);
        }
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    public Object getManufacturerBrandInfoList(ParaData pd){
        Page<?> page = PageHelper.startPage(pd.getInteger("currentPage"), 20);
        Example example = new Example(ManufacturerBrand.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        example.orderBy("createTime").desc();
        manufacturerBrandMapper.selectByExample(example);
        return ApiUtil.returnObject(pd, page);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    public Object getManufacturerBrandInfo(ParaData pd) {
        Example example = new Example(ManufacturerBrand.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        criteria.andEqualTo("id", pd.getString("id"));
        ManufacturerBrand manufacturerBrand = manufacturerBrandMapper.selectOneByExample(example);

        if (manufacturerBrand == null){
            return ApiUtil.returnDescFail(pd,"没有该数据！");
        }
        return ApiUtil.returnOK(pd,manufacturerBrand);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    @Transactional(readOnly = false)
    public Object newManufacturerBrandInfo(ParaData pd) {
        ManufacturerBrand manufacturerBrand = pd.toAddBean(ManufacturerBrand.class);
        manufacturerBrand.setCreateBy(pd.getLoginStaff().getId());
        this.manufacturerBrandMapper.insert(manufacturerBrand);
        return ApiUtil.returnOK(pd,manufacturerBrand);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object setManufacturerBrandInfo(ParaData pd) {
        ManufacturerBrand manufacturerBrand = pd.toUpdateBean(ManufacturerBrand.class);
        manufacturerBrand.setUpdateBy(pd.getLoginStaff().getId());
        this.manufacturerBrandMapper.updateByPrimaryKeySelective(manufacturerBrand);
        return ApiUtil.returnOK(pd,manufacturerBrand);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object delManufacturerBrand(ParaData pd) {
        ManufacturerBrand manufacturerBrand = pd.toDeleteBean(ManufacturerBrand.class);
        manufacturerBrandMapper.updateByPrimaryKeySelective(manufacturerBrand);
        return ApiUtil.returnOK(pd,manufacturerBrand);
    }
}