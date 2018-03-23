<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/framework/include/pageset.jspa"%>
<%@ page language="java"
	import="com.haiyisoft.ep.framework.util.DropBeanUtil"%>
<script type="text/javascript" src="lzTrainAdd.js"></script>
<html>

<head>
<title>Liangzhi</title>
<link href="<%=request.getContextPath()%>/bds/css/changea.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<hy:view>
		<s:form action="lzTrainaddAction">
			<hy:layoutTable>
				<hy:layoutArea height="100%">
					<hy:ajaxform id="ajaxform" name="dataWrap" height="100%"
						width="100%" customlayout="true">
						<table style="width: 95%;">
							<tr>
							</tr>
<!-- 							<tr>
								<td align="right" width="25%">台区标识：</td>
								<td width="30%"><input type="text" title="台区标识" id="tqbs"
									name="tqbs" required="true" maxlength="128"  /></td>
							</tr> -->
							<tr>
								<td align="right" width="25%">台区名称：</td>
								<td width="30%"><input type="text" title="台区名称" id="tqmc"
									name="tqmc" required="true" maxlength="128" /></td>
							</tr>
							<tr>
								<td align="right" width="25%">供电单位名称：</td>
								<td width="30%"><input type="text" title="供电单位名称"
									id="gddwmc" name="gddwmc" required="true" maxlength="128"
									 /></td>

							</tr>
							<tr>
								<td align="right" width="25%">供电单位编码：</td>
								<td width="30%"><input type="text" title="供电单位编码"
									id="gddwbm" name="gddwbm" required="true" maxlength="128"
									 /></td>
							</tr>
							<tr>
<%-- 								<td align="right" width="25%">创建时间：</td>
								<td width="30%"><hy:date editor="datetime" id="cjsj"
										name="cjsj" upload="true"
										cssStyle="width: 70%" /></td>
							</tr> --%>

							<tr>
								<td align="right" >
								<hy:button name="保存" onclick="save()"
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