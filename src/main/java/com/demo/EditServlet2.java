package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h1> Update Employee </h1>");
		
		  String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
         
		 
        
        Employee e=new Employee();  
        e.setId(id);  
        e.setFirstname(firstname);
		e.setLastname(lastname);
		e.setEmail(email);
		e.setPassword(password);
		e.setAddress(address);
		e.setAddress2(address2);
		e.setCity(city);
		e.setState(state);
         
		
              
          int status = EmpDao.update(e);
          
           if(status>0)
           {
          	   response.sendRedirect("view");
           }else
           {
          	  out.print("unable to update data");
           }
          
		

	}
}