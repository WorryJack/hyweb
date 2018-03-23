package com.emms.comp.BDS;

import java.util.List;

import com.emms.comp.entity.bds.T_LIANGZI;
import com.haiyisoft.common.exception.ServiceExceptionUtil;
import com.haiyisoft.persist.exception.DBException;
import com.haiyisoft.persist.jdbc.DBTool;

/**
 * 文件名: 编写者: 编写日期: 2017-12-07
 * 
 * 
 */
public class LZTRAINDELCom {
	public void delete(List<T_LIANGZI> deleteList) {
		DBTool tool = new DBTool();
		try {
			tool.batchDeleteEntity(deleteList);
		} catch (DBException e) {
			throw ServiceExceptionUtil.generateSOAServiceException("服务数据删除异常");
		}
	}
}