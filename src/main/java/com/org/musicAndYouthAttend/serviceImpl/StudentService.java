/**
 * 
 */
package com.org.musicAndYouthAttend.serviceImpl;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.musicAndYouthAttend.Helper.StudentHelper;
import com.org.musicAndYouthAttend.form.Student;
import com.org.musicAndYouthAttend.service.StudentRepository;

/**
 * @author Music and Youth Organization
 *
 */

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRep;
	
	@Autowired
	private StudentHelper helper; 
	/**
	 * Registers student in the system
	 * 
	 * @param student
	 * @return
	 */
	public Student studentSave(Student student){
		
		LocalDate dateOfBirth = helper.getDate(student);
		student.setDateOfBirth(dateOfBirth);
		Date sysdate=new Date();
		Student confirmSave=studentRep.save(new Student(student.getStudentId(),student.getFirstName(),student.getLastName(),
																										student.getMiddleName(),student.getGender(),student.getDateOfBirth(),student.getReferral(),
																										student.getInterestedIn(),student.getCenterId(),sysdate,student.getAlias(),
																										student.getUserId(),student.getPassword(),student.getAccomplishments()));
		return confirmSave;
	}

	
	
	/**
	 * checks for similar studentId in the database
	 * 
	 * @param studentId
	 * @return
	 */
	public Student findDuplicateStudent(String studentId){
		
		Student duplicateStudent=studentRep.findStudentByStudentId(studentId);
		return duplicateStudent;
	}

}
