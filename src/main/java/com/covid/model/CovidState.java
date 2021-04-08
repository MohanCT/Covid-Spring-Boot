package com.covid.model;

import org.springframework.stereotype.Service;

@Service
public class CovidState {
	
	private String stateName;
	private int totalCases;
	private int totalRecovered;
	private int totalDeaths;
	private int totalActiveCases;
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
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

}
