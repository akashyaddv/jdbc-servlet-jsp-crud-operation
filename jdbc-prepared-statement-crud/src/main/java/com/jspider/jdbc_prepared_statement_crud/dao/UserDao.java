package com.jspider.jdbc_prepared_statement_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jspider.jdbc_prepared_statement_crud.connection.UserConnection;
import com.jspider.jdbc_prepared_statement_crud.dto.User;

public class UserDao {
	Connection connection = UserConnection.getUserConnection();
	public User saveUserDao(User user) {
		
		try {
			if(connection!=null) {
				PreparedStatement ps=connection.prepareStatement("insert into student values(?,?,?,?,?,?)");
				ps.setInt(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getEmail());
				ps.setString(4, user.getPassword());
				ps.setObject(5, user.getDob());
				ps.setString(6, user.getGender());
				
				return ps.executeUpdate()>0?user:null;
				
			}
			else {
				System.out.println("no connection found");
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public User updateUserById(User user) {
		
		String updateQuery="update student set name=? ,email=?,password=?,dob =?,gender=? where id=?";
		
		try {
			if(connection!=null) {
				PreparedStatement ps=connection.prepareStatement(updateQuery);
				ps.setString(1,user.getName());
				ps.setString(2,user.getEmail());
				ps.setString(3,user.getPassword());
				ps.setObject(4,user.getDob());
				ps.setString(5,user.getGender());
				ps.setInt(6,user.getId());
				
				return ps.executeUpdate()>0?user:null;
			}
			else {
				System.out.println("Connection is not found");
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public boolean deleteUserByid(int userId) {
		
		String deleteQuery= "delete from student where id=?";
		
		try {
			if(connection!=null) {
				
				PreparedStatement ps=connection.prepareStatement(deleteQuery);
				ps.setInt(1,userId);
				
				return ps.executeUpdate()>0 ? true :false;
			}
			else {
				System.out.println("Connection is null");
				return false;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<User> getAllUserDao(){
		
		String selectQuery = "select * from student ";
		
		try {
			PreparedStatement ps=connection.prepareStatement(selectQuery);
			ResultSet rs=ps.executeQuery();
			List<User> users = new ArrayList<User>();
			
			while(rs.next()) {
				int id  = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				LocalDate dob = rs.getDate("dob").toLocalDate();
				String gender = rs.getString("gender");
				
				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setDob(dob);
				user.setGender(gender);
				
				users.add(user);
				
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
		
		
	}
	
	public User getUserByEmail(String email) {
		
		String selectQuery= "select * from student where email= ?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(selectQuery);
			ps.setString(1,email);
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				String emaildb = rs.getString("email");
				String passworddb= rs.getString("password");
				
				User user= new User();
				user.setPassword(passworddb);
				user.setEmail(emaildb);
				
				return user;
				
			}
			return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	public User getUserByIdDao(int userId) {
		String selectUserQuery = "select * from student where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(selectUserQuery);
			
			ps.setInt(1,userId);
			ResultSet set = ps.executeQuery();

			if (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				String password = set.getString("password");
				LocalDate dob = set.getDate("dob").toLocalDate();
				String gender = set.getString("gender");
				

				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setDob(dob);
				user.setGender(gender);
				
				
				
				return user;
			}
			return null;

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
}

}
