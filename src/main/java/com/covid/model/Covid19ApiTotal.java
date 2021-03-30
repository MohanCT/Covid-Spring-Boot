package com.covid.model;

import org.springframework.stereotype.Service;

@Service
public class Covid19ApiTotal {

	private int totalCases;
	private int totalRecovered;
	private int totalDeath;
	private int newConfirmed;
	private int newDeaths;
	private int newRecovered;

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
