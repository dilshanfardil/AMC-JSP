package com.amc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amc.model.User;
import com.amc.util.DbUtil;

public class LoginDao {
	
	public User validateUser(String userName, String password) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		
		User user = new User();
		
		System.out.println(userName+" "+password);
		
		ResultSet rs = null;
		try {
			connection = DbUtil.getConnection();
			String sql = "SELECT user_id,role FROM users WHERE user_name = ? AND password = ?";

			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			
			int counter = 0;
			
			while(rs.next()) {
				counter++;
			}
			//System.out.println(counter);
			
			if (counter==1 ) {
				rs.previous();
				user.setUserId(rs.getString(1));
				user.setRole(rs.getString(2));
			} else {
				System.out.println("error: could not get the record counts");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return user;
	}
	
	public String getUserRole(String id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		
		String role = "";
		
		
		
		ResultSet rs = null;
		try {
			connection = DbUtil.getConnection();
			String sql = "SELECT role FROM users WHERE user_id=?";

			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, id);
			
			
			rs = pstmt.executeQuery();
			
			
			int counter = 0;
			
			while(rs.next()) {
				counter++;
			}
			//System.out.println(counter);
			
			if (counter==1 ) {
				rs.previous();
				role = rs.getString(1);
			} else {
				System.out.println("error: could not get the record counts");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return role;
	}

}
