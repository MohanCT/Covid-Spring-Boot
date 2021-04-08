package com.covid.model;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CovidData {
	
	private CovidTotal covidTotal;
	
	List<CovidCountry> covidCouList;
	
	List<CovidContinents> covidContinents;

	public CovidTotal getCovidTotal() {
		return covidTotal;
	}

	public void setCovidTotal(CovidTotal covidTotal) {
		this.covidTotal = covidTotal;
	}

	public List<CovidCountry> getCovidCouList() {
		return covidCouList;
	}

	public void setCovidCouList(List<CovidCountry> covidCouList) {
		this.covidCouList = covidCouList;
	}

	public List<CovidContinents> getCovidContinents() {
		return covidContinents;
	}

	public void setCovidContinents(List<CovidContinents> covidContinents) {
		this.covidContinents = covidContinents;
	}
	

}
