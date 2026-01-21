package com.jspider.jdbc_prepared_statement_crud.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.jspider.jdbc_prepared_statement_crud.dao.UserDao;
import com.jspider.jdbc_prepared_statement_crud.dto.User;

public class InsertStudentController {

	public static void main(String[] args) {
		
		UserDao userDao=new UserDao();
		User user = new User();
		Scanner sc = new Scanner(System.in);
			
		
		//taking input from the user 
		System.out.println("Enter the user id: ");
		int userId=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the user name: ");
		String userName=sc.nextLine();
		
		System.out.println("Enter the user email: ");
		String userEmail=sc.nextLine();
		
		System.out.println("Enter the user password: ");
		String userPass=sc.nextLine();
		
		System.out.println("Enter the user gender: ");
		String userGender=sc.nextLine();
		
		System.out.println("Enter user dob in YYYY-MM-DD format : ");
		String userDob = sc.nextLine();
		
		
		user.setId(userId);
		user.setName(userName);
		user.setEmail(userEmail);
		user.setPassword(userPass);
		user.setDob(LocalDate.parse(userDob));
		user.setGender(userGender);
		
		System.out.println("========================================================");
		User user2 = userDao.saveUserDao(user);
		String msg = user2!=null ? "Your data is saved" : "Your data is not saved";
		System.out.println(msg);
		System.out.println("=========================================================");
		
	}
}
