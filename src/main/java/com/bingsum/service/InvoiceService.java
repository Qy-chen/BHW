/**
 * @filename:InvoiceServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.Invoice;
import com.bingsum.mapper.InvoiceMapper;

/**   
 *  
 * @Description:  发票信息——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("invoiceService")
@Transactional(readOnly = true)
public class InvoiceService{

    @Autowired
    private InvoiceMapper invoiceMapper;
	
    public List<Invoice> getAll(Invoice invoice) {
        if (invoice.getPage() != null && invoice.getRows() != null) {
            PageHelper.startPage(invoice.getPage(), invoice.getRows());
        }
        return invoiceMapper.selectAll();
    }

    public Invoice getById(Integer id) {
        return invoiceMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        invoiceMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(Invoice invoice) {
        if (invoice.getId() != null) {
            invoiceMapper.updateByPrimaryKey(invoice);
        } else {
            invoiceMapper.insert(invoice);
        }
    }
}