package com.bingsum.com.mybatis.extend;

import java.util.Set;

import com.bingsum.util.BeanUtils;
import com.bingsum.util.StrUtil;

import tk.mybatis.mapper.annotation.Version;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

public class DeleteTimeSqlHelper extends SqlHelper{

	public static String whereAllIfColumnsWithDt(Class<?> entityClass, boolean empty) {
        return whereAllIfColumnsWithDt(entityClass, empty, false);
    }
	
	/**
     * where所有列的条件，会判断是否!=null
     *
     * @param entityClass
     * @param empty
     * @param useVersion
     * @return
     */
    public static String whereAllIfColumnsWithDt(Class<?> entityClass, boolean empty, boolean useVersion) {
        StringBuilder sql = new StringBuilder();
        boolean hasLogicDelete = false;

        sql.append("<where>");
        //获取全部列
        Set<EntityColumn> columnSet = EntityHelper.getColumns(entityClass);
        EntityColumn logicDeleteColumn = SqlHelper.getLogicDeleteColumn(entityClass);
        //当某个列有主键策略时，不需要考虑他的属性是否为空，因为如果为空，一定会根据主键策略给他生成一个值
        for (EntityColumn column : columnSet) {
            if (!useVersion || !column.getEntityField().isAnnotationPresent(Version.class)) {
                // 逻辑删除，后面拼接逻辑删除字段的未删除条件
                if (logicDeleteColumn != null && logicDeleteColumn == column) {
                    hasLogicDelete = true;
                    continue;
                }
                sql.append(getIfNotNull(column, " AND " + column.getColumnEqualsHolder(), empty));
            }
        }
        if (useVersion) {
            sql.append(whereVersion(entityClass));
        }
        if (hasLogicDelete) {
            sql.append(whereLogicDelete(entityClass, false));
        }
        String deleteTimeCol = DeleteTimeSqlHelper.deleteTimeCol(entityClass);
        if(deleteTimeCol != null) {
            sql.append(" AND ").append(deleteTimeCol).append(" is null");
        }
        sql.append("</where>");
        return sql.toString();
    }

    public static String deleteTimeCol(Class<?> c) {
    	String deleteTimeProp = BeanUtils.objDeleteTimeField(c);
        if(deleteTimeProp == null) {
        	return null;
        }
        return StrUtil.toSqlName(deleteTimeProp);
    }
}

