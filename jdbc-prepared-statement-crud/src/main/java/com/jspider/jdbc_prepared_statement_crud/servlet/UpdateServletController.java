package com.jspider.jdbc_prepared_statement_crud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.jspider.jdbc_prepared_statement_crud.dao.UserDao;
import com.jspider.jdbc_prepared_statement_crud.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/userUpdate")
public class UpdateServletController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do get method - update servlet controller is invoked");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		
		User user = new User(id,name,email,password,dob,gender);
		User user2 = new UserDao().updateUserById(user);

		if(user2!=null) {
			req.setAttribute("updateMsg", "Your data is updated succesfully...");
		    RequestDispatcher  rd = req.getRequestDispatcher("user-display.jsp");
		    rd.forward(req, resp);	
			
		    
		}
		
	}
	
	
}
