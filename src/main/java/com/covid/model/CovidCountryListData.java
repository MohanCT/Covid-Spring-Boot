package com.covid.model;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class CovidCountryListData {
	
	private Date reqIntDate;
	private String countryName;
	private CovidCountryList covidCountryList;
	
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
	public CovidCountryList getCovidCountryList() {
		return covidCountryList;
	}
	public void setCovidCountryList(CovidCountryList covidCountryList) {
		this.covidCountryList = covidCountryList;
	}

}
