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
	<table border="1" width="900">
<%-- 		<s:form action="book" method="post" theme="simple"> --%>
<!-- 		<tr bgcolor="#E9EDF5" class="font1"> -->
<!-- 			<td colspan="2" style="padding-left: 50px"> -->
<!-- 				图书信息&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; -->
<%-- 				图书名称&nbsp; &nbsp;<s:textfield name="book.bookName" size="15"></s:textfield> --%>
<!-- 				&nbsp;&nbsp;&nbsp;&nbsp;  -->
<%-- 				<s:submit value="查询" method="queryBook"/> --%>
<!-- 			</td> -->
<!-- 		</tr> -->
<%-- 		</s:form> --%>
		<tr>
			<td height="360" valign="top"><jsp:include page="queryinfo.jsp"/></td>
		</tr>
		<tr>
			<td align="center">
				<font color="red"><s:property value="message"/></font>
			</td>
		</tr>
		<tr bgcolor="#DCF4FE" class="font1">
			<td align="right">
				<s:set name="page" value="#request.page"></s:set>
				<a href="queryBook.action?pageNow=1&book.bookName=<s:property value="#request.bookName"/>">首页</a>
				<s:if test="#page.hasPre">
					<a href="queryBook.action?pageNow=<s:property value="#page.pageNow-1"/>&book.bookName=<s:property value="#request.bookName"/>">上一页</a>
				</s:if>
				<s:else>
					<a href="queryBook.action?pageNow=1&book.bookName=<s:property value="#request.bookName"/>">上一页</a>
				</s:else>
				<s:if test="#page.hasNext">
					<a href="queryBook.action?pageNow=<s:property value="#page.pageNow+1"/>&book.bookName=<s:property value="#request.bookName"/>">下一页</a>
				</s:if>
				<s:else>
					<a href="queryBook.action?pageNow=<s:property value="#page.totalPage"/>&book.bookName=<s:property value="#request.bookName"/>">下一页</a>
				</s:else>
				<a href="queryBook.action?pageNow=<s:property value="#page.totalPage"/>&book.bookName=<s:property value="#request.bookName"/>">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>