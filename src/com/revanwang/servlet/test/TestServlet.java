/**
 * 
 */
package com.revanwang.servlet.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jun 19, 201911:12:04 AM
 */
public class TestServlet implements Servlet {

	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet初体验");
		Enumeration<String> ensEnumeration = this.config.getInitParameterNames();
		while (ensEnumeration.hasMoreElements()) {
			String key = (String) ensEnumeration.nextElement();
			String value = this.config.getInitParameter(key);
			
			System.out.println("key:" + key);
			System.out.println("value:" + value);
		}
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
