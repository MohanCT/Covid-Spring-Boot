package com.covid.model;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class CovidTotal implements Serializable {

	private static final long serialVersionUID = -5098126277177482189L;
	
	private int totalCases;
	private int totalRecovered;
	private int totalDeaths;
	private int totalActiveCases;
	private int totalNewDeaths;
	private int totalNewCases;
	private String created;
	
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
	public int getTotalNewDeaths() {
		return totalNewDeaths;
	}
	public void setTotalNewDeaths(int totalNewDeaths) {
		this.totalNewDeaths = totalNewDeaths;
	}
	public int getTotalNewCases() {
		return totalNewCases;
	}
	public void setTotalNewCases(int totalNewCases) {
		this.totalNewCases = totalNewCases;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
}
