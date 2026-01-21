package com.jspider.jdbc_prepared_statement_crud.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServletController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getSession().invalidate();
		req.setAttribute("logout", "Logout Succesfully...");
		RequestDispatcher  rd= req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
	
}
