package com.jspider.jdbc_prepared_statement_crud.servlet;

import java.io.IOException;
import java.time.LocalDate;

import com.jspider.jdbc_prepared_statement_crud.dao.UserDao;
import com.jspider.jdbc_prepared_statement_crud.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertUserData extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("do get method is invoked");
		
		int id =Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String gender = req.getParameter("gender");
			
		User user = new User(id,name,email,password,dob,gender);
		System.out.println(user);
		User user2=new UserDao().saveUserDao(user);
		if(user2!=null) {
			System.out.println("Data is saved");
			req.setAttribute("savedMsg", "Sign up Succesfully");
			RequestDispatcher  rd = req.getRequestDispatcher("registration-form.jsp");
		    rd.forward(req, resp);

		}else {
			System.out.println("Data is not saved");
			RequestDispatcher  rd = req.getRequestDispatcher("registration-form.jsp");
		    rd.forward(req, resp);
		}
	}
}
