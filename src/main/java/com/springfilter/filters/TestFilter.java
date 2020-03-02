package com.springfilter.filters;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class TestFilter implements Filter {

	private String parameter;

	public void destroy() {
		System.out.println("Destroy filter...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Do Filter...");
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("TR", "Test Response");

		List<String> params = Collections.list(request.getParameterNames());

		for (String param : params) {
			if (this.parameter.equalsIgnoreCase(param)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN,
						String.format("Does not allow parameter %s", this.parameter));
				return;
			}
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Init Filter....");
		this.parameter = "test";
	}

}
