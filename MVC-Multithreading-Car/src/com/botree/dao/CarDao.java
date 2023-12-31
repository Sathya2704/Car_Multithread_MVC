package com.botree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.botree.bean.Car;
import com.botree.constants.QueryConstants;
import com.botree.exception.CarNotFoundException;
import com.botree.exception.DuplicateCarException;
import com.botree.util.DBUtil;

public class CarDao {

	public Car findCar(String brand_name)throws CarNotFoundException{
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(QueryConstants.SEARCH_SQL);
			ps.setString(1, brand_name);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			
			return new Car(rs.getString("cname"), rs.getString("mobileno"), rs.getString("Gender"), rs.getString("city"), rs.getInt("budget"), rs.getString("brand_name"), rs.getString("model_name"), rs.getInt("price"), rs.getString("fuel"), rs.getInt("mileage"), rs.getInt("capacity"));   
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		throw new CarNotFoundException(brand_name+" not found");
	}
	
	public boolean addCar(Car c) throws DuplicateCarException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(QueryConstants.INSERT_SQL);
			ps.setString(1, c.cname());
			ps.setString(2, c.mobileno());
			ps.setString(3, c.gender());
			ps.setString(4, c.city());
			ps.setInt(5, c.budget());
			ps.setString(6, c.brand_name());
			ps.setString(7, c.model_name());
			ps.setInt(8, c.price());
			ps.setString(9, c.fuel());
			ps.setInt(10, c.mileage());
			ps.setInt(11, c.capacity());

			ps.execute();
			
			return true;

		}catch(Exception e) {
			e.printStackTrace();
			throw new DuplicateCarException(" already exist");
		}
	}
}
