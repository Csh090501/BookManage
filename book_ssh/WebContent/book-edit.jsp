<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<s:form action="book-update">
		
		<s:hidden name="ISBN"></s:hidden>
		
		<s:textfield name="bookName" label="书名"></s:textfield>
		<s:textfield name="author" label="作者"></s:textfield>
		<s:textfield name="publisher" label="出版社"></s:textfield>
		<s:textfield name="price" label="价格"></s:textfield>
		<s:textfield name="cnum" label="复本量"></s:textfield>
		<s:textfield name="snum" label="库存量"></s:textfield>
		<s:submit></s:submit>		
	</s:form>
	
</body>
</html>