/**
 * 
 */
package com.org.musicAndYouthAttend.form;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * 
 * @author Music and Youth Organization
 *
 */
public class StudentSignUp {
	
	public StudentSignUp(){
		
	}
	
	public StudentSignUp(Integer _id,LocalDate date, String studentId, List<String> interestedIn, String modifiedBy) {
		this._id=_id;
		this.date = date;
		this.studentId = studentId;
		this.interestedIn = interestedIn;
		this.modifiedBy = modifiedBy;
	}

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

	private LocalDate date;
	
	private String studentId;
	
	private List<String> interestedIn;
	
	private String modifiedBy;
	
	@Id
	private Integer _id;

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
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
