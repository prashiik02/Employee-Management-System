package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.print("<h1>Update Employee</h1>");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Employee e = EmpDao.getEmployeebyID(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>First name:</td> <td><input type='text' name='firstname' value='"+e.getFirstname()+"'/></td></tr>");
		out.print("<tr><td>Last name:</td> <td><input type='text' name='lastname' value='"+e.getLastname()+"'/></td></tr>");
		out.print("<tr><td>Email:</td> <td><input type='text' name='email' value='"+e.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Password:</td> <td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Address:</td> <td><input type='text' name='address' value='"+e.getAddress()+"'/></td></tr>");
		out.print("<tr><td>Address2:</td> <td><input type='text' name='address2' value='"+e.getAddress2()+"'/></td></tr>");
		out.print("<tr><td>Address:</td> <td><input type='text' name='address' value='"+e.getAddress()+"'/></td></tr>");
		out.print("<tr><td>City:</td> <td><input type='text' name='city' value='"+e.getCity()+"'/></td></tr>");
		out.print("<tr><td>State:</td> <td><input type='text' name='state' value='"+e.getState()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
		out.print("</table>");  
        out.print("</form>"); 
  
		
		
		
	}
}
