/**
 * 
 */
package com.org.musicAndYouthAttend.service;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.org.musicAndYouthAttend.form.StudentSignUp;

/**
 * @author Music and Youth Organization
 *
 */
public interface StudentSignUpRepository extends MongoRepository<StudentSignUp, String>{
	
	public StudentSignUp findStudentSignUpByDateAndStudentId(LocalDate date,String studentId);

}
