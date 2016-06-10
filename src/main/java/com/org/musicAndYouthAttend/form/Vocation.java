/**
 * 
 */
package com.org.musicAndYouthAttend.form;

import java.util.List;

/**
 * @author Music and Youth Organization
 *
 */
public class Vocation {
	
	private int id;
	private String centerId;
	private List<String> vocations;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the centerId
	 */
	public String getCenterId() {
		return centerId;
	}
	/**
	 * @param centerId the centerId to set
	 */
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	/**
	 * @return the vocations
	 */
	public List<String> getVocations() {
		return vocations;
	}
	/**
	 * @param vocations the vocations to set
	 */
	public void setVocations(List<String> vocations) {
		this.vocations = vocations;
	}
	
	

}
