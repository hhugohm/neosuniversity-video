/**
 * 
 */
package com.neosuniversity.video.business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.neosuniversity.video.entities.StorageImageMapping;

/**
 * @author hhugohm
 *
 */
@Service
public class ManageFileBusinessImpl implements ManageFileBusinessI {

	private final Path fileStorageLocation;

	//@Autowired
	//private StorageImageRepository storageImageRepository;

	@Autowired
	public ManageFileBusinessImpl(StorageImageMapping storageImageMapping) {
		this.fileStorageLocation = Paths.get(storageImageMapping.getUploadDir()).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.fileStorageLocation);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	@Override
	public String storeFile(MultipartFile file, String docType) {

		// Normalize file name
		String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
		String fileName = "";
		try {
			// Check if the file's name contains invalid characters
			if (originalFileName.contains("..")) {
				throw new RuntimeException("Sorry! Filename contains invalid path sequence " + originalFileName);

			}
			String fileExtension = "";
			try {
				fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));

			} catch (Exception e) {
				fileExtension = "";
			}
			fileName = docType + fileExtension;

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			/*StorageImageMapping doc = docStorageRepo.checkDocumentByUserId(userId, docType);
			if (doc != null) {
				doc.setDocumentFormat(file.getContentType());
				doc.setFileName(fileName);
				docStorageRepo.save(doc);
			} else {
				DocumnentStorageProperties newDoc = new DocumnentStorageProperties();
				newDoc.setUserId(userId);
				newDoc.setDocumentFormat(file.getContentType());
				newDoc.setFileName(fileName);
				newDoc.setDocumentType(docType);
				docStorageRepo.save(newDoc);
			}*/

			return fileName;

		} catch (IOException ex) {

			throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);

		}

	}

}
