package com.botree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.botree.bean.User;
import com.botree.constants.QueryConstants;
import com.botree.util.DBUtil;

public class LoginDao {

	public User getUser(User user) {
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		try {
			ps = conn.prepareStatement(QueryConstants.LOGIN_SQL);  
			ps.setString(0, user.username());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new User(user.username(), rs.getString("password"));  
			}
		}catch(Exception e) {
			
		}
		return u;
	}
}
