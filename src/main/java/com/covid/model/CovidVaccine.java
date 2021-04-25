package com.covid.model;

import org.springframework.stereotype.Service;

@Service
public class CovidVaccine {

	private String date;
	private int vaccineCount;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getVaccineCount() {
		return vaccineCount;
	}
	public void setVaccineCount(int vaccineCount) {
		this.vaccineCount = vaccineCount;
	}
}
