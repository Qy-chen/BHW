/**
 * @filename:SearchBodyServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.SearchBody;
import com.bingsum.mapper.SearchBodyMapper;

/**   
 *  
 * @Description:  用户搜索内容——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("searchBodyService")
@Transactional(readOnly = true)
public class SearchBodyService{

    @Autowired
    private SearchBodyMapper searchBodyMapper;
	
    public List<SearchBody> getAll(SearchBody searchBody) {
        if (searchBody.getPage() != null && searchBody.getRows() != null) {
            PageHelper.startPage(searchBody.getPage(), searchBody.getRows());
        }
        return searchBodyMapper.selectAll();
    }

    public SearchBody getById(Integer id) {
        return searchBodyMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        searchBodyMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(SearchBody searchBody) {
        if (searchBody.getId() != null) {
            searchBodyMapper.updateByPrimaryKey(searchBody);
        } else {
            searchBodyMapper.insert(searchBody);
        }
    }
}