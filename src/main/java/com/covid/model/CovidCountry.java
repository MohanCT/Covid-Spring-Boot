package com.covid.model;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class CovidCountry implements Serializable {
	
	private static final long serialVersionUID = 8501550443125085229L;
	private String countryName;
	private String countryCode;
	private int totalCases;
	private int totalRecovered;
	private int totalDeaths;
	private int totalActiveCases;
	private float latitude;
	private float longitude;
	private int todayCases;
	private int todayDeaths;
	private int totalCritical;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public int getTotalCases() {
		return totalCases;
	}
	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}
	public int getTotalRecovered() {
		return totalRecovered;
	}
	public void setTotalRecovered(int totalRecovered) {
		this.totalRecovered = totalRecovered;
	}
	public int getTotalDeaths() {
		return totalDeaths;
	}
	public void setTotalDeaths(int totalDeaths) {
		this.totalDeaths = totalDeaths;
	}
	public int getTotalActiveCases() {
		return totalActiveCases;
	}
	public void setTotalActiveCases(int totalActiveCases) {
		this.totalActiveCases = totalActiveCases;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public int getTodayCases() {
		return todayCases;
	}
	public void setTodayCases(int todayCases) {
		this.todayCases = todayCases;
	}
	public int getTodayDeaths() {
		return todayDeaths;
	}
	public void setTodayDeaths(int todayDeaths) {
		this.todayDeaths = todayDeaths;
	}
	public int getTotalCritical() {
		return totalCritical;
	}
	public void setTotalCritical(int totalCritical) {
		this.totalCritical = totalCritical;
	}

}
