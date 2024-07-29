package com.demo;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{

	
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
			
			String sid=req.getParameter("id");  
		       int id=Integer.parseInt(sid);
		       EmpDao.delete(id);  
		        
	        	  res.sendRedirect("view");  
			
		}
}
