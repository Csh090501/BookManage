<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>图书管理系统</title>
<style>
	.font1{font-size:13px;}
</style>
<script language="javascript">
function check(thisObject){
	var sTmp="";
	sTmp=thisObject.value;
	if(isNaN(sTmp)){
		alert("请输入数字");
		thisObject.select();
	}
}
</script>
</head>
<body bgcolor="#DCF4FE">
	<table bgcolor=#DCF4FE align="center" class="font1">
		<tr>
			<td colspan="2"><jsp:include page="head.jsp"/></td>
		</tr>
		<tr>
			<s:form theme="simple" action="book" method="post" enctype="multipart/form-data" validate="true">
			<td><jsp:include page="funcselect.jsp"/></td>
			<td><jsp:include page="bookinfo.jsp"/></td>
			</s:form>
		</tr>
		<tr>
			<td colspan="2" align="center">
				版权所有
			</td>
		</tr>
	</table>
</body>
</html>
