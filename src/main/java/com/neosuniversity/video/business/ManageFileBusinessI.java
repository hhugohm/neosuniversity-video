/**
 * 
 */
package com.neosuniversity.video.business;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author hhugohm
 *
 */
public interface ManageFileBusinessI {
	
	
	 String storeFile(MultipartFile file, String docType);

}
