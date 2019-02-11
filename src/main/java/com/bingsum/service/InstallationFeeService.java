/**
 * @filename:InstallationFeeServiceImpl 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;

import java.util.List;

import com.bingsum.model.InstallationFee;
import com.bingsum.mapper.InstallationFeeMapper;

/**   
 *  
 * @Description:  [暂未用到] 安装费用——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("installationFeeService")
@Transactional(readOnly = true)
public class InstallationFeeService{

    @Autowired
    private InstallationFeeMapper installationFeeMapper;
	
    public List<InstallationFee> getAll(InstallationFee installationFee) {
        if (installationFee.getPage() != null && installationFee.getRows() != null) {
            PageHelper.startPage(installationFee.getPage(), installationFee.getRows());
        }
        return installationFeeMapper.selectAll();
    }

    public InstallationFee getById(Integer id) {
        return installationFeeMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        installationFeeMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(InstallationFee installationFee) {
        if (installationFee.getId() != null) {
            installationFeeMapper.updateByPrimaryKey(installationFee);
        } else {
            installationFeeMapper.insert(installationFee);
        }
    }
}