package com.botree.business;

import com.botree.bean.Car;
import com.botree.dao.CarDao;
import com.botree.exception.CarNotFoundException;
import com.botree.exception.DuplicateCarException;

public class CarBo {

	CarDao carDao = new CarDao();
	
	public Car findCar(String brand_name) throws CarNotFoundException{
		return carDao.findCar(brand_name);
	}

	public boolean addCar(Car c) throws DuplicateCarException{
		return carDao.addCar(c);
	}
	
}
