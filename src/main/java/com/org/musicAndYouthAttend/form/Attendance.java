/**
 * 
 */
package com.org.musicAndYouthAttend.form;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * @author Music and Youth Organization
 *
 */
public class Attendance {
	
	private String vocation;
	private List<String> studentIds;
	private LocalDate modifiedOn;
	private String day;
	private String month;
	private String year;
	private LocalDate attendanceDate;
	private String centerId;
	@Id
	private Integer _id;
	
	public Attendance(){
		
	}
	public Attendance(Integer _id,String vocation, List<String> studentIds, LocalDate modifiedOn, LocalDate attendanceDate,String centerId) {
		this._id=_id;
		this.vocation = vocation;
		this.studentIds = studentIds;
		this.modifiedOn = modifiedOn;
		this.attendanceDate = attendanceDate;
		this.centerId=centerId;
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
	 * @return the modifiedOn
	 */
	public LocalDate getModifiedOn() {
		return modifiedOn;
	}
	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(LocalDate modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the attendanceDate
	 */
	public LocalDate getAttendanceDate() {
		return attendanceDate;
	}
	/**
	 * @param attendanceDate the attendanceDate to set
	 */
	public void setAttendanceDate(LocalDate attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	/**
	 * @return the vocation
	 */
	public String getVocation() {
		return vocation;
	}
	/**
	 * @param vocation the vocation to set
	 */
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	/**
	 * @return the studentIds
	 */
	public List<String> getStudentIds() {
		return studentIds;
	}
	/**
	 * @param studentIds the studentIds to set
	 */
	public void setStudentIds(List<String> studentIds) {
		this.studentIds = studentIds;
	}
	
	
}
