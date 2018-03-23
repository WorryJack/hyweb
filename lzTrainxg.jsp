<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/framework/include/pageset.jspa"%>
<%@ page language="java"
	import="com.haiyisoft.ep.framework.util.DropBeanUtil"%>
<script type="text/javascript" src="lzTrainxg.js"></script>
<html>

<head>
<title>Liangzhi</title>
<%
	String tqbs= request.getParameter("tqbs").toString().trim();
	String tqmc = request.getParameter("tqmc").toString().trim();
	String gddwmc = request.getParameter("gddwmc").toString().trim();
	String gddwbm = request.getParameter("gddwbm").toString().trim();
%>
<link href="<%=request.getContextPath()%>/bds/css/changea.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<hy:view>
		<s:form action="lzTrainxgAction">
			<hy:layoutTable>
				<hy:layoutArea height="100%">
					<hy:ajaxform id="ajaxform" name="dataWrap" height="100%"
						width="100%" customlayout="true">
						<table style="width: 95%;">
							<tr>
								<td align="right" width="25%"></td>
							</tr>
							<tr>
								<td align="right" width="25%">台区标识：</td>
								<td width="30%"><input type="text" title="台区标识" id="tqbs"
									name="tqbs" required="true" maxlength="128" value=<%=tqbs %>  readonly /></td>
							</tr>
							<tr>
								<td align="right" width="25%">台区名称：</td>
								<td width="30%"><input type="text" title="台区名称" id="tqmc"
									name="tqmc" required="true" maxlength="128" value=<%=tqmc %> /></td>
							</tr>
							<tr>
								<td align="right" width="25%">供电单位名称：</td>
								<td width="30%"><input type="text" title="供电单位名称"
									id="gddwmc" name="gddwmc" required="true" maxlength="128" value=<%=gddwmc %> /></td>

							</tr>
							<tr>
								<td align="right" width="25%">供电单位编码：</td>
								<td width="30%"><input type="text" title="供电单位编码"
									id="gddwbm" name="gddwbm" required="true" maxlength="128" value=<%=gddwbm %> /></td>
							<tr></tr>
							<tr>
								
								<td align="right"><hy:button name="保存" onclick="save()"
										cssClass="assist_stress" colortype="primary" /></td>
							</tr>
						</table>
					</hy:ajaxform>
				</hy:layoutArea>
			</hy:layoutTable>
		</s:form>
	</hy:view>
</body>
</html>