package com.siyang.observer;

import com.siyang.subject.Subject;

public class StatisticsDisplay implements Observer{
	
	private int num = 0;
	private float maxTemp = 0;
	private float minTemp = 300;
	private float sumTemp=0;
	
	public StatisticsDisplay(Subject weatherData){
		weatherData.registerObserver(this);
	}
	
	public void update(float temp, float humidity, float pressure){
		sumTemp+=temp;
		num++;
		if(temp > maxTemp){
			maxTemp = temp;
		}
		if(temp<= minTemp){
			minTemp = temp;
		}
		
		display();
	}
	
	public void display(){
		System.out.println("Statistics: Ave="+sumTemp/num+";  "+"MaxTemp="+maxTemp+";  "+"MinTemp="+minTemp+";");
	}
}
