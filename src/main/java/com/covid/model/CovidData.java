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
	
	List<CovidVaccine> covidVaccine;
	
	private Map<String,CovidDayOneList> covidDayOneListMap= new HashMap<>();
	
	private Map<String,CovidVaccineList> covidVaccineListMap= new HashMap<>();
	
	private Map<String,TamilNaduHosList> tamilNaduHosListMap= new HashMap<>();
	
	private List<TamilNaduDisList> tamilNaduDisList;

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

	public List<CovidVaccine> getCovidVaccine() {
		return covidVaccine;
	}

	public void setCovidVaccine(List<CovidVaccine> covidVaccine) {
		this.covidVaccine = covidVaccine;
	}

	public List<TamilNaduDisList> getTamilNaduDisList() {
		return tamilNaduDisList;
	}

	public void setTamilNaduDisList(List<TamilNaduDisList> tamilNaduDisList) {
		this.tamilNaduDisList = tamilNaduDisList;
	}

	public Map<String, TamilNaduHosList> getTamilNaduHosListMap() {
		return tamilNaduHosListMap;
	}

	public void setTamilNaduHosListMap(Map<String, TamilNaduHosList> tamilNaduHosListMap) {
		this.tamilNaduHosListMap = tamilNaduHosListMap;
	}

	

}
