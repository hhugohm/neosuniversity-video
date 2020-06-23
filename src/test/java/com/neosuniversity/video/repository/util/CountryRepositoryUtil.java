/******************************************************************************************
Copyright (c) 2020 NeosSoftware Corporation

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is furnished
to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
************************************************************************************************/
package com.neosuniversity.video.repository.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neosuniversity.video.entities.Country;


/**
 * The Interface CountryRepositoryUtil.
 * 
 * @author Neosuniversity
 * @version 1.0
 */
public interface CountryRepositoryUtil {
	
	/** The mexico. */
	String MEXICO="MEXICO";
	
	/** The canada. */
	String CANADA="CANADA";
	
	/** The brazil. */
	String BRAZIL="BRAZIL";
	
	/** The argentina. */
	String ARGENTINA="ARGENTINA";
	
	/** The colombia. */
	String COLOMBIA="COLOMBIA";
	
	/** The mexico update. */
	String MEXICO_UPDATE="MEXICO_UPDATE";
	
	/** The description field. */
	String DESCRIPTION_FIELD="description";
	
	/** The key country 1. */
	Long KEY_COUNTRY_1 =1L;
	
	/** The size 0. */
	int SIZE_0=0;
	
	/** The size 1. */
	int SIZE_1=1;
	
	/** The size 2. */
	int SIZE_2=2;
	
	/** The size 3. */
	int SIZE_3=3;
	
	/** The size 5. */
	int SIZE_5=5;
	
	/**
	 * Populate countries.
	 *
	 * @return the list
	 */
	static List<Country> populateCountries(){
		List<Country> lstCountry = new ArrayList<>();
		
		lstCountry.add(Country.builder().description(MEXICO).build());
		lstCountry.add(Country.builder().description(CANADA).build());
		lstCountry.add(Country.builder().description(BRAZIL).build());
		lstCountry.add(Country.builder().description(ARGENTINA).build());
		lstCountry.add(Country.builder().description(COLOMBIA).build());
		
		return lstCountry;
	}
	
	/**
	 * Populate countries map.
	 *
	 * @return the map
	 */
	static Map<String,Country> populateCountriesMap(){
		Map<String,Country> countriesMap = new HashMap<>();
		countriesMap.put(MEXICO, Country.builder().description(MEXICO).build());
		countriesMap.put(CANADA, Country.builder().description(CANADA).build());
		countriesMap.put(BRAZIL, Country.builder().description(BRAZIL).build());
		countriesMap.put(ARGENTINA, Country.builder().description(ARGENTINA).build());
		countriesMap.put(COLOMBIA,Country.builder().description(COLOMBIA).build());
		return countriesMap;
	}

}
