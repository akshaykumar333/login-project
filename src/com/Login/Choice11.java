package com.Login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Choice11")
public class Choice11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	   String V=request.getParameter("data");
		
	 
		
	   if (V.equals("1"))
		{
			response.sendRedirect("Database");
		}
		
		else if (V.equals("2"))
		{
			response.sendRedirect("InEmp.jsp");
		}
		
		else   if (V.equals("3"))
		 {
			response.sendRedirect("DelEmp.jsp");
		}
		

	else
	{
		response.sendRedirect("Error.jsp");
	}
	
	
	}
	}


