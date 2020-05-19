package com.neosuniversity.video;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.neosuniversity.video.entities.Country;
import com.neosuniversity.video.repository.CountryRepository;

import lombok.extern.slf4j.Slf4j;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CountryRepositoryTest {
	
	@Autowired
	private CountryRepository countryRepository;
	
	private List<Country> countriesList;
	private Map<String,Country> countriesMap;
	
	private static final String MEXICO="MEXICO";
	private static final String CANADA="CANADA";
	private static final String BRAZIL="BRAZIL";
	private static final String ARGENTINA="ARGENTINA";
	private static final String COLOMBIA="COLOMBIA";
	private static final String MEXICO_UPDATE="MEXICO_UPDATE";
	private static final String DESCRIPTION_FIELD="description";
	private static final Long KEY_COUNTRY_1 =1L;
	private static final int SIZE_0=0;
	private static final int SIZE_1=1;
	private static final int SIZE_2=2;
	private static final int SIZE_3=3;
	private static final int SIZE_5=5;
	
	
	@BeforeAll
	public void beforeAllInit() {
		 log.info(":::::::Running - populate countries......");
		countriesList = populateCountries();
		countriesMap = populateCountriesMap();
	}

	@AfterAll
    public  void cleanUp(){
		log.info(":::::::CleanUp() countries .....");
		
        countriesList.stream().forEach(country ->{
        	log.info("REMOVE COUNTRY: " +country.getDescription());
			countryRepository.delete(country);
		});
		
		assertThat(countryRepository.findById(1L)).isNotPresent();
	}
	
	private List<Country> populateCountries(){
		List<Country> lstCountry = new ArrayList<>();
		lstCountry.add(new Country(MEXICO));
		lstCountry.add(new Country(CANADA));
		lstCountry.add(new Country(BRAZIL));
		lstCountry.add(new Country(ARGENTINA));
		lstCountry.add(new Country(COLOMBIA));
		
		return lstCountry;
	}
	private Map<String,Country> populateCountriesMap(){
		countriesMap = new HashMap<>();
		countriesMap.put(MEXICO, new Country(MEXICO));
		countriesMap.put(CANADA, new Country(CANADA));
		countriesMap.put(BRAZIL, new Country(BRAZIL));
		countriesMap.put(ARGENTINA, new Country(ARGENTINA));
		countriesMap.put(COLOMBIA, new Country(COLOMBIA));
		return countriesMap;
	}
	
	@Test
	@Order(1)    
	public void testCreateCountry() {
		countryRepository.save(countriesMap.get(MEXICO));
		
		Optional<Country> countryDB = countryRepository.findById(KEY_COUNTRY_1);
		assertThat(countryDB).isNotEmpty();
	}
	
	@Test
	@DisplayName("😱")
	@Order(2)    
	public void testReadCountry() {
		List<Country> lstCountries = countryRepository.findByDescriptionContaining(MEXICO);
		
		assertThat(lstCountries).isNotEmpty()
								.hasSize(SIZE_1)
								.extracting(Country::getDescription)
								.containsExactly(MEXICO)
								.doesNotContainNull();
	}
	@Test
	@Order(3)    
	public void testReadPageableCountry() {
		Map<String,Country> countriesRead = countriesMap;
		countriesRead.entrySet().removeIf(entry -> entry.getValue().getDescription().equals(MEXICO));
		
		countriesRead.entrySet().stream().forEach(action->{
			countryRepository.save(action.getValue());
		});
		
		Pageable pageable = PageRequest.of(SIZE_0, SIZE_2,Sort.by(DESCRIPTION_FIELD).ascending());
		Page<Country> pageCountry = null;
		int countpage = -1;
		do {
			countpage++;
			pageCountry = countryRepository.findAll(pageable);
			int number = pageCountry.getNumber();
			int numberOfElements = pageCountry.getNumberOfElements();
			int size = pageCountry.getSize();
			long totalElements = pageCountry.getTotalElements();
			int totalPages = pageCountry.getTotalPages();
			log.info(
					"page info - page number {}, numberOfElements: {}, size: {}, "
							+ "totalElements: {}, totalPages: {}",
					number, numberOfElements, size, totalElements, totalPages);
			
			if(countpage==SIZE_0){
				assertThat(pageCountry.getNumber()).isEqualTo(0);
				assertThat(pageCountry.getNumberOfElements()).isEqualTo(SIZE_2);
				assertThat(pageCountry.getSize()).isEqualTo(SIZE_2);
				assertThat(pageCountry.getTotalElements()).isEqualTo(SIZE_5);
				assertThat(pageCountry.getTotalPages()).isEqualTo(SIZE_3);
				assertThat(pageCountry).isNotEmpty()
									   .hasSize(SIZE_2)
									   .extracting(Country::getDescription)
									   .containsExactly(ARGENTINA,BRAZIL)
									   .doesNotContainNull();
			}
			if(countpage==SIZE_1){	
				assertThat(pageCountry.getNumber()).isEqualTo(SIZE_1);
				assertThat(pageCountry.getNumberOfElements()).isEqualTo(SIZE_2);
				assertThat(pageCountry.getSize()).isEqualTo(SIZE_2);
				assertThat(pageCountry.getTotalElements()).isEqualTo(SIZE_5);
				assertThat(pageCountry.getTotalPages()).isEqualTo(SIZE_3);
				assertThat(pageCountry).isNotEmpty()
									   .hasSize(SIZE_2)
									   .extracting(Country::getDescription)
									   .containsExactly(CANADA,COLOMBIA)
									   .doesNotContainNull();
			}
			if(countpage==SIZE_2){
				assertThat(pageCountry.getNumber()).isEqualTo(SIZE_2);
				assertThat(pageCountry.getNumberOfElements()).isEqualTo(SIZE_1);
				assertThat(pageCountry.getSize()).isEqualTo(SIZE_2);
				assertThat(pageCountry.getTotalElements()).isEqualTo(SIZE_5);
				assertThat(pageCountry.getTotalPages()).isEqualTo(SIZE_3);
				assertThat(pageCountry).isNotEmpty()
									   .hasSize(SIZE_1)
									   .extracting(Country::getDescription)
									   .containsExactly(MEXICO)
									   .doesNotContainNull();
			}
			pageable = pageCountry.nextPageable();
			
		} while (pageable.hasPrevious());
		log.info("COUNT: "+countpage);
		
	}

	@Test
	@Order(4)    
	public void testUpdateCountry() {
		Optional<Country> countryDB = countryRepository.findById(KEY_COUNTRY_1);
		countryDB.get().setDescription(MEXICO_UPDATE);
		
		countryRepository.save(countryDB.get());
		
		Optional<Country> countryUpdate = countryRepository.findById(KEY_COUNTRY_1);
		log.info("####: " +countryUpdate.get().toString());
		assertThat(countryUpdate).isNotEmpty()
								 .get()
								 .extracting(Country::getDescription)
								 .descriptionText()
								 .equalsIgnoreCase(MEXICO_UPDATE);
	}
	
	@Test
	@Order(5)    
	public void testDeleteCountry() {
		Optional<Country> countryDB = countryRepository.findById(KEY_COUNTRY_1);
		countryRepository.delete(countryDB.get());
		
		assertThat(countryRepository.findById(1L)).isNotPresent();
	}
}
