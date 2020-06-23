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
package com.neosuniversity.video.busniess.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.neosuniversity.video.business.CountryBusinessI;
import com.neosuniversity.video.entities.Country;
import com.neosuniversity.video.repository.CountryRepository;

import lombok.extern.slf4j.Slf4j;



/**
 * The Class TestCountryBusiness.
 * 
 * @author Neosuniversity
 * @version 1.0
 */
@TestMethodOrder(OrderAnnotation.class)

/** The Constant log. */
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestCountryBusiness {
	
	
	/** The country repository mock. */
	@MockBean
	private CountryRepository countryRepositoryMock;
	
	/** The country business I. */
	@Autowired
	private CountryBusinessI countryBusinessI;
	
	
	
	/**
	 * Test get country by id.
	 */
	@Test
	@Order(1)    
	public void TestGetCountryById() {
		Country country = Country.builder().description("MEXICO").build();
		Optional<Country> optional = Optional.of(country);
		
		when(countryRepositoryMock.findById(1L)).thenReturn(optional);
		assertEquals("MEXICO", countryBusinessI.readCountryById(1L).getDescription());
		
	}
	

	

}
