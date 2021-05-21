package com.covid.model;

import org.springframework.stereotype.Service;

@Service
public class TamilNaduHospital {
	
	private String hospitalName;
	private String hospitalLocation;
	private String hospitalAddress;
	private String hospitalMobileNo;
	private String hospitalNormalBeds;
	private String hospitalOxygenBeds;
	private String hospitalIcuBeds;
	private String hospitalTotalBeds;
	private String hospitalFacilityType;
	private String hospitalType;
	private String lastUpdatedOn;
	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalLocation() {
		return hospitalLocation;
	}
	public void setHospitalLocation(String hospitalLocation) {
		this.hospitalLocation = hospitalLocation;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	public String getHospitalMobileNo() {
		return hospitalMobileNo;
	}
	public void setHospitalMobileNo(String hospitalMobileNo) {
		this.hospitalMobileNo = hospitalMobileNo;
	}
	public String getHospitalNormalBeds() {
		return hospitalNormalBeds;
	}
	public void setHospitalNormalBeds(String hospitalNormalBeds) {
		this.hospitalNormalBeds = hospitalNormalBeds;
	}
	public String getHospitalOxygenBeds() {
		return hospitalOxygenBeds;
	}
	public void setHospitalOxygenBeds(String hospitalOxygenBeds) {
		this.hospitalOxygenBeds = hospitalOxygenBeds;
	}
	public String getHospitalIcuBeds() {
		return hospitalIcuBeds;
	}
	public void setHospitalIcuBeds(String hospitalIcuBeds) {
		this.hospitalIcuBeds = hospitalIcuBeds;
	}
	public String getHospitalTotalBeds() {
		return hospitalTotalBeds;
	}
	public void setHospitalTotalBeds(String hospitalTotalBeds) {
		this.hospitalTotalBeds = hospitalTotalBeds;
	}
	public String getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(String lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	public String getHospitalFacilityType() {
		return hospitalFacilityType;
	}
	public void setHospitalFacilityType(String hospitalFacilityType) {
		this.hospitalFacilityType = hospitalFacilityType;
	}
	public String getHospitalType() {
		return hospitalType;
	}
	public void setHospitalType(String hospitalType) {
		this.hospitalType = hospitalType;
	}
	
	

}
