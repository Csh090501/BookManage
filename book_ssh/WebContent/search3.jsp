<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<style>
	.font1{font-size:13px;}
</style>
</head>
<body>
	<s:form action="book" method="post" theme="simple">
		<tr bgcolor="#E9EDF5" class="font1">
			<td colspan="2" style="padding-left: 50px">
				图书信息&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
				图书名称&nbsp; &nbsp;<s:textfield name="book.bookName" size="15"></s:textfield>
				&nbsp;&nbsp;&nbsp;&nbsp; 
				<s:submit value="查询" method="queryBook"/>
			</td>
		</tr>
		</s:form>
</body>
</html>