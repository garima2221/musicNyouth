/**
 * 
 */
package com.org.musicAndYouthAttend.form;

import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * @author Music and Youth Organization
 *
 */
public class Roles {
	
	private String role;
	
	private List<String> accessTo;
	
	@Id
	private Integer _id;
	
	
	

	/**
	 * @return the _id
	 */
	public Integer get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(Integer _id) {
		this._id = _id;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the accessTo
	 */
	public List<String> getAccessTo() {
		return accessTo;
	}

	/**
	 * @param accessTo the accessTo to set
	 */
	public void setAccessTo(List<String> accessTo) {
		this.accessTo = accessTo;
	}
	
	
	

}
