<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<style>
	.font1{font-size:13px;}
</style>
</head>
<body>
	<s:form action="selectBook2" method="post" theme="simple">
		<table border="1" width="200" cellspacing=1 class="font1">
			<tr bgcolor="#DCF4FE">
				<td>内容选择</td>
			</tr>
			<tr>
				<td align="left" valign="top" height="400">
					<br><B>借书证号:</B><br><br>
					<s:textfield name="lend.readerId" size="15" />
					<s:submit value="查询"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>