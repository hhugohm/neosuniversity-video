/**
 * 
 */
package com.neosuniversity.video.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author hhugohm
 *
 */
@Data
@Builder
@Entity
@Table(name = "STORAGE_IMAGE", schema = "VIDEODB")
@ConfigurationProperties(prefix = "file")
@JsonPropertyOrder({ "documentId", "fileName", "documentType", "documentFormat" ,"path"})
public class StorageImageMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "document_id")
	private Long documentId;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "document_type")
	private String documentType;

	@Column(name = "document_format")
	private String documentFormat;

	@Column(name = "upload_path")
	private String uploadDir;
	
	@Tolerate
	public StorageImageMapping() {}

}
