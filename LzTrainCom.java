package com.emms.comp.BDS;

import java.util.ArrayList;
import java.util.List;

import com.emms.comp.entity.bds.T_LIANGZI;
import com.emms.util.StringUtils;
import com.haiyisoft.common.exception.ServiceExceptionUtil;
import com.haiyisoft.persist.jdbc.DBTool;
import com.haiyisoft.persist.model.PageIndicator;
import com.haiyisoft.persist.model.PagedData;

/**
 * 文件名: 编写者: 编写日期: 2017-12-07
 * 
 * 
 */
public class LzTrainCom {
	public PagedData<T_LIANGZI> query(T_LIANGZI t, PageIndicator page) {
		List<Object> params = new ArrayList<Object>();
		PagedData<T_LIANGZI> data = null;
		DBTool tool = new DBTool();
		try {
			StringBuffer sql = new StringBuffer(
					"SELECT * FROM LIANGZI WHERE 1 = 1 ");
			if (StringUtils.isNotEmpty(t.getTqmc())) {
				sql.append(" AND TQMC LIKE '%" + t.getTqmc() + "%' ");
			}

			if (StringUtils.isNotEmpty(t.getJd())) {
				sql.append(" AND CJSJ >= to_date(?,'yyyy-mm-dd,hh24:mi:ss')");
				params.add(t.getJd());
			}
			if (StringUtils.isNotEmpty(t.getWd())) {
				sql.append(" AND CJSJ <= to_date(?,'yyyy-mm-dd,hh24:mi:ss')");
				params.add(t.getWd());
			}

			data = tool.executeQuery(sql.toString(), params, T_LIANGZI.class,
					page);
		} catch (Exception e) {
			throw ServiceExceptionUtil.generateSOAServiceException(e, "查询菜单异常");
		}
		return data;
	}

	/*
	 * public void delete(List<T_LIANGZI> deleteList) { DBTool tool = new
	 * DBTool(); try { tool.batchDeleteEntity(deleteList); for (int i = 0; i <
	 * deleteList.size(); i++) { String slid = deleteList.get(i).getTqbh();
	 * tool.executeUpdate("DELETE FROM LIANGZI WHERE TQBH ='" + slid + "'",
	 * null); } } catch (DBException e) { throw
	 * ServiceExceptionUtil.generateSOAServiceException("服务数据删除异常"); } }
	 */
}