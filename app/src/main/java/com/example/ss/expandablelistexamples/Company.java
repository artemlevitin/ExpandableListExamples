package com.example.ss.expandablelistexamples;

import java.util.ArrayList;

public class Company 
{
	public String title;
	public int imageId;
	public ArrayList <Car> cars = new ArrayList<Car>();
	
	public Company(String title, int imageId)
	{
		this.title = title;
		this.imageId = imageId;
	}
	
	public void addCar(Car car)
	{
		cars.add(car);
	}
}
