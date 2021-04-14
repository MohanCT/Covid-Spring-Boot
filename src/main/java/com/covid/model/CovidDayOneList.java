package com.covid.model;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CovidDayOneList {
	
	private Date reqIntDate;
	private String countryName;
	private List<CovidDayOne> covidDayOne;
	
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
	public List<CovidDayOne> getCovidDayOne() {
		return covidDayOne;
	}
	public void setCovidDayOne(List<CovidDayOne> covidDayOne) {
		this.covidDayOne = covidDayOne;
	}

}
