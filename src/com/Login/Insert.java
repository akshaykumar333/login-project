package com.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		PrintWriter out=response.getWriter();
		
		response.setContentType("text/html");
		
		
 int E=Integer.parseInt(request.getParameter("Eid"));

// String N=request.getParameter("ename");

 int S=Integer.parseInt(request.getParameter("Sal"));

 int D=Integer.parseInt(request.getParameter("Dptno"));

		
		try 
		{
			
			
			out.println("<!DOCTYPE>");
			out.println("<html>");
			out.println("<head>");
			out.println("<head>");
			out.println("<body>");
			
			
			
	Class.forName("com.mysql.jdbc.Driver");
		
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root");
		
	PreparedStatement stmt=con.prepareStatement("insert into emp values(?,?,?,?)");

	stmt.setInt(1,E);
	stmt.setString(2,request.getParameter("ename")); 
	  
	stmt.setInt(3,S);
	stmt.setInt(4,D);
	
	int i=stmt.executeUpdate();
	out.println(i+" "+"updated values");

	
ResultSet rs=stmt.executeQuery("select * from emp");
	
out.println("<table border='1'>");
out.println("<tr><td>Eid</td> <td>Ename</td> <td>Sal</td><td>Deptno</td></tr>");

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
