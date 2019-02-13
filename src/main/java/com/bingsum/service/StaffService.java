/**
 * @filename:StaffServiceImpl 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.service;

import com.bingsum.annotation.Api;
import com.bingsum.util.ApiUtil;
import com.bingsum.util.MD5Util;
import com.bingsum.util.ParaData;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

import com.bingsum.model.Staff;
import com.bingsum.util.UUIDHelper;
import com.bingsum.cache.StaffCache;
import com.bingsum.mapper.StaffMapper;

/**   
 *  
 * @Description:  [暂未用到]员工表——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("staffService")
@Transactional(readOnly = true)
public class StaffService{

    @Autowired
    private StaffMapper staffMapper;
	
    public List<Staff> getAll(Staff staff) {
        if (staff.getPage() != null && staff.getRows() != null) {
            PageHelper.startPage(staff.getPage(), staff.getRows());
        }
        return staffMapper.selectAll();
    }

    public Staff getById(Integer id) {
        return staffMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        staffMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(Staff staff) {
        if (staff.getId() != null) {
            staffMapper.updateByPrimaryKey(staff);
        } else {
            staffMapper.insert(staff);
        }
    }
    
    /**
     *    登录
     * @param pd
     * @return
     */
    @Api(noAuth="true")
    @Transactional(readOnly = false)
    public Object login(ParaData pd) {
    	Staff staff = pd.toBean(Staff.class);
    	staff.enPwd();
    	
    	Example example = new Example(Staff.class);
    	Example.Criteria criteria = example.createCriteria();
    	criteria.andEqualTo("username",  staff.getUsername());
    	Staff entity = this.staffMapper.selectOneByExample(example);
    	if(entity == null) {
    		return ApiUtil.returnDescFail(pd, "用户名不存在");
    	}
    	if(entity.getStatus() != null && entity.getStatus().intValue() != 1) {
    		return ApiUtil.returnDescFail(pd, "账户状态异常，请联系管理员");
    	}
    	if(entity.getPassword() != null && (!entity.getPassword().equals(staff.getPassword()))) {
    		return ApiUtil.returnDescFail(pd, "密码错误");
    	}
    	String token = UUIDHelper.getUuid().toLowerCase();
    	entity.setToken(token);
    	entity.setResignedTime(new Date());
    	this.staffMapper.updateByPrimaryKeySelective(entity);
    	
    	return ApiUtil.returnOK(pd, token);
    }
    
    
    @Api
    @Transactional(readOnly = false)
    public Object logout(ParaData pd) {
    	Staff staff = pd.getLoginStaff();
    	StaffCache.evictByToken(pd.getToken());
    	staff.setToken("null");
    	this.staffMapper.updateByPrimaryKeySelective(staff);
    	return ApiUtil.returnOK();
    }
    


    @Api
    public Object getStaffInfoList(ParaData pd){
        Example example = new Example(Staff.class);
        Example.Criteria criteria = example.createCriteria();
        example.orderBy("createTime").desc();
        Page<?> page = PageHelper.startPage(pd.getInteger("currentPage"), 20);
        staffMapper.selectByExample(example);
        return ApiUtil.returnObject(pd, page);
    }

    @Api
    public Object getStaffInfo(ParaData pd) {
        Example example = new Example(Staff.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", pd.getString("id"));
        Staff staff = staffMapper.selectOneByExample(example);

        if (staff == null){
            return ApiUtil.returnDescFail(pd,"没有该数据！");
        }
        return ApiUtil.returnOK(pd,staff);
    }

    public Staff getStaffInfoByUname(ParaData pd) {
        Example example = new Example(Staff.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", pd.getString("username"));
        Staff staff = staffMapper.selectOneByExample(example);
        return staff;
    }

    @Api
    @Transactional(readOnly = false)
    public Object newStaffInfo(ParaData pd) {
        Staff staff = pd.toAddBean(Staff.class);
        Object uName = this.getStaffInfoByUname(pd);
        if (uName != null){
            return ApiUtil.returnDescFail(pd,"用户名已存在！");
        }else{
            this.staffMapper.insert(staff);
        }

        return ApiUtil.returnOK(pd,staff);
    }

    @Api
    @Transactional(readOnly = false)
    public Object setStaffInfo(ParaData pd) {
        Staff staff = pd.toUpdateBean(Staff.class);
        Staff uName = this.getStaffInfoByUname(pd);
        if (staff.getId()!=uName.getId() && uName != null){
            return ApiUtil.returnDescFail(pd,"用户名已存在！");
        }else{
            this.staffMapper.updateByPrimaryKeySelective(staff);
        }
        return ApiUtil.returnOK(pd,staff);
    }

    @Api
    @Transactional(readOnly = false)
    public Object setStaffPwdAll(ParaData pd) {
        Staff staff = pd.toUpdateBean(Staff.class);
        staff.enPwd();
        this.staffMapper.updateByPrimaryKeySelective(staff);
        return ApiUtil.returnOK();
    }

    @Api
    @Transactional(readOnly = false)
    public Object setStaffPwd(ParaData pd) {
        Staff staff = pd.getLoginStaff();
        String oldpwd =MD5Util.MD5Encode(pd.getString("oldpwd"), "UTF-8");
        String newpwd =MD5Util.MD5Encode(pd.getString("password"), "UTF-8");

        if (staff.getPassword().equals(oldpwd)){
            //旧密码相同
            System.out.println(pd.getLoginStaff().getPassword());
            System.out.println("oldpwd"+oldpwd);
            staff.setPassword(newpwd);
            this.staffMapper.updateByPrimaryKeySelective(staff);
            System.out.println("newpwd"+staff.getPassword());

        }else{
            System.out.println(pd.getLoginStaff().getPassword()+"旧密码不相同"+oldpwd);
            return ApiUtil.returnDescFail(pd,"旧密码不相同！");
        }
        return ApiUtil.returnOK();
    }

    @Api
    @Transactional(readOnly = false)
    public Object delStaff(ParaData pd) {
        Staff staff = pd.toDeleteBean(Staff.class);
        staff.setStatus(2);
        staffMapper.updateByPrimaryKeySelective(staff);
        return ApiUtil.returnOK(pd,staff);
    }


}