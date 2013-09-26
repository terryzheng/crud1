package com.crud.tool;

import java.util.Map;

import org.apache.struts2.dispatcher.ServletDispatcherResult;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class myInterceptor implements Interceptor {

	public void destroy() {
		System.out.println("Ïú»ÙInterceptor");
	}

	public void init() {
		System.out.println("³õÊ¼»¯Interceptor");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println(invocation.getAction().getClass().getName());
		System.out.println(invocation.getProxy().getMethod());
		Map<String, Object> params = invocation.getInvocationContext()
				.getParameters();
		for (String key : params.keySet()) {
			Object obj = params.get(key);

			if (obj instanceof String[]) {
				String[] arr = (String[]) obj;
				System.out.println("Param:" + key);
				for (String value : arr) {
					System.out.println(value);
				}
			}
		}
		String resultCode = invocation.invoke();
		Result rresult = invocation.getResult();
		if (rresult instanceof ServletDispatcherResult) {
			ServletDispatcherResult result = (ServletDispatcherResult) rresult;
			System.out.println("JSP:" + result.getLastFinalLocation());
		}
		return resultCode;
	}

}
