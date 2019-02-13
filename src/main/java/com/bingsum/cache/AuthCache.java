package com.bingsum.cache;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bingsum.mapper.SysRoleAuthMapper;
import com.bingsum.mapper.SysStaffRoleMapper;
import com.bingsum.util.ParaData;

@Service("authCache")
@Transactional(readOnly = true)
public class AuthCache {
	
	@Cacheable(value="staffRole",  key="#staffId")
    public static List<ParaData> getStaffRoleList(Integer staffId, SysStaffRoleMapper sysStaffRoleMapper) {
		List<ParaData> list = sysStaffRoleMapper.selectRoleListByStaff(staffId);
		return list;
    }
	
	@CacheEvict(value="staffRole", key="#staffId")
    public static void evictStaffRoleCache(Integer staffId) {
    	
    }
	
	@Cacheable(value="roleAuth",  key="#roleId")
    public static List<ParaData> getRoleAuthApi(Integer roleId, SysRoleAuthMapper sysRoleAuthMapper) {
		List<ParaData> list = sysRoleAuthMapper.selectAuthByRole(roleId);
    	return list;
    }
	
	@CacheEvict(value="roleAuth", key="#roleId")
    public static void evictRoleAuthCache(Integer roleId) {
    	
    }
	
}
