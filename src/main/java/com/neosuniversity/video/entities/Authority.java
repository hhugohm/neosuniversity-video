package com.neosuniversity.video.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * 
 * @author hhugohm
 * 
 *         AUTHORITIES Entity that store information <br>
 *         related security
 *
 */
@Entity
@Table(name="AUTHORITIES",schema="VIDEODB")
public class Authority {
	
	
	@EmbeddedId
	private AuthorityId authorityId;

	public AuthorityId getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(AuthorityId authorityId) {
		this.authorityId = authorityId;
	}

	@Override
	public String toString() {
		return "Authority [authorityId=" + authorityId + "]";
	}


}
