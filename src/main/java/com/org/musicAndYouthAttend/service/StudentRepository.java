/**
 * 
 */
package com.org.musicAndYouthAttend.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.org.musicAndYouthAttend.form.Student;

/**
 * @author Music and Youth Organization
 *
 */

public interface StudentRepository extends MongoRepository<Student, String> {
	
	public Student findStudentByStudentId(String studentId);

}
