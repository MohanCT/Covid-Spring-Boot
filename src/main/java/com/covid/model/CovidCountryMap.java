package com.covid.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CovidCountryMap {

	private Map<String,CovidCountryListData> covidCountryMap= new HashMap<>();

	public Map<String, CovidCountryListData> getCovidCountryMap() {
		return covidCountryMap;
	}

	public void setCovidCountryMap(Map<String, CovidCountryListData> covidCountryMap) {
		this.covidCountryMap = covidCountryMap;
	}
	
}
