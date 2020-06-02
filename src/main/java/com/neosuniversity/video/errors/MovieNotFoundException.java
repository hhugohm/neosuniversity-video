package com.neosuniversity.video.errors;

public class MovieNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieNotFoundException(Long id) {
        super("Movie id not found : " + id);
    }

}
