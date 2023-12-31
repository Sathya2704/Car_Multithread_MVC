package com.botree.controller;

import java.util.Scanner;

import com.botree.bean.Car;
import com.botree.bean.User;
import com.botree.business.CarBo;
import com.botree.business.LoginBo;
import com.botree.exception.DuplicateCarException;
import com.botree.exception.InvalidUserException;

public class Main {

	public static void main(String[] args) {
		
		boolean flag = true;
		
		do {
			var user = login();
			
			var loginBo = new LoginBo();
			
			try {
				flag = !loginBo.validateUser(user);
			}catch(InvalidUserException e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
		
		
		do {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Search Car \n 2. Add Car");
		int n = sc.nextInt();
		
		if(n==1) {
			searchCar();
		}
		else {
			addCar();
		}
		
	}while(true);
	}
	
	public static void searchCar() {
		new Thread(()->{
			
	        System.err.println("Find Page");

			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter isbn : ");
			String brand_name = sc.next();
			
			var carBo = new CarBo();
			try {
			System.out.println(carBo.findCar(brand_name));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}).start();
	}
	
	public static void addCar() {
		new Thread(()->{
			System.err.println("Add Page");

			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter customer name : ");
			String cname = sc.next();
					
			System.out.println("Enter mobile number : ");
			String mobileno = sc.next();
			
			System.out.println("Enter the gender : ");
			String gender = sc.next();
			
			System.out.println("Enter the city : ");
			String city = sc.next();
			
			System.out.println("Enter the Budget : ");
			int budget = sc.nextInt();
			
			System.out.println("Enter the Brand Name : ");
			String brand_name = sc.next();
			
			System.out.println("Enter the Model Name : ");
			String model_name = sc.next();
			
			System.out.println("Enter the price : ");
			int price = sc.nextInt();
			
			System.out.println("Enter the fuel : ");
			String fuel = sc.next();
			
			System.out.println("Enter the mileage : ");
			int mileage = sc.nextInt();
			
			System.out.println("Enter the seating capacity : ");
			int capacity = sc.nextInt();
			
			var c = new Car(cname, mobileno, gender, city, budget, brand_name, model_name, price, fuel, mileage, capacity);

			var cBo = new CarBo();

			try {
				cBo.addCar(c);
				System.out.println(cname + "registered successfully");

			} catch (DuplicateCarException e) {
				System.out.println(e.getMessage());
			}
		}).start();
	}
	
	public static User login() {
		System.err.println("Login Page");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username : ");
		String name = sc.next();
		
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		return new User(name, password);
	}
}
