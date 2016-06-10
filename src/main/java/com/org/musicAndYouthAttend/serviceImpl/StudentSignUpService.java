/**
 * 
 */
package com.org.musicAndYouthAttend.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.musicAndYouthAttend.form.StudentSignUp;
import com.org.musicAndYouthAttend.service.StudentSignUpRepository;

/**
 * @author Music and Youth Organization
 *
 */
@Service
public class StudentSignUpService {
	@Autowired
	private StudentSignUpRepository signUpRep;
	
	/**
	 * @param signUp
	 * @return
	 */
	public StudentSignUp signUpSave(StudentSignUp signUp){
		Date sysdate=new Date();
		StudentSignUp confirmSignUp=signUpRep.save(new StudentSignUp(sysdate,signUp.getStudentId(),signUp.getInterestedIn(),signUp.getModifiedBy()));
		return confirmSignUp;
	}
}
