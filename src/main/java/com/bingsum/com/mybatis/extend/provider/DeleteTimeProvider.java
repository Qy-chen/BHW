package com.bingsum.com.mybatis.extend.provider;

import org.apache.ibatis.mapping.MappedStatement;

import com.bingsum.com.mybatis.extend.DeleteTimeSqlHelper;
import com.bingsum.util.BeanUtils;
import com.bingsum.util.StrUtil;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;


/**
 * 
 * @ClassName: DeleteTimeProvider
 * @Description: 处理包含删除时间的查询和删除等逻辑
 * @author Liu, Wenzhao [wenzhao.liu@foxmail.com]
 * @date 2019年1月20日 上午9:00:32
 *
 */
public class DeleteTimeProvider extends MapperTemplate {

    public DeleteTimeProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 通过设置删除时间删除
     *
     * @param ms
     * @return
     */
    public String deleteWithDt(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append(" set ").append(DeleteTimeSqlHelper.deleteTimeCol(entityClass)).append("= now()");
        sql.append(SqlHelper.wherePKColumns(entityClass, true));
        return sql.toString();
    }


    /**
     * 查询全部结果
     *
     * @param ms
     * @return
     */
    public String selectAllWithDt(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        
        //修改返回值类型为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));

        // 逻辑删除的未删除查询条件
        sql.append("<where>");
        sql.append(SqlHelper.whereLogicDelete(entityClass, false));
        sql.append(" AND ").append(DeleteTimeSqlHelper.deleteTimeCol(entityClass)).append(" is null");
        sql.append("</where>");

        sql.append(SqlHelper.orderByDefault(entityClass));
        return sql.toString();
    }

    public String selectCountWithDt(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectCount(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(DeleteTimeSqlHelper.whereAllIfColumnsWithDt(entityClass, isNotEmpty()));
        return sql.toString();
    }
    
    /**
     * 查询
     *
     * @param ms
     * @return
     */
    public String selectWithDt(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        //修改返回值类型为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(DeleteTimeSqlHelper.whereAllIfColumnsWithDt(entityClass, isNotEmpty()));
        sql.append(SqlHelper.orderByDefault(entityClass));
        return sql.toString();
    }
}
