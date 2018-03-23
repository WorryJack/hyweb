package com.haiyisoft.bds.datamining.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.emms.comp.entity.bds.T_LIANGZI;
import com.emms.framework.util.StringUtils;
import com.haiyisoft.ep.common.model.PageInfo;
import com.haiyisoft.ep.framework.ui.struts2.action.AjaxAction;
import com.haiyisoft.ep.framework.ui.struts2.model.AjaxDataWrap;
import com.haiyisoft.support.service.RemoteServiceUtil;
import com.haiyisoft.support.service.ServiceRequest;
import com.haiyisoft.support.service.ServiceResponse;

@Namespace("/bds/datamining")
@ParentPackage("framework-default")
@Action(value = "/LzTrainAction", results = { @Result(name = "input", location = "/bds/datamining/LzTrain.jsp") })
public class LzTrainAction extends AjaxAction {

	private static final long serialVersionUID = 1L;
	private AjaxDataWrap<T_LIANGZI> dataWrap = new AjaxDataWrap<T_LIANGZI>();

	/**
	 * 查询操作
	 */
	@Override
	public void retrieve() {
		// 获取response
		HttpServletResponse response = ServletActionContext.getResponse();
		// 对response进行设置防止中文乱码
		response.setContentType("text/html;charset=UTF-8");

		ServiceRequest requestHty = new ServiceRequest();
		T_LIANGZI condition = new T_LIANGZI();

		String TQBHid = dataWrap.getQuery().get("TQBHid");
		// 开始时间
		String slzdatea = dataWrap.getQuery().get("lzdate_egt");
		// 结束时间
		String slzdateb = dataWrap.getQuery().get("lzdate_elt");
		if (StringUtils.isNotEmpty(TQBHid)) {
			condition.setTqmc(TQBHid.trim());
		}
		if (StringUtils.isNotEmpty(slzdatea)) {
			condition.setJd(slzdatea);
		}
		if (StringUtils.isNotEmpty(slzdateb)) {
			condition.setWd(slzdateb);
		}
		requestHty.addParam("SYS_PAGE", dataWrap.getPageInfo());
		requestHty.addParam("IN_BDS_LIANGZI", condition);
		ServiceResponse responseq = RemoteServiceUtil.call("BDS.ZT.LIANGZI",
				requestHty);

		List<T_LIANGZI> list = responseq.getEntityList("OUT_BDS_LIANGZI",
				T_LIANGZI.class);
		dataWrap.setDataList(list);
		dataWrap.setPageInfo(responseq.getEntity("SYS_PAGE", PageInfo.class));
		responseData.setAjaxDataWrap("dataWrap", dataWrap);
	}

	/**
	 * 删除操作
	 */

	public void delete() {
		try {
			ServiceRequest request = new ServiceRequest();
			List<T_LIANGZI> deleteList = dataWrap.getDataList();
			String tqbs = " ";
			if (deleteList.size() > 0) {
				for (int i = 0; i < deleteList.size(); i++) {
					tqbs = deleteList.get(i).getTqbs();
				}
				request.addParam("IN_XT_DEL_LIANGZI", deleteList);
				RemoteServiceUtil.call("BDS.ZT.DELLIANGZI", request);
				responseData.setMessage("删除成功!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseData.setMessage("删除失败!");
		}
	}

	@Override
	public List<String> getExtendDataWrapName() {
		List<String> dataWrapList = new ArrayList<String>();
		dataWrapList.add("dataWrap");
		return dataWrapList;
	}

	/**
	 * 初始化
	 */
	@Override
	protected void initTreat() {
		super.retrieveAfterInit = true;
		this.dataWrap.getPageInfo().setRowOfPage(15);
	}

	@Override
	public AjaxDataWrap<T_LIANGZI> getDataWrap() {
		return dataWrap;
	}

}