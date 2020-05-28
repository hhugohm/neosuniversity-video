package com.neosuniversity.video.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosuniversity.video.entities.Country;
import com.neosuniversity.video.repository.CountryRepository;
import com.neosuniversity.video.errors.CountryNotFoundException;

@Service
public class CountryBusinessImpl implements CountryBusinessI {
	
	@Autowired
	private CountryRepository countryRepository;
	
	
	@Override
	public void createCountry(Country country) {
		countryRepository.save(country);
	}
	
	@Override
	public Country readCountryById(Long id) {
		Country country = countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
		
		return country;
	}

	@Override
	public void updateCountry(Country country) {
		countryRepository.save(country);
		
	}

	@Override
	public void deleteCountry(Country country) {
		countryRepository.delete(country);
	}

}
