<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>图书管理系统</title>
</head>
<body bgcolor="#A9DEFF">
	<table bgcolor="#A9DEFF" align="center">
		<tr>
			<td colspan="2"><jsp:include page="head1.jsp"/></td>
		</tr>
		<tr>
			<td height="400"/>
		</tr>
		<!-- 验证失败信息或错误信息在这里显示 -->
		<tr>
			<td align="center">
				<font color="red"><s:fielderror/><s:property value="message"/></font>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<font size="2">版权所有</font>
			</td>
		</tr>
	</table>
</body>
</html>
