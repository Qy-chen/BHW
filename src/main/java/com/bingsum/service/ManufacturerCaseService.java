/**
 * @filename:ManufacturerCaseServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.ManufacturerCase;
import com.bingsum.mapper.ManufacturerCaseMapper;
import tk.mybatis.mapper.entity.Example;

/**   
 *  
 * @Description:  [暂未用到]工厂案例——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("manufacturerCaseService")
@Transactional(readOnly = true)
public class ManufacturerCaseService{

    @Autowired
    private ManufacturerCaseMapper manufacturerCaseMapper;
	
    public List<ManufacturerCase> getAll(ManufacturerCase manufacturerCase) {
        if (manufacturerCase.getPage() != null && manufacturerCase.getRows() != null) {
            PageHelper.startPage(manufacturerCase.getPage(), manufacturerCase.getRows());
        }
        return manufacturerCaseMapper.selectAll();
    }

    public ManufacturerCase getById(Integer id) {
        return manufacturerCaseMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        manufacturerCaseMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ManufacturerCase manufacturerCase) {
        if (manufacturerCase.getId() != null) {
            manufacturerCaseMapper.updateByPrimaryKey(manufacturerCase);
        } else {
            manufacturerCaseMapper.insert(manufacturerCase);
        }
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    public Object getManufacturerCaseInfoList(ParaData pd){
        ManufacturerCase manufacturerCase = pd.toBean(ManufacturerCase.class);
        Example example = new Example(ManufacturerCase.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        if (manufacturerCase.getStatus() != null){
            criteria.andEqualTo("status",manufacturerCase.getStatus());
        }
        example.orderBy("createTime").desc();
        Page<?> page = PageHelper.startPage(pd.getInteger("currentPage"), 20);
        manufacturerCaseMapper.selectByExample(example);
        return ApiUtil.returnObject(pd, page);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    public Object getManufacturerCaseInfo(ParaData pd) {
        Example example = new Example(ManufacturerCase.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        criteria.andEqualTo("id", pd.getString("id"));
        ManufacturerCase manufacturerCase = manufacturerCaseMapper.selectOneByExample(example);

        if (manufacturerCase == null){
            return ApiUtil.returnDescFail(pd,"没有该数据！");
        }
        return ApiUtil.returnOK(pd,manufacturerCase);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    @Transactional(readOnly = false)
    public Object newManufacturerCaseInfo(ParaData pd) {
        ManufacturerCase manufacturerCase = pd.toAddBean(ManufacturerCase.class);
        manufacturerCase.setStatus("0");
        manufacturerCase.setCreateBy(pd.getLoginStaff().getId());
        this.manufacturerCaseMapper.insert(manufacturerCase);
        return ApiUtil.returnOK(pd,manufacturerCase);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object setManufacturerCaseInfo(ParaData pd) {
        ManufacturerCase manufacturerCase = pd.toUpdateBean(ManufacturerCase.class);
        manufacturerCase.setUpdateBy(pd.getLoginStaff().getId());
        this.manufacturerCaseMapper.updateByPrimaryKeySelective(manufacturerCase);
        return ApiUtil.returnOK(pd,manufacturerCase);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object delManufacturerCase(ParaData pd) {
        ManufacturerCase manufacturerCase = pd.toDeleteBean(ManufacturerCase.class);
        manufacturerCaseMapper.updateByPrimaryKeySelective(manufacturerCase);
        return ApiUtil.returnOK(pd,manufacturerCase);
    }

}