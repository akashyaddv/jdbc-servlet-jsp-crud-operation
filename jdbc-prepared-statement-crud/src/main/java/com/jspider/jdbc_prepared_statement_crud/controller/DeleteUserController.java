package com.jspider.jdbc_prepared_statement_crud.controller;

import java.util.Scanner;

import com.jspider.jdbc_prepared_statement_crud.dao.UserDao;
import com.jspider.jdbc_prepared_statement_crud.dto.User;

public class DeleteUserController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the user id : ");
		int userId= sc.nextInt();
		UserDao userDao = new UserDao();
		
		boolean result = userDao.deleteUserByid(userId);
		if(result) {
			System.out.println("deleted");
		}
		else {
			System.out.println("id is incorrect --- Not deleted");
		}
	}
}
