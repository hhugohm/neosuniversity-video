/**
 * 
 */
package com.neosuniversity.video.entities;


import lombok.Builder;
import lombok.Data;

/**
 * @author hhugohm
 *
 */
@Data
@Builder
public class UploadFileResponse {
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;
}
