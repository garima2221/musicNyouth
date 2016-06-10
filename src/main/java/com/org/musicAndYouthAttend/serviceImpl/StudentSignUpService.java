/**
 * 
 */
package com.org.musicAndYouthAttend.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.musicAndYouthAttend.form.StudentSignUp;
import com.org.musicAndYouthAttend.service.StudentSignUpRepository;

/**
 * @author Music and Youth Organization
 *
 */
public class StudentSignUpService {
	@Autowired
	private StudentSignUpRepository signUpRep;
	
	/**
	 * @param signUp
	 * @return
	 */
	public StudentSignUp signUpSave(StudentSignUp signUp){
		//Date sysdate=new Date();
		
		StudentSignUp confirmSignUp=signUpRep.save(signUp);
	
		return confirmSignUp;
	}
}
