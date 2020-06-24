/**
 * 
 */
package com.neosuniversity.video.business;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hhugohm
 *
 */
public interface ManageFileBusinessI {
	
	
	 String storeFile(MultipartFile file, String docType);

	  Resource loadFileAsResource(String fileName) throws Exception;
}
