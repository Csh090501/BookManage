<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
	.font1{font-size:13px;}
</style>
</head>
<body bgcolor="#DCF4FE">
    <table  border="1" align="center" width="570" cellpadding="10" cellspacing="0" bgcolor="#71CABF" class="font1">
		<tr bgcolor="#DCF4FE">
			<th>借书证号</th><th>书名</th><th>出版社</th><th>价格</th><th>ISBN</th><th>借书时间</th>
		</tr>
		<s:iterator value="#request.list" id="lend">
		<tr bgcolor="FFFFFF">
			<td><s:property value="#lend.readerId"/></td>
			<td><s:property value="#lend.bookName"/></td>
			<td><s:property value="#lend.publisher"/></td>
			<td><s:property value="#lend.price"/></td>
			<td><s:property value="#lend.ISBN"/></td>
			<td><s:date name="#lend.lTime" format="yyyy-MM-dd"/></td>
		</tr>
		</s:iterator> 
	</table> 

</body>
</html>