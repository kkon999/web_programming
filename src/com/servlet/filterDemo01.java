package com.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/filter")
public class filterDemo01 implements Filter  {
	
	@Override // filter�� �ʱ�ȭ �� �� ����Ǵ� �޼ҵ�
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println(" --filter init()--");
		
	}
	
	@Override // filter�� ���� �۵��Ǵ� �޼ҵ�
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    System.out.println("-- filter doFilter()--");
	    
	    // request filter
	    request.setCharacterEncoding("UTF-8");
	    
	    chain.doFilter(request, response);
	    
	    // response filter
	}
		
	
	@Override // filter�� ���� �� �� ����Ǵ� �޼ҵ�
	public void destroy() {
		System.out.println(" --filter destroy()--");
	}  
   

}
