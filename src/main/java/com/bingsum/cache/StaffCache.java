package com.bingsum.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bingsum.mapper.StaffMapper;
import com.bingsum.model.Staff;

import tk.mybatis.mapper.entity.Example;

@Service("staffCache")
@Transactional(readOnly = true)
public class StaffCache {
	
	@Cacheable(value="staff",  key="#token")
    public static Staff getByToken(String token, StaffMapper staffMapper) {
    	Example example = new Example(Staff.class);
    	Example.Criteria criteria = example.createCriteria();
    	criteria.andEqualTo("token",  token);
    	Staff entity = staffMapper.selectOneByExample(example);
    	return entity;
    }
	
	@CacheEvict(value="staff", key="#token")
    public static void evictByToken(String token) {
    	
    }
	
}
