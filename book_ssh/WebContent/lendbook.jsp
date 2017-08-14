<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<style>
	.font1{font-size:13px;}
</style>
</head>
<body bgcolor="#DCF4FE">
	<table border="1" width="599">
		<s:form action="lendBook" method="post" theme="simple">
		<tr bgcolor="#E9EDF5" class="font1">
		<s:if test="#request.readerId==null">
			<td colspan="2">
				图书信息&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
				ISBN<s:textfield name="lend.ISBN" size="15" disabled="true"></s:textfield>
				&nbsp;&nbsp;&nbsp;&nbsp; 
				<s:submit value="借书" disabled="true"/>
			</td>
		</s:if>
		<s:else>
			<td colspan="2">
				图书信息&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
				ISBN<s:textfield name="lend.ISBN" size="15"></s:textfield>
				&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="hidden" name="lend.readerId" value="<s:property value="#request.readerId"/>"/>
				<s:submit value="借书"/>
			</td>
		</s:else>
		</tr>
		</s:form>
		<tr>
			<td height="360" valign="top"><jsp:include page="lendbookinfo.jsp"/></td>
		</tr>
		<tr>
			<td align="center">
				<font color="red"><s:property value="message"/></font>
			</td>
		</tr>
		<tr bgcolor="#DCF4FE" class="font1">
			<td align="right">
				<s:set name="page" value="#request.page"></s:set>
				<a href="selectBook.action?pageNow=1&lend.readerId=<s:property value="#request.readerId"/>">首页</a>
				<s:if test="#page.hasPre">
					<a href="selectBook.action?pageNow=<s:property value="#page.pageNow-1"/>&lend.readerId=<s:property value="#request.readerId"/>">上一页</a>
				</s:if>
				<s:else>
					<a href="selectBook.action?pageNow=1&lend.readerId=<s:property value="#request.readerId"/>">上一页</a>
				</s:else>
				<s:if test="#page.hasNext">
					<a href="selectBook.action?pageNow=<s:property value="#page.pageNow+1"/>&lend.readerId=<s:property value="#request.readerId"/>">下一页</a>
				</s:if>
				<s:else>
					<a href="selectBook.action?pageNow=<s:property value="#page.totalPage"/>&lend.readerId=<s:property value="#request.readerId"/>">下一页</a>
				</s:else>
				<a href="selectBook.action?pageNow=<s:property value="#page.totalPage"/>&lend.readerId=<s:property value="#request.readerId"/>">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>