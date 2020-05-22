package com.neosuniversity.video.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosuniversity.video.entities.Country;
import com.neosuniversity.video.repository.CountryRepository;

@Service
public class CountryBusinessImpl implements CountryBusinessI {
	
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country getCountryById(Long id) {
		return countryRepository.findById(id).get();
	}

}
