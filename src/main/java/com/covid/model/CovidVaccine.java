package com.covid.model;

import org.springframework.stereotype.Service;

@Service
public class CovidVaccine {

	private String date;
	private long vaccineCount;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getVaccineCount() {
		return vaccineCount;
	}
	public void setVaccineCount(long vaccineCount) {
		this.vaccineCount = vaccineCount;
	}
}
