package com.jspider.jdbc_prepared_statement_crud.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.jspider.jdbc_prepared_statement_crud.dao.UserDao;
import com.jspider.jdbc_prepared_statement_crud.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServletController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		HttpSession	httpSession=req.getSession();
		
		resp.setContentType("text/html");
		
		String email=req.getParameter("email");
		String password = req.getParameter("password");
		PrintWriter out=resp.getWriter();
		User user =new UserDao().getUserByEmail(email);
		
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				req.setAttribute("login", "Login succesfully...");
				httpSession.setAttribute("userSession" ,email);
				RequestDispatcher rd=req.getRequestDispatcher("user-display.jsp");
				rd.forward(req,resp);
			}
			else {
				req.setAttribute("passMismatch", "Password is not Correct");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			
			}
			
		}
		else {
			req.setAttribute("errorMsg", "Email doesn't exist.");
			System.out.println("email doesnt exist");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);

		}
	}
}
