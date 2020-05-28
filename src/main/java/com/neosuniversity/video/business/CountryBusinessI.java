package com.neosuniversity.video.business;

import com.neosuniversity.video.entities.Country;

public interface CountryBusinessI {
	
	void createCountry(Country country);
	
	Country readCountryById(Long id);
	
	void updateCountry(Country country);
	
	void deleteCountry(Country country);
	

}
