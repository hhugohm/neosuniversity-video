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
package com.neosuniversity.video.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosuniversity.video.entities.Country;
import com.neosuniversity.video.repository.CountryRepository;
import com.neosuniversity.video.errors.CountryNotFoundException;

/**
 * The Class CountryBusinessImpl.
 * 
 * @author Neosuniversity
 * @version 1.0
 */
@Service
public class CountryBusinessImpl implements CountryBusinessI {
	
	/** The country repository. */
	@Autowired
	private CountryRepository countryRepository;
	
	
	/* (non-Javadoc)
	 * @see com.neosuniversity.video.business.CountryBusinessI#createCountry(com.neosuniversity.video.entities.Country)
	 */
	@Override
	public void createCountry(Country country) {
		countryRepository.save(country);
	}
	
	/* (non-Javadoc)
	 * @see com.neosuniversity.video.business.CountryBusinessI#readCountryById(java.lang.Long)
	 */
	@Override
	public Country readCountryById(Long id) {
		Country country = countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
		
		return country;
	}

	/* (non-Javadoc)
	 * @see com.neosuniversity.video.business.CountryBusinessI#updateCountry(com.neosuniversity.video.entities.Country)
	 */
	@Override
	public void updateCountry(Country country) {
		countryRepository.save(country);
		
	}

	/* (non-Javadoc)
	 * @see com.neosuniversity.video.business.CountryBusinessI#deleteCountry(com.neosuniversity.video.entities.Country)
	 */
	@Override
	public void deleteCountry(Country country) {
		countryRepository.delete(country);
	}

}
