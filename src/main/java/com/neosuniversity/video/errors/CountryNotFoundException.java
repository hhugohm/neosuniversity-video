package com.neosuniversity.video.errors;

public class CountryNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CountryNotFoundException(Long id) {
        super("Country id not found : " + id);
    }

}
