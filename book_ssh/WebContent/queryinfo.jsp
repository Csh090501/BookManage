<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
			<th>ISBN</th><th>书名</th><th>作者</th><th>出版社</th><th>价格</th><th>复本量</th><th>库存量</th><th>编辑</th><th>删除</th>
		</tr>
		<s:iterator value="#request.list" id="book">
		<tr bgcolor="FFFFFF">
			<td>${ISBN }</td>
			<td>${bookName }</td>
			<td><s:property value="#book.author"/></td>
			<td><s:property value="#book.publisher"/></td>
			<td><s:property value="#book.price"/></td>
			<td><s:property value="#book.cnum"/></td>
			<td><s:property value="#book.snum"/></td>
			<td><a href="book-edit?ISBN=${ISBN }">Edit</a></td>
			<td><a href="book-delete?ISBN=${ISBN }">Delete</a></td>
		</tr>
		</s:iterator> 
	</table> 

</body>
</html>