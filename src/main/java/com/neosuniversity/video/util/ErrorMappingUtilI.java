package com.neosuniversity.video.util;


import org.springframework.http.ResponseEntity;

import com.neosuniversity.video.errors.ErrorMapping;

public interface ErrorMappingUtilI {

	default ResponseEntity<Object> buildResponseEntity(ErrorMapping errorMapping) {
		return new ResponseEntity<>(errorMapping, errorMapping.getStatus());
	}

}
