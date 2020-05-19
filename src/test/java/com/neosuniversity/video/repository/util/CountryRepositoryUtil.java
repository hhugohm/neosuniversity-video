package com.neosuniversity.video.repository.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neosuniversity.video.entities.Country;


public interface CountryRepositoryUtil {
	
	String MEXICO="MEXICO";
	String CANADA="CANADA";
	String BRAZIL="BRAZIL";
	String ARGENTINA="ARGENTINA";
	String COLOMBIA="COLOMBIA";
	String MEXICO_UPDATE="MEXICO_UPDATE";
	String DESCRIPTION_FIELD="description";
	Long KEY_COUNTRY_1 =1L;
	int SIZE_0=0;
	int SIZE_1=1;
	int SIZE_2=2;
	int SIZE_3=3;
	int SIZE_5=5;
	
	static List<Country> populateCountries(){
		List<Country> lstCountry = new ArrayList<>();
		
		lstCountry.add(new Country(MEXICO));
		lstCountry.add(new Country(CANADA));
		lstCountry.add(new Country(BRAZIL));
		lstCountry.add(new Country(ARGENTINA));
		lstCountry.add(new Country(COLOMBIA));
		
		return lstCountry;
	}
	static Map<String,Country> populateCountriesMap(){
		Map<String,Country> countriesMap = new HashMap<>();
		countriesMap.put(MEXICO, new Country(MEXICO));
		countriesMap.put(CANADA, new Country(CANADA));
		countriesMap.put(BRAZIL, new Country(BRAZIL));
		countriesMap.put(ARGENTINA, new Country(ARGENTINA));
		countriesMap.put(COLOMBIA, new Country(COLOMBIA));
		return countriesMap;
	}

}
