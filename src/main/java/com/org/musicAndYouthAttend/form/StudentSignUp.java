/**
 * 
 */
package com.org.musicAndYouthAttend.form;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Music and Youth Organization
 *
 */
public class StudentSignUp {
	
	private Date date;
	
	private String studentId;
	
	private List<String> interestedIn;
	
	private String modifiedBy;

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the interestedIn
	 */
	public List<String> getInterestedIn() {
		return interestedIn;
	}

	/**
	 * @param interestedIn the interestedIn to set
	 */
	public void setInterestedIn(List<String> interestedIn) {
		this.interestedIn = interestedIn;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	

}
