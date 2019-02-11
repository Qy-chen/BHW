/**
 * @filename:PartnerServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.Partner;
import com.bingsum.mapper.PartnerMapper;

/**   
 *  
 * @Description:  [暂未用到]合作伙伴——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("partnerService")
@Transactional(readOnly = true)
public class PartnerService{

    @Autowired
    private PartnerMapper partnerMapper;
	
    public List<Partner> getAll(Partner partner) {
        if (partner.getPage() != null && partner.getRows() != null) {
            PageHelper.startPage(partner.getPage(), partner.getRows());
        }
        return partnerMapper.selectAll();
    }

    public Partner getById(Integer id) {
        return partnerMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        partnerMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(Partner partner) {
        if (partner.getId() != null) {
            partnerMapper.updateByPrimaryKey(partner);
        } else {
            partnerMapper.insert(partner);
        }
    }
}