package com.neosuniversity.video.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author hhugohm
 * 
 *         AuthorityId Entity that store information <br>
 *         related Data Base Primary Key
 *
 */
@Embeddable
public class AuthorityId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Column(name = "USER_NAME", length = 50, nullable = false)
	private String username;
	
	@Column(name="ID_AUTHORITY", length = 100, nullable = false)
	private String authority;

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	@Override
	public String toString() {
		return "AuthorityId [username=" + username + ", authority=" + authority + "]";
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorityId)) return false;
        AuthorityId that = (AuthorityId) o;
        return Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getAuthority(), that.getAuthority());
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(getUsername(), getAuthority());
    }

}
