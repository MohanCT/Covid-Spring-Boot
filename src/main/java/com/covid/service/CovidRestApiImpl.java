package com.covid.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
import com.covid.model.CovidContinents;
import com.covid.model.CovidCountry;
import com.covid.model.CovidCountryList;
import com.covid.model.CovidCountryListData;
import com.covid.model.CovidCountryMap;
import com.covid.model.CovidData;
import com.covid.model.CovidDayOne;
import com.covid.model.CovidDayOneList;
import com.covid.model.CovidState;
import com.covid.model.CovidTotal;
import com.covid.model.CovidVaccine;
import com.covid.model.CovidVaccineList;
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
	CovidData covidData;

	@Autowired
	CovidCountryMap covidCountryObj;

	Map<String, CovidCountryListData> covidCountryMap = new HashMap<>();

	Map<String, CovidDayOneList> covidDayOneListMap = new HashMap<>();

	Map<String, CovidVaccineList> covidVaccineListMap = new HashMap<>();
	
//    
//    @Autowired
//    CovidCountryListData covidCountryListData;
//    
//    @Autowired
//    CovidCountryList covidCountryList;
//    
//    @Autowired
//    List<CovidState> covidStateList;

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
					environment.getRequiredProperty("api.coronatracketotal"), HttpMethod.GET, Helper.getHttpEntityObj(),
					String.class);

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
				Helper.saveJsonFile(environment.getRequiredProperty(Constants.COVID_FILE) + Constants.COVID19_TOTAL,
						covidTotal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveApiCoronaTrackerCovidCountry() {
		try {
			ResponseEntity<String> response = restTemplate.exchange(
					environment.getRequiredProperty("api.coronatrackecountry"), HttpMethod.GET,
					Helper.getHttpEntityObj(), String.class);

			if (response.getStatusCode().equals(HttpStatus.OK)) {
				JSONArray jsonArray = new JSONArray(response.getBody());

				List<CovidCountry> covidCouList = new ArrayList<>();

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);

					if (!"".equals(jsonObject.optString("countryCode"))) {
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
				Helper.saveJsonFile(environment.getRequiredProperty(Constants.COVID_FILE) + Constants.COVID19_COUNTRY,
						covidCouList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveApiDiseaseShCovidTotal() {
		try {

			ResponseEntity<String> response = restTemplate.exchange(
					environment.getRequiredProperty("api.diseaseshcovidtotal"), HttpMethod.GET,
					Helper.getHttpEntityObj(), String.class);

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
				// Helper.saveJsonFile(environment.getRequiredProperty(Constants.COVID_FILE) +
				// Constants.COVID19_TOTAL, covidTotal);
				covidData.setCovidTotal(covidTotal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveApiDiseaseShCovidCountry() {
		try {
			ResponseEntity<String> response = restTemplate.exchange(
					environment.getRequiredProperty("api.diseaseshcovidcountry"), HttpMethod.GET,
					Helper.getHttpEntityObj(), String.class);

			if (response.getStatusCode().equals(HttpStatus.OK)) {
				JSONArray jsonArray = new JSONArray(response.getBody());

				List<CovidCountry> covidCouList = new ArrayList<>();

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					JSONObject countryInfo = jsonObject.getJSONObject("countryInfo");

					if (!"".equals(countryInfo.optString("iso2"))) {

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
						.sorted(Comparator.comparingInt(CovidCountry::getTotalCases).reversed())
						.collect(Collectors.toList());

				// Helper.saveJsonFile(environment.getRequiredProperty(Constants.COVID_FILE) +
				// Constants.COVID19_COUNTRY, covidCouList);
				covidData.setCovidCouList(covidCouList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveApiNarrativaCovidCountryList(String countryName) {
		try {

			if ("US".equals(countryName)) {

				ResponseEntity<String> response = restTemplate.exchange(
						"https://disease.sh/v3/covid-19/countries/us?strict=true", HttpMethod.GET,
						Helper.getHttpEntityObj(), String.class);

				if (response.getStatusCode().equals(HttpStatus.OK)) {
					JSONObject jsonObj = new JSONObject(response.getBody());

					if (Objects.nonNull(jsonObj)) {

						CovidCountryListData covidCountryListData = new CovidCountryListData();

						CovidCountryList covidCountryList = new CovidCountryList();

						List<CovidState> covidStateList = new ArrayList<>();

						covidCountryList.setCountryName(jsonObj.optString("country"));
						covidCountryList.setTotalActiveCases(jsonObj.optInt("active"));
						covidCountryList.setTotalCases(jsonObj.optInt("cases"));
						covidCountryList.setTotalDeaths(jsonObj.optInt("deaths"));
						covidCountryList.setTotalRecovered(jsonObj.optInt("recovered"));

						ResponseEntity<String> usStatesRes = restTemplate.exchange(
								"https://disease.sh/v3/covid-19/states", HttpMethod.GET, Helper.getHttpEntityObj(),
								String.class);

						if (usStatesRes.getStatusCode().equals(HttpStatus.OK)) {
							JSONArray jsonArray = new JSONArray(usStatesRes.getBody());

							if (Objects.nonNull(jsonArray)) {

								for (int i = 0; i < jsonArray.length(); i++) {
									JSONObject jsonCovidState = jsonArray.getJSONObject(i);
									CovidState covidState = new CovidState();

									covidState.setStateName(jsonCovidState.optString("state"));
									covidState.setTotalActiveCases(jsonCovidState.optInt("active"));
									covidState.setTotalCases(jsonCovidState.optInt("cases"));
									covidState.setTotalDeaths(jsonCovidState.optInt("deaths"));
									covidState.setTotalRecovered(jsonCovidState.optInt("recovered"));
									covidStateList.add(covidState);
								}

								covidStateList = covidStateList.stream()
										.sorted(Comparator.comparingInt(CovidState::getTotalCases).reversed())
										.collect(Collectors.toList());

								covidCountryList.setCovidStateList(covidStateList);
								covidCountryListData.setCountryName(covidCountryList.getCountryName());
								covidCountryListData.setCovidCountryList(covidCountryList);
								covidCountryListData.setReqIntDate(new Date());
								covidCountryMap.put(countryName, covidCountryListData);
								covidCountryObj.setCovidCountryMap(covidCountryMap);
							}

						}

					}

				}

			} else {

				ResponseEntity<String> response = restTemplate.exchange("https://api.covid19tracking.narrativa.com/api/"
						+ Helper.getCurrentDate() + "/country/" + countryName, HttpMethod.GET,
						Helper.getHttpEntityObj(), String.class);

				if (response.getStatusCode().equals(HttpStatus.OK)) {
					JSONObject jsonObj = new JSONObject(response.getBody());

					if (Objects.nonNull(jsonObj)) {

						CovidCountryListData covidCountryListData = new CovidCountryListData();

						CovidCountryList covidCountryList = new CovidCountryList();

						List<CovidState> covidStateList = new ArrayList<>();

						JSONObject countryObj = (JSONObject) jsonObj
								.optQuery("/dates/" + Helper.getCurrentDate() + "/countries/" + countryName);
						if (Objects.nonNull(countryObj)) {

							covidCountryList.setCountryName(countryObj.optString("name"));
							covidCountryList.setTotalActiveCases(countryObj.optInt("today_open_cases"));
							covidCountryList.setTotalCases(countryObj.optInt("today_confirmed"));
							covidCountryList.setTotalDeaths(countryObj.optInt("today_deaths"));
							covidCountryList.setTotalRecovered(countryObj.optInt("today_recovered"));

							JSONArray regionList = (JSONArray) jsonObj.optQuery(
									"/dates/" + Helper.getCurrentDate() + "/countries/" + countryName + "/regions");

							for (int i = 0; i < regionList.length(); i++) {
								JSONObject jsonCovidState = regionList.getJSONObject(i);
								CovidState covidState = new CovidState();

								covidState.setStateName(jsonCovidState.optString("name"));
								covidState.setTotalActiveCases(jsonCovidState.optInt("today_open_cases"));
								covidState.setTotalCases(jsonCovidState.optInt("today_confirmed"));
								covidState.setTotalDeaths(jsonCovidState.optInt("today_deaths"));
								covidState.setTotalRecovered(jsonCovidState.optInt("today_recovered"));
								covidStateList.add(covidState);
							}

							covidStateList = covidStateList.stream()
									.sorted(Comparator.comparingInt(CovidState::getTotalCases).reversed())
									.collect(Collectors.toList());

							covidCountryList.setCovidStateList(covidStateList);
							covidCountryListData.setCountryName(covidCountryList.getCountryName());
							covidCountryListData.setCovidCountryList(covidCountryList);
							covidCountryListData.setReqIntDate(new Date());
							covidCountryMap.put(countryName, covidCountryListData);
							covidCountryObj.setCovidCountryMap(covidCountryMap);

						}

					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveCovidContinents() {
		try {

			ResponseEntity<String> response = restTemplate.exchange("https://disease.sh/v3/covid-19/continents",
					HttpMethod.GET, Helper.getHttpEntityObj(), String.class);

			if (response.getStatusCode().equals(HttpStatus.OK)) {
				JSONArray jsonArray = new JSONArray(response.getBody());

				if (Objects.nonNull(jsonArray)) {

					List<CovidContinents> covidContinentsList = new ArrayList<>();

					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject jsonObject = jsonArray.getJSONObject(i);

						CovidContinents covidContinents = new CovidContinents();
						covidContinents.setContinent(jsonObject.optString("continent"));
						covidContinents.setPopulation(jsonObject.optInt("population"));
						covidContinents.setTodayCases(jsonObject.optInt("todayCases"));
						covidContinents.setTodayDeaths(jsonObject.optInt("todayDeaths"));
						covidContinents.setTodayRecovered(jsonObject.optInt("todayRecovered"));
						covidContinents.setTotalActiveCases(jsonObject.optInt("active"));
						covidContinents.setTotalCases(jsonObject.optInt("cases"));
						covidContinents.setTotalCritical(jsonObject.optInt("critical"));
						covidContinents.setTotalDeaths(jsonObject.optInt("deaths"));
						covidContinents.setTotalRecovered(jsonObject.optInt("recovered"));
						covidContinents.setTotalTests(jsonObject.optInt("tests"));
						covidContinentsList.add(covidContinents);
					}

					covidContinentsList = covidContinentsList.stream()
							.sorted(Comparator.comparingInt(CovidContinents::getTotalCases).reversed())
							.collect(Collectors.toList());

					covidData.setCovidContinents(covidContinentsList);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveCovidDayOne(String countryName) {
		try {

			ResponseEntity<String> response = restTemplate
					.exchange(
							"https://api.covid19api.com/country/" + countryName + "?from=" + Helper.getPreviousDate()
									+ "&to=" + Helper.getCurrentDate(),
							HttpMethod.GET, Helper.getHttpEntityObj(), String.class);

			if (response.getStatusCode().equals(HttpStatus.OK)) {
				JSONArray jsonArray = new JSONArray(response.getBody());

				if (Objects.nonNull(jsonArray)) {

					List<CovidDayOne> covidDayOneList = new ArrayList<>();

					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject jsonObject = jsonArray.getJSONObject(i);

						CovidDayOne covidDayOne = new CovidDayOne();
						covidDayOne.setActive(jsonObject.optInt("Active"));
						covidDayOne.setCases(jsonObject.optInt("Confirmed"));
						covidDayOne.setDate(jsonObject.optString("Date"));
						covidDayOne.setDeaths(jsonObject.optInt("Deaths"));
						covidDayOne.setRecovered(jsonObject.optInt("Recovered"));
						covidDayOneList.add(covidDayOne);
					}

					covidDayOneList = covidDayOneList.stream()
							.sorted(Comparator.comparingInt(CovidDayOne::getCases).reversed())
							.collect(Collectors.toList());
					CovidDayOneList covidDayOneObj = new CovidDayOneList();
					covidDayOneObj.setCountryName(countryName);
					covidDayOneObj.setReqIntDate(new Date());
					covidDayOneObj.setCovidDayOne(covidDayOneList);

					covidDayOneListMap.put(countryName, covidDayOneObj);
					covidData.setCovidDayOneListMap(covidDayOneListMap);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveCovidVaccine(String countryName) {
		try {
			ResponseEntity<String> response = restTemplate.exchange(
					"https://disease.sh/v3/covid-19/vaccine/coverage/countries/" + countryName + "?lastdays=30",
					HttpMethod.GET, Helper.getHttpEntityObj(), String.class);

			if (response.getStatusCode().equals(HttpStatus.OK)) {
				JSONObject jsonObject = new JSONObject(response.getBody());

				JSONObject jsonTimeLine = jsonObject.optJSONObject("timeline");

				if (Objects.nonNull(jsonTimeLine)) {
					List<CovidVaccine> covidVaccineList = new ArrayList<>();
					for (String keyStr : jsonTimeLine.keySet()) {
						CovidVaccine covidVaccine = new CovidVaccine();
						covidVaccine.setDate(keyStr);
						covidVaccine.setVaccineCount(jsonTimeLine.getInt(keyStr));
						covidVaccineList.add(covidVaccine);
					}

					covidVaccineList = covidVaccineList.stream()
							.sorted(Comparator.comparingInt(CovidVaccine::getVaccineCount).reversed())
							.collect(Collectors.toList());

					CovidVaccineList covidVaccineListData = new CovidVaccineList();
					covidVaccineListData.setCountryName(countryName);
					covidVaccineListData.setReqIntDate(new Date());
					covidVaccineListData.setCovidVaccine(covidVaccineList);

					covidVaccineListMap.put(countryName, covidVaccineListData);
					covidData.setCovidVaccineListMap(covidVaccineListMap);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveGlobalVaccine() {
		try {
			ResponseEntity<String> response = restTemplate.exchange("https://disease.sh/v3/covid-19/vaccine/coverage?lastdays=30",
					HttpMethod.GET, Helper.getHttpEntityObj(), String.class);

			if (response.getStatusCode().equals(HttpStatus.OK)) {
				JSONObject jsonObject = new JSONObject(response.getBody());

				if (Objects.nonNull(jsonObject)) {
					List<CovidVaccine> covidVaccineList = new ArrayList<>();
					for (String keyStr : jsonObject.keySet()) {
						CovidVaccine covidVaccine = new CovidVaccine();
						covidVaccine.setDate(keyStr);
						covidVaccine.setVaccineCount(jsonObject.getInt(keyStr));
						covidVaccineList.add(covidVaccine);
					}

					covidVaccineList = covidVaccineList.stream()
							.sorted(Comparator.comparingInt(CovidVaccine::getVaccineCount).reversed())
							.collect(Collectors.toList());

					CovidVaccineList covidVaccineListData = new CovidVaccineList();
					covidVaccineListData.setCountryName("");
					covidVaccineListData.setReqIntDate(new Date());
					covidVaccineListData.setCovidVaccine(covidVaccineList);
					
					covidData.setCovidVaccine(covidVaccineList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
