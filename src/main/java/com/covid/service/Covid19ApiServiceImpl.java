package com.covid.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.covid.common.Constants;
import com.covid.common.Helper;
import com.covid.model.CovidCountry;
import com.covid.model.CovidData;
import com.covid.model.CovidTotal;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Covid19ApiServiceImpl implements CovidService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Environment environment;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	CovidRestApiImpl covidRestApiImpl;

	@Autowired
	CovidTotal covidTotal;

	@Autowired
	List<CovidCountry> covidCountry;
	
	@Autowired
	CovidData covidData;
	
	Date apiTotalDate;

	Date apiCountryDate;

	@Override
	public Map<String, Object> getTotalCovidCases() {
		Map<String, Object> responseMap = new HashMap<>();
		try {
			boolean chkApi = false;

			if (Objects.isNull(apiTotalDate) || Helper.findDifference(apiTotalDate, new Date())) {
				apiTotalDate = new Date();
				chkApi = true;
//				covidRestApiImpl.saveApiCoronaTrackerCovidTotal();
				covidRestApiImpl.saveApiDiseaseShCovidTotal();
			}

			if (chkApi || Objects.isNull(covidTotal)) {
//				covidTotal = (CovidTotal) Helper.readJsonFile("covidTotal.json");
//				covidTotal = (CovidTotal) Helper
//						.readJsonFile(environment.getRequiredProperty(Constants.COVID_FILE) + Constants.COVID19_TOTAL);
				covidTotal = covidData.getCovidTotal();
			}

			responseMap.put("covidTotal", covidTotal);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return responseMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getTotalCountryCovidCases() {
		Map<String, Object> responseMap = new HashMap<>();
		try {
			boolean chkApi = false;

			if (Objects.isNull(apiCountryDate) || Helper.findDifference(apiCountryDate, new Date())) {
				apiCountryDate = new Date();
				chkApi = true;
//				covidRestApiImpl.saveApiCoronaTrackerCovidCountry();
				covidRestApiImpl.saveApiDiseaseShCovidCountry();
			}

			if (chkApi || Objects.isNull(covidCountry)) {
//				covidCountry = (List<CovidCountry>) Helper.readJsonFile("covidCountry.json");
//				covidCountry = (List<CovidCountry>) Helper.readJsonFile(
//						environment.getRequiredProperty(Constants.COVID_FILE) + Constants.COVID19_COUNTRY);
				covidCountry = covidData.getCovidCouList();
			}

			responseMap.put("covidCountry", covidCountry);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return responseMap;
	}

//	public Map<String, Object> getTotalCovidCases1() {
//		Map<String, Object> responseMap = new HashMap<>();
//
//		try {
//			boolean chkApi = false;
//			
////			covidRestApiImpl.saveApiCoronaTrackerCom();
//			
//			if(Objects.isNull(apiDate) || Helper.findDifference(apiDate, new Date())) {
//				apiDate = new Date();
//				chkApi = true;
//				covidCountryList = new ArrayList<>();
//				covidTotalMap = new HashMap<>();
//				covidRestApiImpl.saveCovidApiSummary();
//			}
//
//			if (chkApi || covidCountryList.isEmpty()) {
//				covidCountryList = new ArrayList<>();
//				covidTotalMap = new HashMap<>();
//				String fileData = Files.readString(Paths.get(
//						environment.getRequiredProperty(Constants.COVID_FILE) + Constants.COVID19API_SUMMARY_FILENAME));
//				JSONObject jsonData = new JSONObject(fileData);
//
//				JSONObject jsonGlobal = jsonData.getJSONObject("Global");
//				Covid19ApiTotal covidTotal = new Covid19ApiTotal();
//				covidTotal.setNewConfirmed(jsonGlobal.optInt("NewConfirmed"));
//				covidTotal.setNewDeaths(jsonGlobal.optInt("TotalDeaths"));
//				covidTotal.setNewRecovered(jsonGlobal.optInt("NewRecovered"));
//				covidTotal.setTotalCases(jsonGlobal.optInt("TotalConfirmed"));
//				covidTotal.setTotalDeath(jsonGlobal.optInt("TotalDeaths"));
//				covidTotal.setTotalRecovered(jsonGlobal.optInt("TotalRecovered"));
//
//				covidTotalMap = objectMapper.convertValue(covidTotal, new TypeReference<Map<String, String>>() {
//				});
//
//				JSONArray jsonCountry = jsonData.getJSONArray("Countries");
//				
//				for (int i = 0; i < jsonCountry.length(); i++) {
//					JSONObject jsonObj = jsonCountry.getJSONObject(i);
//					Covid19ApiCountry covidCountry = new Covid19ApiCountry();
//					covidCountry.setCountryCode(jsonObj.optString("CountryCode"));
//					covidCountry.setCountryName(jsonObj.optString("Country"));
//					covidCountry.setNewConfirmed(jsonObj.optInt("NewConfirmed"));
//					covidCountry.setNewDeaths(jsonObj.optInt("NewDeaths"));
//					covidCountry.setNewRecovered(jsonObj.optInt("NewRecovered"));
////					covidCountry.setTotalCases(NumberFormat.getNumberInstance(Locale.US).format(jsonObj.optLong("TotalConfirmed")));
//					covidCountry.setTotalCases(jsonObj.optInt("TotalConfirmed"));
//					covidCountry.setTotalDeath(jsonObj.optInt("TotalDeaths"));
//					covidCountry.setTotalRecovered(jsonObj.optInt("TotalRecovered"));
//					covidCountryList.add(covidCountry);
//				}
//				
//				covidCountryList = covidCountryList.stream()
//				        .sorted(Comparator.comparingInt(Covid19ApiCountry::getTotalCases)
//				        .reversed())
//				        .collect(Collectors.toList());
//				
//				covidTopCountryList = covidCountryList.subList(0, 10);
//			}
//
//			responseMap.put("covidTotal", covidTotalMap);
//			responseMap.put("covidCountryList", covidCountryList);
//			responseMap.put("covidTopCountryList", covidTopCountryList);
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return responseMap;
//	}

}
