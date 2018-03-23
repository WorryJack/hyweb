package com.emms.comp.BDS;

import java.util.List;

import com.emms.comp.entity.bds.T_LIANGZI;
import com.haiyisoft.common.exception.ServiceExceptionUtil;
import com.haiyisoft.persist.jdbc.DBTool;

/**
 * 文件名: 编写者: 编写日期: 2017-12-07
 * 
 */
public class LZTRAINXGCom {
	public void update(List<T_LIANGZI> updateList) {
		DBTool tool = new DBTool();
		try {
			tool.batchUpdateEntity(updateList);
		} catch (Exception e) {
			throw ServiceExceptionUtil.generateSOAServiceException(e, "查询菜单异常");
		}
	}
}