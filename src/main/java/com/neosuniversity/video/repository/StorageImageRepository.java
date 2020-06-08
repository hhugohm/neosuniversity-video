/**
 * 
 */
package com.neosuniversity.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neosuniversity.video.entities.StorageImageMapping;

/**
 * @author hhugohm
 *
 */
public interface StorageImageRepository extends JpaRepository<StorageImageMapping, Long> {
	
	

}
