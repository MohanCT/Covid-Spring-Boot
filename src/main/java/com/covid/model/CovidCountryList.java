package com.covid.model;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CovidCountryList {
	
	private String countryName;
	private int totalCases;
	private int totalRecovered;
	private int totalDeaths;
	private int totalActiveCases;
	private List<CovidState> covidStateList;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
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
	public List<CovidState> getCovidStateList() {
		return covidStateList;
	}
	public void setCovidStateList(List<CovidState> covidStateList) {
		this.covidStateList = covidStateList;
	}
	

}
