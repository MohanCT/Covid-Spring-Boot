package com.covid.model;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TamilNaduHosList {

	private Date reqIntDate;
	private List<TamilNaduHospital> tamilNaduHospital;
	
	public Date getReqIntDate() {
		return reqIntDate;
	}
	public void setReqIntDate(Date reqIntDate) {
		this.reqIntDate = reqIntDate;
	}
	public List<TamilNaduHospital> getTamilNaduHospital() {
		return tamilNaduHospital;
	}
	public void setTamilNaduHospital(List<TamilNaduHospital> tamilNaduHospital) {
		this.tamilNaduHospital = tamilNaduHospital;
	}
	
}
