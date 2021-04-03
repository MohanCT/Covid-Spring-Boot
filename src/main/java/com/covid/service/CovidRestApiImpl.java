package com.covid.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid.common.Constants;
import com.covid.common.Helper;
import com.covid.model.CovidCountry;
import com.covid.model.CovidData;
import com.covid.model.CovidTotal;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CovidRestApiImpl {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Environment environment;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@Autowired
	CovidData covidData;

	public void saveCovidApiSummary() {
		try {

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
			headers.add("X-Access-Token", "5cf9dfd5-3449-485e-b5ae-70a60e997864");
			HttpEntity<String> entity = new HttpEntity<>(headers);

			ResponseEntity<byte[]> response = restTemplate.exchange(
					environment.getRequiredProperty(Constants.COVID19API_SUMMARY), HttpMethod.GET, entity,
					byte[].class);
			Files.write(Paths
					.get(environment.getRequiredProperty(Constants.COVID_FILE) + Constants.COVID19API_SUMMARY_FILENAME),
					response.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveApiCoronaTrackerCovidTotal() {
		try {
			ResponseEntity<String> response = restTemplate.exchange(
					environment.getRequiredProperty("api.coronatracketotal"), HttpMethod.GET, Helper.getHttpEntityObj(), String.class);

			if (response.getStatusCode().equals(HttpStatus.OK)) {
				JSONObject jsonObject = new JSONObject(response.getBody());

				CovidTotal covidTotal = new CovidTotal();
				covidTotal.setTotalActiveCases(jsonObject.optInt("totalActiveCases"));
				covidTotal.setTotalCases(jsonObject.optInt("totalConfirmed"));
				covidTotal.setTotalDeaths(jsonObject.optInt("totalDeaths"));
				covidTotal.setTotalRecovered(jsonObject.optInt("totalRecovered"));
				covidTotal.setTotalNewCases(jsonObject.optInt("totalNewCases"));
				covidTotal.setTotalNewDeaths(jsonObject.optInt("totalNewDeaths"));
				covidTotal.setCreated(jsonObject.optString("created"));
				
				Helper.saveJsonFile(environment.getRequiredProperty(Constants.COVID_FILE) + Constants.COVID19_TOTAL, covidTotal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void saveApiCoronaTrackerCovidCountry() {
		try {
			ResponseEntity<String> response = restTemplate.exchange(
					environment.getRequiredProperty("api.coronatrackecountry"), HttpMethod.GET, Helper.getHttpEntityObj(), String.class);

			if (response.getStatusCode().equals(HttpStatus.OK)) {
				JSONArray jsonArray = new JSONArray(response.getBody());
				
				List<CovidCountry> covidCouList = new ArrayList<>();
				
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					
					if(!"".equals(jsonObject.optString("countryCode"))) {
						CovidCountry covidCountry = new CovidCountry();
						
						covidCountry.setTotalActiveCases(jsonObject.optInt("activeCases"));
						covidCountry.setCountryCode(jsonObject.optString("countryCode"));
						covidCountry.setCountryName(jsonObject.optString("countryName"));
						covidCountry.setLatitude(jsonObject.optFloat("lat"));
						covidCountry.setLongitude(jsonObject.optFloat("lng"));
						covidCountry.setTotalCases(jsonObject.optInt("totalConfirmed"));
						covidCountry.setTotalDeaths(jsonObject.optInt("totalDeaths"));
						covidCountry.setTotalRecovered(jsonObject.optInt("totalRecovered"));
						covidCountry.setTodayCases(jsonObject.optInt("todayCases"));
						covidCountry.setTodayDeaths(jsonObject.optInt("todayDeaths"));
						covidCountry.setTotalCritical(jsonObject.optInt("totalCritical"));
						covidCouList.add(covidCountry);
					}
				}
				
				Helper.saveJsonFile(environment.getRequiredProperty(Constants.COVID_FILE) + Constants.COVID19_COUNTRY, covidCouList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void saveApiDiseaseShCovidTotal() {
		try {
			
			ResponseEntity<String> response = restTemplate.exchange(
					environment.getRequiredProperty("api.diseaseshcovidtotal"), HttpMethod.GET, Helper.getHttpEntityObj(), String.class);

			if (response.getStatusCode().equals(HttpStatus.OK)) {
				JSONObject jsonObject = new JSONObject(response.getBody());

				CovidTotal covidTotal = new CovidTotal();
				covidTotal.setTotalActiveCases(jsonObject.optInt("active"));
				covidTotal.setTotalCases(jsonObject.optInt("cases"));
				covidTotal.setTotalDeaths(jsonObject.optInt("deaths"));
				covidTotal.setTotalRecovered(jsonObject.optInt("recovered"));
				covidTotal.setTotalNewCases(jsonObject.optInt("todayCases"));
				covidTotal.setTotalNewDeaths(jsonObject.optInt("todayDeaths"));
				covidTotal.setCreated(jsonObject.optString("updated"));
//				Helper.saveJsonFile(environment.getRequiredProperty(Constants.COVID_FILE) + Constants.COVID19_TOTAL, covidTotal);
//				Helper.saveJsonFile("covidTotal.json", covidTotal);
				covidData.setCovidTotal(covidTotal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveApiDiseaseShCovidCountry() {
		try {
			ResponseEntity<String> response = restTemplate.exchange(
					environment.getRequiredProperty("api.diseaseshcovidcountry"), HttpMethod.GET, Helper.getHttpEntityObj(), String.class);

			if (response.getStatusCode().equals(HttpStatus.OK)) {
				JSONArray jsonArray = new JSONArray(response.getBody());
				
				List<CovidCountry> covidCouList = new ArrayList<>();
				
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					JSONObject countryInfo = jsonObject.getJSONObject("countryInfo");

					if(!"".equals(countryInfo.optString("iso2"))) {
						
						CovidCountry covidCountry = new CovidCountry();
						
						covidCountry.setTotalActiveCases(jsonObject.optInt("active"));
						covidCountry.setCountryCode(countryInfo.optString("iso2"));
						covidCountry.setCountryName(jsonObject.optString("country"));
						covidCountry.setLatitude(countryInfo.optFloat("lat"));
						covidCountry.setLongitude(countryInfo.optFloat("long"));
						covidCountry.setTotalCases(jsonObject.optInt("cases"));
						covidCountry.setTotalDeaths(jsonObject.optInt("deaths"));
						covidCountry.setTotalRecovered(jsonObject.optInt("recovered"));
						covidCountry.setTodayCases(jsonObject.optInt("todayCases"));
						covidCountry.setTodayDeaths(jsonObject.optInt("todayDeaths"));
						covidCountry.setTotalCritical(jsonObject.optInt("critical"));
						covidCouList.add(covidCountry);
					}
				}
				
				covidCouList = covidCouList.stream()
				        .sorted(Comparator.comparingInt(CovidCountry::getTotalCases)
				        .reversed())
				        .collect(Collectors.toList());
//				Helper.saveJsonFile(environment.getRequiredProperty(Constants.COVID_FILE) + Constants.COVID19_COUNTRY, covidCouList);
//				Helper.saveJsonFile("covidCountry.json", covidCouList);
				covidData.setCovidCouList(covidCouList);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
