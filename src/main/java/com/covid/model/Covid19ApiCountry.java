package com.covid.model;

import org.springframework.stereotype.Service;

@Service
public class Covid19ApiCountry {

	private String countryName;
	private String countryCode;
	private int totalCases;
	private int totalRecovered;
	private int totalDeath;
	private int newConfirmed;
	private int newDeaths;
	private int newRecovered;

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

	public int getTotalDeath() {
		return totalDeath;
	}

	public void setTotalDeath(int totalDeath) {
		this.totalDeath = totalDeath;
	}

	public int getNewConfirmed() {
		return newConfirmed;
	}

	public void setNewConfirmed(int newConfirmed) {
		this.newConfirmed = newConfirmed;
	}

	public int getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(int newDeaths) {
		this.newDeaths = newDeaths;
	}

	public int getNewRecovered() {
		return newRecovered;
	}

	public void setNewRecovered(int newRecovered) {
		this.newRecovered = newRecovered;
	}

}
