package com.jspider.jdbc_prepared_statement_crud.controller;

import com.jspider.jdbc_prepared_statement_crud.dao.UserDao;
import com.jspider.jdbc_prepared_statement_crud.dto.User;

public class UserLoginController {

	
	public static  void main(String[] args) {
		
		UserDao userDao = new UserDao();
		
		String email="riya@gmail.com";
		String password= "riya92878";
		
		User user = userDao.getUserByEmail(email);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				System.out.println("Login succesfully");
			}
			else {
				System.out.println("check your password");
			}
		}
		else {
			System.out.println("Wrong credentials");
		}
	}
}
