package com.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Database")
public class Database extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
  
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter out=response.getWriter();
		
		response.setContentType("text/html");
			
	
	Connection con=null;	
	Statement stmt=null;
	ResultSet rs=null;

	
	try
	
	{
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
	
		
		Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		
		stmt=con.createStatement();
		
		rs=stmt.executeQuery("select * from emp");
		
	    out.println("Emp table");
		out.println("<table border='1'>");
		out.println("<tr><td>Eid</td><td>Ename</td><td>Sal</td><td>Deptno</td></tr>");
	
		while(rs.next())
		
		{
	
	out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getInt(4)+"</td></tr>");

		}
		
		out.println("</table>");
			
		out.println("</body>");
		
		out.println("</html>");
		
		con.close();
		
	}
	
catch(Exception e)
{
	System.out.println(e);
}
	
}
}
