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



@TestMethodOrder(OrderAnnotation.class)
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestCountryBusiness {
	
	
	@MockBean
	private CountryRepository countryRepositoryMock;
	
	@Autowired
	private CountryBusinessI countryBusinessI;
	
	
	
	@Test
	@Order(1)    
	public void TestGetCountryById() {
		Country country = Country.builder().description("MEXICO").build();
		Optional<Country> optional = Optional.of(country);
		
		when(countryRepositoryMock.findById(1L)).thenReturn(optional);
		assertEquals("MEXICO", countryBusinessI.readCountryById(1L).getDescription());
		
	}
	

	

}
