package com.interceptor;

import java.util.Date;

import com.controller.TestStruts;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class DateInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		TestStruts action = (TestStruts) arg0.getAction();
		action.setDate(new Date());
		return arg0.invoke();
	}

}
