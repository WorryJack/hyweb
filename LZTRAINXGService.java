package com.emms.service.BDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.emms.comp.BDS.LZTRAINXGCom;
import com.emms.comp.entity.bds.T_LIANGZI;
import com.haiyisoft.common.exception.ServiceExceptionUtil;
import com.haiyisoft.service.IBusinessService;
import com.haiyisoft.service.exception.SOAServiceException;

/**
 * 文件名: 编写者: REAZZZ 编写日期: 2017-04-01 简要描述: ZEMKOA
 * 
 * 组件列表:
 * 
 * ******************** 修改日志 ********************************** 修改人： 修改日期： 修改内容：
 * 
 */
@Stateless(name = "LZTRAINXGService", mappedName = "LZTRAINXGService")
@Local(IBusinessService.class)
public class LZTRAINXGService implements IBusinessService {

	/** 输入输出参数常量定义 **/
	private static final String IN_PARAM_IN_VT_QD_QDCZ = "IN_XT_XG_LIANGZI";
	@Override
	public String getServiceVersion() {
		return "1.0.0";
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Map<String, Object> runService(Map<String, Object> requestParam)
			throws SOAServiceException {

		// 获得输入参数
		T_LIANGZI param1 = (T_LIANGZI) requestParam
				.get(IN_PARAM_IN_VT_QD_QDCZ);

		// 进行输入参数校验
		if (param1 == null) {
			throw ServiceExceptionUtil.generateSOAServiceException("输入参数为空");
		}
		LZTRAINXGCom com = new LZTRAINXGCom();
		List<T_LIANGZI> list = new ArrayList<T_LIANGZI>();
		list.add(param1);
		com.update(list);
		// 设置输出参数
		Map<String, Object> resultMap = new HashMap<String, Object>();
		return resultMap;
	}
}