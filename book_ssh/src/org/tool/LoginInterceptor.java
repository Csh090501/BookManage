package org.tool;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dao.LoginDao;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("ssssssss");
        HttpSession session = ServletActionContext.getRequest().getSession();  
        String user = (String) session.getAttribute("User");  

        if (user != null && user.equals(new LoginDao().checkLogin2(user))) {  
            System.out.println("test");  
            return arg0.invoke();
        }  
        return "error";  
	}

}
