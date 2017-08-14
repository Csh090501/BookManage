<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>图书管理系统</title>
</head>
<body >
<!--   <s:form action="login" method="post" theme="simple">
	<table>
		<caption>用户登录</caption>
		<tr>
			<td>登录名<s:textfield name="login.name" size="20"/></td>
		</tr>
		<tr>
			<td>密&nbsp;&nbsp;码<s:password name="login.password" size="21"/></td>
		</tr>
		<tr>
			<td>
				<s:submit value="登录"/>
				<s:reset value="重置"/>
			</td>
		</tr>
		
		<tr>
			<td>
				<font color="red"><s:fielderror/><s:property value="message"/></font>
			</td>
		</tr>
	</table>
</s:form> -->
<div align="center" style="padding-top: 50px;">
    <s:form action="login" method="post" theme="simple">
    <table align="center" width="719" height="488" background="images/login.png">`
        <tr height="185">
            <td colspan="4"></td>
        </tr>
        
        <tr height="10">
             <td width="40%"></td>
             <td width="10%">用户名：</td>
             <td><s:textfield name="login.name" id="userName"/></td>
             <td width="30%"></td>
        </tr>
        <tr height="10">
             <td width="40%"></td>
             <td width="10%">密     码：</td>
             <td><s:password name="login.password" id="password"/></td>     
             <td width="30%"></td>
        </tr>
        <tr height="10">
             <td width="40%"></td>
             <td width="10%"><input type="submit" value="登录"/></td>
             <td></td>
             <td width="30%"></td>
        </tr>
        <tr height="10">
             <td width="40%"></td>
             <td colspan="3">
             <font color="red"><s:fielderror/><s:property value="message"/></font>
             </td>
        </tr>
        <tr>
         <td>
         </td>
        </tr>
    </table>
    </s:form>
  </div>

</body>
</html>
