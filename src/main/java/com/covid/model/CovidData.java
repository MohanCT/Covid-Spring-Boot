package com.covid.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CovidData {
	
	private CovidTotal covidTotal;
	
	List<CovidCountry> covidCouList;
	
	List<CovidContinents> covidContinents;
	
	private Map<String,CovidDayOneList> covidDayOneListMap= new HashMap<>();
	
	private Map<String,CovidVaccineList> covidVaccineListMap= new HashMap<>();

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

	public Map<String, CovidDayOneList> getCovidDayOneListMap() {
		return covidDayOneListMap;
	}

	public void setCovidDayOneListMap(Map<String, CovidDayOneList> covidDayOneListMap) {
		this.covidDayOneListMap = covidDayOneListMap;
	}

	public Map<String, CovidVaccineList> getCovidVaccineListMap() {
		return covidVaccineListMap;
	}

	public void setCovidVaccineListMap(Map<String, CovidVaccineList> covidVaccineListMap) {
		this.covidVaccineListMap = covidVaccineListMap;
	}

	

}
