package com.Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class page1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String N=request.getParameter("name");
	String ps=request.getParameter("password");
		
	if(N.equals("akshay kumar")&& ps.equals("12345"))
	{
		response.sendRedirect("Welcome.jsp");
		
	}
	else
	{
		response.sendRedirect("Error.jsp");
	}
	}

}
