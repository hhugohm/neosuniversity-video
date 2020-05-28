package com.neosuniversity.video.controller.test;


import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.neosuniversity.video.business.CountryBusinessI;
import com.neosuniversity.video.entities.Country;

import lombok.extern.slf4j.Slf4j;

@TestMethodOrder(OrderAnnotation.class)
//@TestInstance(Lifecycle.PER_CLASS)
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class TestCountryController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CountryBusinessI countryBusinessI;
	
	@Test
	@Order(1)    
	public void TestGetCountryById() throws UnsupportedEncodingException, Exception {
		MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
		
		given(this.countryBusinessI.readCountryById(1L)).willReturn(Country.builder().idcountry(1L).description("MEXICO").build());
		String response = mockMvc.perform(get("/api/v1/neosuniversity/countries/{idCountry}", 1L))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.keyCountry", is(1)))
                .andExpect(jsonPath("$.country", is("MEXICO")))
                .andReturn().getResponse().getContentAsString();
 
        log.info("response: " + response);
		
		
		
	}

}
