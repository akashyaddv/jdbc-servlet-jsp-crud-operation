package com.jspider.jdbc_prepared_statement_crud.servlet;

import java.io.IOException;
import java.time.LocalDate;

import com.jspider.jdbc_prepared_statement_crud.dao.UserDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteUserServletController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id =Integer.parseInt(req.getParameter("id"));
		boolean b =new  UserDao().deleteUserByid(id);
		if(b) {
			System.out.println("The user is deleted");
			req.setAttribute("deleteMsg", "Data is deleted Succesfully...");
			req.getRequestDispatcher("user-display.jsp").include(req, resp);
		}
		else {
			resp.sendRedirect("user-display.jsp");		
		}
		
	}
}
