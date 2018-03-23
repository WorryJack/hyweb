package com.emms.service.BDS;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.emms.comp.BDS.LzTrainCom;
import com.emms.comp.entity.bds.T_LIANGZI;
import com.haiyisoft.common.exception.ServiceExceptionUtil;
import com.haiyisoft.persist.model.PageIndicator;
import com.haiyisoft.persist.model.PagedData;
import com.haiyisoft.service.IBusinessService;
import com.haiyisoft.service.exception.SOAServiceException;

/**
 * 文件名: 编写者: liangzhi 编写日期: 2018-03-15 简要描述: 数据处理流程管理
 * 
 * @author xxl
 * 
 */
@Stateless(name = "LZTRAINService", mappedName = "LZTRAINService")
@Local(IBusinessService.class)
public class LZTRAINService implements IBusinessService {

	/** 输入输出参数常量定义 **/
	private static final String IN_PARAM_IN_VT_QD_QDCZ = "IN_BDS_LIANGZI";
	private static final String IN_PARAM_SYS_PAGE = "SYS_PAGE";
	private static final String OUT_PARAM_OUT_VT_QD_QDCZ = "OUT_BDS_LIANGZI";
	private static final String OUT_PARAM_SYS_PAGE = "SYS_PAGE";

	@Override
	public String getServiceVersion() {
		return "1.0.0";
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Map<String, Object> runService(Map<String, Object> requestParam)
			throws SOAServiceException {

		// 获得输入参数
		T_LIANGZI param1 = (T_LIANGZI) requestParam.get(IN_PARAM_IN_VT_QD_QDCZ);
		PageIndicator param2 = (PageIndicator) requestParam
				.get(IN_PARAM_SYS_PAGE);

		// 进行输入参数校验
		if (param1 == null) {
			throw ServiceExceptionUtil.generateSOAServiceException("输入参数为空");
		}
		LzTrainCom com = new LzTrainCom();
		PagedData<T_LIANGZI> pagedata = com.query(param1, param2);
		// 设置输出参数
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(OUT_PARAM_OUT_VT_QD_QDCZ, pagedata.getData());
		resultMap.put(OUT_PARAM_SYS_PAGE, pagedata.getPager());
		return resultMap;
	}
}