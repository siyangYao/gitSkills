package com.siyang.subject;

import java.awt.List;
import java.util.ArrayList;

import com.siyang.observer.Observer;

public class WeatherData implements Subject{
	
	private ArrayList<Observer> list;
	private float temp, humidity, pressure;
	
	public WeatherData(){
		list = new ArrayList();
	}
	
	public void registerObserver(Observer o){
		list.add(o);
	}
	
	public void removeObserver(Observer o){
		int i = list.indexOf(o);
		if(i>=0){
			list.remove(o);
		}
	}
	
	public void notifyObserver(){
		for(int i=0; i<list.size();i++){
			list.get(i).update(temp, humidity, pressure);
		}
	}
	
	public void meassurementChanged(){
		notifyObserver();
	}
	
	public void setMeassurement(float temp, float humidity, float pressure){
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		meassurementChanged();
	}
}
