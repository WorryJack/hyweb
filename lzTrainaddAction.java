package com.haiyisoft.bds.datamining.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.emms.comp.entity.bds.T_LIANGZI;
import com.emms.framework.util.StringUtils;
import com.haiyisoft.bds.util.PkUtil;
import com.haiyisoft.ep.framework.ui.struts2.action.AjaxAction;
import com.haiyisoft.ep.framework.ui.struts2.model.AjaxDataWrap;
import com.haiyisoft.support.service.RemoteServiceUtil;
import com.haiyisoft.support.service.ServiceRequest;

@Namespace("/bds/datamining")
@ParentPackage("framework-default")
@Action(value = "/lzTrainaddAction", results = { @Result(name = "input", location = "/bds/datamining/lzTrainAdd.jsp")
// @Result(name = "input2", location = "/bds/datamining/lzTrainxg.jsp")
})
public class lzTrainaddAction extends AjaxAction {

	private static final long serialVersionUID = 1L;
	private AjaxDataWrap<T_LIANGZI> dataWrap = new AjaxDataWrap<T_LIANGZI>();
	private String tqmc;
	private String gddwmc;
	private String gddwbm;

	public String getTqmc() {
		return tqmc;
	}

	public void setTqmc(String tqmc) {
		this.tqmc = tqmc;
	}

	public String getGddwmc() {
		return gddwmc;
	}

	public void setGddwmc(String gddwmc) {
		this.gddwmc = gddwmc;
	}

	public String getGddwbm() {
		return gddwbm;
	}

	public void setGddwbm(String gddwbm) {
		this.gddwbm = gddwbm;
	}

	public void save() {
		Date date = new Date();
		Timestamp cjsj = new Timestamp(date.getTime());
		String tqbs = PkUtil.getPkID();


		try {
			ServiceRequest requestHty = new ServiceRequest();
			T_LIANGZI condition = new T_LIANGZI();
			if (StringUtils.isNotEmpty(tqbs)) {
				condition.setTqbs(tqbs.substring(4).trim());
			}
			if (StringUtils.isNotEmpty(tqmc)) {
				condition.setTqmc(tqmc.trim());
			}
			if (StringUtils.isNotEmpty(gddwmc)) {
				condition.setGddwmc(gddwmc.trim());
			}
			if (StringUtils.isNotEmpty(gddwbm)) {
				condition.setGddwbm(gddwbm.trim());
			}
			if (StringUtils.isNotEmpty(cjsj.toString())) {
				condition.setCjsj(cjsj);
			}
			//condition.setGddwbm("05040113");
			requestHty.addParam("IN_XT_ADD_LIANGZI", condition);
			RemoteServiceUtil.call("BDS.ZT.ADDLIANGZI", requestHty);
			responseData.setAjaxDataWrap("dataWrap", dataWrap);
			responseData.setMessage("添加成功!");

		} catch (Exception e) {
			e.printStackTrace();
			responseData.setMessage("添加失败!");
		}
	}

	@Override
	public List<String> getExtendDataWrapName() {
		List<String> dataWrapList = new ArrayList<String>();
		dataWrapList.add("dataWrap");
		return dataWrapList;
	}
	@Override
	public void retrieve() {
		List<String> dataWrapList = new ArrayList<String>();
		dataWrapList.add("dataWrap");
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
