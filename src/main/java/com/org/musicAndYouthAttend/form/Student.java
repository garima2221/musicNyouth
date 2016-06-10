/**
 * Model for Student Data
 */
package com.org.musicAndYouthAttend.form;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * @author Music and Youth Organization
 *
 */

public class Student {
	
	
		public Student(){
			
		}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param centerId
	 * @param alias
	 * @param studentId
	 * @param dateOfBirth
	 * @param referral
	 * @param userId
	 * @param password
	 * @param interestedIn
	 * @param dateOfJoining
	 * @param accomplishments
	 */
	public Student(String studentId,String firstName, String lastName, String middleName,String studentName,String gender,LocalDate dateOfBirth,List<String> referral,
									List<String> interestedIn, String centerId,Date dateOfJoining, String alias, String userId, String password, 
									String accomplishments) {
		
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.studentName=studentName;
		this.gender=gender;
		this.dateOfBirth = dateOfBirth;
		this.referral = referral;
		this.interestedIn = interestedIn;
		this.centerId = centerId;
		this.dateOfJoining = dateOfJoining;
		this.alias = alias;
		this.userId = userId;
		this.password = password;
		this.accomplishments = accomplishments;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", gender=" + gender +", centerId=" + centerId + ", alias=" + alias + ", studentId=" + studentId + ", dateOfBirth="
				+ dateOfBirth + ", referral=" + referral + ", userId=" + userId + ", password=" + password
				+ ", interestedIn=" + interestedIn + ", dateOfJoining=" + dateOfJoining + ", accomplishments="
				+ accomplishments + "]";
	}
	
	private String studentName;

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * Student's first Name
	 */
	@NotNull
	private String firstName;
	
	/**
	 * Student's last Name 
	 */
	@NotNull
	private String lastName;
	
	/**
	 * Student's middle name
	 */
	private String middleName;
	
	private String gender;
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Center Id of the Center(Location) in which the student is enrolled
	 */
	private String centerId;
	
	/**
	 * Student's id provided by the center for identification
	 */
	private String alias;
	
	/**
	 * Student Id
	 */	
	private String studentId;
	
	/**
	 * Student's date of birth
	 */
	private LocalDate dateOfBirth;
	
	/**
	 * Reference by which Student became aware of the classes
	 */
	private List<String> referral;
	
	/**
	 * Student's user id for login purposes
	 */
	private String userId;
	
	/**
	 * Student's password for login purposes
	 */
	private String password;
	
	private List<String> interestedIn;

	private Date dateOfJoining;
	
	private String accomplishments;
	
	private String day;
	
	private String month;
	
	private String year;
	
	private String name;
	
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
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
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the referral
	 */
	public List<String> getReferral() {
		return referral;
	}

	/**
	 * @param referral the referral to set
	 */
	public void setReferral(List<String> referral) {
		this.referral = referral;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the accomplishments
	 */
	public String getAccomplishments() {
		return accomplishments;
	}

	/**
	 * @param accomplishments the accomplishments to set
	 */
	public void setAccomplishments(String accomplishments) {
		this.accomplishments = accomplishments;
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
	
	
}
