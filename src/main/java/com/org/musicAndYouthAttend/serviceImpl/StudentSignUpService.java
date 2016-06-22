/**
 * 
 */
package com.org.musicAndYouthAttend.serviceImpl;

import java.time.LocalDate;

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
	 * Saves a new record in the StudentSignUp collection if there was no sign up earlier in the day
	 * 
	 * @param signUp
	 * @return inserted record
	 */
	public StudentSignUp signUpSave(StudentSignUp signUp){
		//LocalDate sysdate=LocalDate.now();
		StudentSignUp confirmSignUp=signUpRep.insert(new StudentSignUp(signUp.get_id(),signUp.getDate(),signUp.getStudentId(),signUp.getInterestedIn(),signUp.getModifiedBy()));
		return confirmSignUp;
	}
	/**
	 * Updates the record with new vocations as the sign up was done earlier in the day
	 * 
	 * @param signUp
	 * @return updated record
	 */
	public StudentSignUp signUpUpdate(StudentSignUp signUp){
		//LocalDate sysdate=LocalDate.now();
		StudentSignUp confirmSignUp=signUpRep.save(signUp);
		return confirmSignUp;
	}
	/**
	 * @return no. of documents in collection for setting up id
	 */
	public Integer getCount(){
		Integer cnt=(int)(long) signUpRep.count();
		return cnt;
	}
	/**
	 * Gets the sign up record if already present today
	 * 
	 * @param date
	 * @param studentId
	 * @return record
	 */
	public StudentSignUp getSignUpForToday(LocalDate date, String studentId){
		StudentSignUp studentSignUp=signUpRep.findStudentSignUpByDateAndStudentId(date, studentId);
		return studentSignUp;
	}
}
