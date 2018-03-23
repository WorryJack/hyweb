package com.emms.service.BDS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.emms.comp.BDS.LZTRAINDELCom;
import com.emms.comp.entity.bds.T_LIANGZI;
import com.haiyisoft.common.exception.ServiceExceptionUtil;
import com.haiyisoft.service.IBusinessService;
import com.haiyisoft.service.exception.SOAServiceException;

/**
 * 文件名: 编写者: XXL 编写日期: 2017-12-07 简要描述: 删除数据处理流程
 * 
 * @author xxl
 * 
 */
@Stateless(name = "LZTRAINDELService", mappedName = "LZTRAINDELService")
@Local(IBusinessService.class)
public class LZTRAINDELService implements IBusinessService {

	/** 输入输出参数常量定义 **/
	private static final String IN_PARAM_IN_XT_I_SERVICE = "IN_XT_DEL_LIANGZI";

	@Override
	public String getServiceVersion() {
		return "1.0.0";
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Map<String, Object> runService(Map<String, Object> requestParam)
			throws SOAServiceException {

		// 获得输入参数
		@SuppressWarnings("unchecked")
		List<T_LIANGZI> param1 = (List<T_LIANGZI>) requestParam
				.get(IN_PARAM_IN_XT_I_SERVICE);

		// 进行输入参数校验
		if (param1 == null) {
			throw ServiceExceptionUtil.generateSOAServiceException("输入参数不能为空。");
		}
		// 设置输出参数
		LZTRAINDELCom com = new LZTRAINDELCom();
		com.delete(param1);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		return resultMap;
	}
}