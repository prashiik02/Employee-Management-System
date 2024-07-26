package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/save")
public class SaveServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		Employee e = new Employee();
		e.setFirstname(firstname);
		e.setLastname(lastname);
		e.setEmail(email);
		e.setPassword(password);
		e.setAddress(address);
		e.setAddress2(address2);
		e.setCity(city);
		e.setState(state);
		
		//out.print(e);
		
			int status=EmpDao.save(e);
		
		if(status>0) {
			
			request.getRequestDispatcher("index.html").include(request, response);
			out.print("<h1>Record save successfully</h1>");
		}else {
			
			out.print("<h1>Something went wrong</h1>");
		}






		
	}

}
