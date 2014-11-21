package com.siyang.observer;

import com.siyang.subject.Subject;

public class CurrentConditionDisplay implements Observer{
	
	private Subject weatherData;
	private float temp;
	private float humidity;
	private float pressure;
	public CurrentConditionDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(float temp, float humidity, float pressure){
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}
	
	public void display(){
		System.out.println("CurrentCondition: "+ temp+"F  "+humidity+"%  "+pressure);
	}
}
