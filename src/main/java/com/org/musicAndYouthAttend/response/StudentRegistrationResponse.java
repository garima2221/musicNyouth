/**
 * 
 */
package com.org.musicAndYouthAttend.response;

/**
 * The class to represent the Db response while registering Student.
 * The Response code will map to a Property file.
 * 
 * @author  Music and Youth Organization
 *
 */
public class StudentRegistrationResponse {

	int responseCode=0;
	String responseMessage;
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	
}
