/**
 * 
 */
package com.neosuniversity.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.neosuniversity.video.business.ManageFileBusinessI;
import com.neosuniversity.video.entities.UploadFileResponse;

/**
 * @author hhugohm
 *
 */

@RestController
@RequestMapping(path = "/api/v1/neosuniversity/files")
public class FileManagerController {

	@Autowired
	private ManageFileBusinessI manageFileBusinessI;

	@PostMapping("/upload")
	public ResponseEntity<UploadFileResponse> uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("docType") String docType) {
		String fileName = manageFileBusinessI.storeFile(file, docType);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/neosuniversity/files/download/")
				.path(fileName).toUriString();

		return ResponseEntity.ok().body(UploadFileResponse.builder()
								  .fileName(fileName)
								  .fileDownloadUri(fileDownloadUri)
								  .fileType(file.getContentType())
								  .size(file.getSize()).build());

	}

}
