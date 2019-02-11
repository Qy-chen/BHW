package com.bingsum.com.mybatis.extend;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.bingsum.com.mybatis.extend.provider.DeleteTimeProvider;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;
import tk.mybatis.mapper.provider.base.BaseUpdateProvider;


@RegisterMapper
public interface DeleteTimeMapper<T> {

    
	/**
	 * 
	 * @Title: deleteWithDt 
	 * @Description: 通过设置删除时间来进行删除，非物理删除
	 * @date 2019年1月20日 上午8:59:58
	 * @author Liu,Wenzhao [wenzhao.liu@foxmail.com]
	 * @param record
	 * @return  int
	 */
    @UpdateProvider(type = DeleteTimeProvider.class, method = "dynamicSQL")
    int deleteWithDt(T record);
    
    /**
     * 查询删除时间为空的全部结果
     *
     * @return
     */
    @SelectProvider(type = DeleteTimeProvider.class, method = "dynamicSQL")
    List<T> selectAllWithDt();

    /**
     * 
     * @Title: selectCountWithDt 
     * @Description: 查询删除时间为空的查询结果条数
     * @date 2019年1月20日 上午9:54:47
     * @author Liu,Wenzhao [wenzhao.liu@foxmail.com]
     * @param record
     * @return  int
     */
    @SelectProvider(type = DeleteTimeProvider.class, method = "dynamicSQL")
    int selectCountWithDt(T record);
    
    @SelectProvider(type = DeleteTimeProvider.class, method = "dynamicSQL")
    List<T> selectWithDt(T record);
}