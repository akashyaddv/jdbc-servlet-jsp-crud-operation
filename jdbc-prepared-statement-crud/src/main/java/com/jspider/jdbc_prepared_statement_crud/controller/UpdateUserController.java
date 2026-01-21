package com.jspider.jdbc_prepared_statement_crud.controller;

import java.time.LocalDate;

import com.jspider.jdbc_prepared_statement_crud.dao.UserDao;
import com.jspider.jdbc_prepared_statement_crud.dto.User;

public class UpdateUserController {

	public static void main(String[] args) {
		
		UserDao  userDao=new UserDao();
		User user = new User();
	
		user.setName("vinay Gupta");
		user.setEmail("vinay@gmail.com");
		user.setPassword("vinay7839");
		user.setDob(LocalDate.parse("2025-04-12"));
		user.setGender("male");
		user.setId(12);
		
		User user2 = userDao.updateUserById(user);
		String msg = user2!=null ?"updated" :"not updated";
		System.out.println(msg);
	}
}
