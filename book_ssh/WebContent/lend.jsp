<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>图书管理系统</title>
	<style>
		.font1{font-size:13px;}
	</style>
</head>
<body bgcolor="#DCF4FE">
	<table bgcolor="#DCF4FE" align="center" >
		<tr>
			<td colspan="2"><jsp:include page="head.jsp"/></td>
		</tr>
		<tr>
			<td><jsp:include page="search.jsp"/></td>
			<td><jsp:include page="lendbook.jsp" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center" class="font1">
					版权所有
				</td>
			</tr>
	</table>
</body>
</html>
