package com.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InDept1")
public class InDept1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	

		PrintWriter out=response.getWriter();
		
		response.setContentType("text/html");
		
		
		
		 int N=Integer.parseInt(request.getParameter("Deptno"));

		 String Dn=request.getParameter("Dname");
		
		 String L=request.getParameter("loc");
		
		Connection con=null;
		
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		
try		{

	out.println("<!DOCTYPE>");
	out.println("<html>");
	out.println("<head>");
	out.println("<head>");
	out.println("<body>");
	
	
	Class.forName("com.mysql.jdbc.Driver");
	
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root");
		
	 pstmt=con.prepareStatement("insert into dept values(?,?,?)");

	pstmt.setInt(1,N);
	
	pstmt.setString(2,Dn); 
	  
	pstmt.setString(3,L);
	
	int i=pstmt.executeUpdate();

	out.println(i+" "+"updated values");

	
   rs=pstmt.executeQuery("select * from dept");
	
	out.println("Dept Table");
	
	out.println("<table border='1'>");
	
	out.println("<tr><td>Dptno</td><td>Dname</td><td>Loc</td></tr>");
	
	while(rs.next()) 
	{
	
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
	
		out.println("<tr><td>r"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
	}
	
	out.println("</table>");
	out.println("</body>");
	out.println("<html>");
	
	con.close();
	
}
catch(Exception e)
{
	System.out.println(e);
	
		}
		
	
	
	}

}
