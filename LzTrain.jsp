<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/framework/include/pageset.jspa"%>
<%@ page language="java"
	import="com.haiyisoft.ep.framework.util.DropBeanUtil"%>
<script type="text/javascript" src="LzTrain.js"></script>
<html>

<head>
<title>Liangzhi</title>
<link href="<%=request.getContextPath()%>/bds/css/changea.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<hy:view>
		<s:form action="LzTrainAction">
			<hy:layoutTable>

				<hy:layoutArea title="查询条件" height="90" titleheight="35">
					<div style='margin-top: 8px; margin-left: 10px;'>

						<table class="querytable" style="width: 100%">
							<tr>
								<td align="right" width="10%">台区名称：</td>
								<td width="20%" align="left"><input type="text"
									style="width: 100%;" id="TQBHid" name="dataWrap.query.TQBHid"
									upload="true" /></td>
								<td align="right" width="10%">创建时间：</td>
								<td width="30%"><hy:date editor="datetime" id="start"
										name="dataWrap.query.lzdate_egt" upload="true"
										cssStyle="width: 100%" /></td>
								<td align="center">至</td>
								<td width="30%"><hy:date editor="datetime" id="end"
										name="dataWrap.query.lzdate_elt" upload="true"
										cssStyle="width: 100%" /></td>
							</tr>
							<tr>
								<td align="right" width="40%" colspan="6"><hy:button
										name="查询" cssClass="assist_stress" onclick="retrieve()" /> <hy:button
										name="重置" cssClass="assist_normal" onclick="onRestC()" /></td>
								<td><input type="hidden" id="inputid" value="" /></td>
							</tr>
						</table>
					</div>
				</hy:layoutArea>
				<hy:layoutArea title="台区编号" titleheight="35">
					<hy:ajaxgrid id="ajaxgrid" name="dataWrap" height="100%"
						width="100%" queryfunc="retrieve()"
						ondblclick="gridDblClick(this)">
						<hy:gridcheckbox name="checked" width="50" title="全选" />
						<hy:gridfield name="tqbs" title="台区标识" width="150" readonly="true"
							align="center" />
						<hy:gridfield name="tqmc" title="台区名称" width="280" readonly="true"
							align="center" />
						<hy:gridfield name="gddwmc" title="供电单位名称" width="150"
							readonly="true" align="center" />
						<hy:griddate name="cjsj" title="创建时间" editor="datetime"
							readonly="true" width="170" align="center" />
						<hy:gridfield name="gddwbm" title="供电单位编码" width="50"
							readonly="true" align="center" />
					</hy:ajaxgrid>
				</hy:layoutArea>
				<hy:layoutArea height="50">
					<hy:toolbar height="100%" showborder="false">
						<hy:button name="添加" onclick="add()" cssClass="assist_stress"
							colortype="primary" />
						<hy:button name="删除" onclick="deleteRecords()" colortype="danger" />
					</hy:toolbar>
				</hy:layoutArea>
			</hy:layoutTable>
		</s:form>
	</hy:view>
</body>
</html>