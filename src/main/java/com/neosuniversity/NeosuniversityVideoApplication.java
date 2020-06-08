package com.neosuniversity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.neosuniversity.video.entities.StorageImageMapping;

@SpringBootApplication
@EnableConfigurationProperties({
	StorageImageMapping.class
})
public class NeosuniversityVideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeosuniversityVideoApplication.class, args);
	}
}
