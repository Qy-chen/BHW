/**
 * @filename:UserServiceImpl 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.service;

import com.bingsum.annotation.Api;
import com.bingsum.model.Staff;
import com.bingsum.util.ApiUtil;
import com.bingsum.util.MD5Util;
import com.bingsum.util.ParaData;
import com.bingsum.util.ShareCodeUtil;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;

import java.util.List;

import com.bingsum.model.User;
import com.bingsum.mapper.UserMapper;
import tk.mybatis.mapper.entity.Example;

/**   
 *  
 * @Description:  用户表——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserService{

    @Autowired
    private UserMapper userMapper;
	
    public List<User> getAll(User user) {
        if (user.getPage() != null && user.getRows() != null) {
            PageHelper.startPage(user.getPage(), user.getRows());
        }
        return userMapper.selectAll();
    }

    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(User user) {
        if (user.getId() != null) {
            userMapper.updateByPrimaryKey(user);
        } else {
            userMapper.insert(user);
        }
    }

    @Api
    public Object getUserInfoList(ParaData pd){
        Example example = new Example(User.class);
        example.orderBy("createTime").desc();
        Page<?> page = PageHelper.startPage(pd.getInteger("currentPage"), 20);
        userMapper.selectByExample(example);
        return ApiUtil.returnObject(pd, page);
    }

    @Api(notNullPara="id")
    public Object getUserInfo(ParaData pd) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", pd.getString("id"));
        User user = userMapper.selectOneByExample(example);

        if (user == null){
            return ApiUtil.returnDescFail(pd,"没有该数据！");
        }
        return ApiUtil.returnOK(pd,user);
    }

    @Api
    @Transactional(readOnly = false)
    public Object newUserInfo(ParaData pd) {
        User user = pd.toAddBean(User.class);
        user.setPassword(MD5Util.MD5Encode(pd.getString("password"), "UTF-8"));
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            return ApiUtil.returnDescFail(pd,"没有权限！");
        }
        this.userMapper.insert(user);
        return ApiUtil.returnOK(pd,user);
    }

    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object setUserInfo(ParaData pd) {
        User user = pd.toUpdateBean(User.class);
        user.setPassword(MD5Util.MD5Encode(pd.getString("password"), "UTF-8"));
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            return ApiUtil.returnDescFail(pd,"没有权限！");
        }
        this.userMapper.updateByPrimaryKeySelective(user);
        return ApiUtil.returnOK(pd,user);
    }

    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object delUser(ParaData pd) {
        User user = pd.toDeleteBean(User.class);
        userMapper.updateByPrimaryKeySelective(user);
        return ApiUtil.returnOK(pd,user);
    }

    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object userShare(ParaData pd) {
        User user = pd.toUpdateBean(User.class);
        user.setInvitation(ShareCodeUtil.toSerialCode(pd.getInteger("id")));
        userMapper.updateByPrimaryKeySelective(user);
        return ApiUtil.returnOK(pd,user);
    }

}