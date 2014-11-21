package com.siyang.main;

import com.siyang.observer.CurrentConditionDisplay;
import com.siyang.observer.StatisticsDisplay;
import com.siyang.subject.WeatherData;

public class WeatherStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData weatherData = new WeatherData();
		CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		
		weatherData.setMeassurement(80, 78, 70);
		weatherData.setMeassurement(82, 45, 69);
		weatherData.setMeassurement(75, 50, 45);
	}

}
