/**
 * 
 */
package com.revanwang.servlet.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jun 20, 201911:04:00 AM
 */
public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置POST编码请求参数
		req.setCharacterEncoding("UTF-8");
		//设置结果
		resp.setContentType("text/html;charset=utf-8");
		
		///1、获取请求参数
		String num1String = req.getParameter("num1");
		String opString = req.getParameter("op");
		String num2String = req.getParameter("num2");
		int result = 0;
		switch (opString) {
		case "+":
		{
			result = Integer.parseInt(num1String) + Integer.parseInt(num2String); 
		}
			break;
		case "-":
			result = Integer.parseInt(num1String) - Integer.parseInt(num2String);
			break;
		default:
			
			break;
		}
		System.out.print("结果：" + result);
		
		///2、输出页面
		PrintWriter out = resp.getWriter();
		out.print("<form action='/servletTest/calculator' method='get'>");
		out.print("<input type='number' name='num1' value='" + num1String + "'/>");
		out.print("<select name='op'>");
		out.print("<option>+</option>");
		out.print("<option>-</option>");
		out.print("<option>*</option>");
		out.print("<option>/</option>");
		out.print("</select>");
		out.print("<input type='number' name='num2' value='" + num2String + "'/>");
		out.print("<input type='submit' value=' = ' />");
		out.print("<input type='text' disabled='disabled' value='"+ result +"' />");
		out.print("</form>");
		
	}
}
