package com.neosuniversity.video.controller.test;

import static org.hamcrest.Matchers.hasSize;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosuniversity.video.business.MovieBusinessI;
import com.neosuniversity.video.entities.Movie;

import lombok.extern.slf4j.Slf4j;

@TestMethodOrder(OrderAnnotation.class)
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class TestMovieController {
	
	@Value("classpath:data/movie.json")
	private Resource resourceFile;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MovieBusinessI movieBusinessI;
	
	@Test
	@Order(1)    
	public void testGetCountryById() throws UnsupportedEncodingException, Exception {
		MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
        ObjectMapper objectMapper = new ObjectMapper();

        Movie movie = objectMapper.readValue(resourceFile.getFile(), Movie.class);
        
        log.info("MOVIE::::::" +movie.toString());
		
		given(this.movieBusinessI.readMovieById(1L)).willReturn(movie);
		String response = mockMvc.perform(get("/api/v1/neosuniversity/movies/{idMovie}", 1L))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.idmovie", is(3)))
                .andExpect(jsonPath("$.title", is("DOCTOR HOUSE")))
                .andExpect(jsonPath("$.duration", is("02:05:11")))
                .andExpect(jsonPath("$.season", hasSize(2)))
                .andExpect(jsonPath("$.season[0].chapters", hasSize(2)))
                .andExpect(jsonPath("$.season[0].chapters[0].title", is("PILOTO")))
                .andExpect(jsonPath("$.season[0].synopsis", is("E")))
                .andExpect(jsonPath("$.actors", hasSize(1)))
                .andExpect(jsonPath("$.actors[0].name", is("BRAT")))
                .andExpect(jsonPath("$.actors[0].country.country", is("UNITED STATES OF AMERICA")))
                .andReturn().getResponse().getContentAsString();
        log.info("response: " + response);
	}	

}
