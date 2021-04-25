package com.covid.model;

import java.util.Date;
import java.util.List;

public class CovidVaccineList {

	private Date reqIntDate;
	private String countryName;
	private List<CovidVaccine> covidVaccine;
	
	public Date getReqIntDate() {
		return reqIntDate;
	}
	public void setReqIntDate(Date reqIntDate) {
		this.reqIntDate = reqIntDate;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public List<CovidVaccine> getCovidVaccine() {
		return covidVaccine;
	}
	public void setCovidVaccine(List<CovidVaccine> covidVaccine) {
		this.covidVaccine = covidVaccine;
	}
	
}
