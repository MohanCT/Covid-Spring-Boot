package com.covid.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class Helper {

	public static boolean findDifference(Date startDate, Date endDate) {
		boolean chkMin = false;
		try {
			long differenceInTime = endDate.getTime() - startDate.getTime();
			
			long differenceInHours = (differenceInTime / (1000 * 60 * 60)) % 24; 

			long differenceInMinutes = (differenceInTime / (1000 * 60)) % 60;
			
			if (differenceInHours > 0 || differenceInMinutes > 60) {
				chkMin = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return chkMin;
	}
	
	public static void saveJsonFile(String fileName, Object obj) {
		try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(fileName))) {
				objectOut.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object readJsonFile(String fileName) {
		try (ObjectInputStream objectOut = new ObjectInputStream(new FileInputStream(fileName))) {
			 	return objectOut.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static HttpEntity<String> getHttpEntityObj() {
		try {
			HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            return new HttpEntity<>("parameters", headers);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	 private Helper() {
		    throw new IllegalStateException("Utility class");
     }

}
