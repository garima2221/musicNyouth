/**
 * 
 */
package com.org.musicAndYouthAttend.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.org.musicAndYouthAttend.form.StudentSignUp;

/**
 * @author Music and Youth Organization
 *
 */
public interface StudentSignUpRepository extends MongoRepository<StudentSignUp, String>{

}
