package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<a href='index.html'> Add new employee</a>");
		out.print("<h1>Employee Data</h1>");
		
		
		List<Employee> list = EmpDao.getAllEmployee();
		
		out.print("<table  border='1' width='100%' cellpadding='25' cellspacing='0'>");
		out.print("<tr> <th>ID</th> <th>First Name</th>  <th>Last Name</th> <th>Email</th>  <th>Password</th>  <th>Address</th>  <th>Address2</th>  <th>City</th>  <th>State</th>  <th>Edit</th>  <th>Delete</th>");
		for(Employee e : list) 
			
			{
			//out.print(e.getId()+" "+e.getFirstname()+" "+e.getLastname()+" "+e.getEmail()+" "+e.getPassword()+" "+e.getAddress()+" "+e.getAddress2()+" "+e.getCity()+" "+e.getState()+"<br>" );
			
			out.print("<tr>");
			out.print("<td>"+ e.getId()+ "</td>");
			out.print("<td>"+ e.getFirstname()+ "</td>");
			out.print("<td>"+ e.getLastname()+ "</td>");
			out.print("<td>"+ e.getEmail()+ "</td>");
			out.print("<td>"+ e.getPassword()+ "</td>");
			out.print("<td>"+ e.getAddress()+ "</td>");
			out.print("<td>"+ e.getAddress2()+ "</td>");
			out.print("<td>"+ e.getCity()+ "</td>");
			out.print("<td>"+ e.getState()+ "</td>");
			
			

			out.print("<td><a href='EditServlet?id="+e.getId()+"'> Edit</td>");
   	     	out.print("<td><a href='DeleteServlet?id="+e.getId()+"'>Delete </td>");

			out.print("</tr>");
				
			


		}
		
		out.print("</table>");
		
	}

}
