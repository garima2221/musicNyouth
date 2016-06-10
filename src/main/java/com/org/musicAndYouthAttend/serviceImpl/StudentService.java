/**
 * 
 */
package com.org.musicAndYouthAttend.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	/**
	 * Registers student in the system
	 * 
	 * @param student
	 * @return
	 */
	public Student studentSave(Student student){
		Date sysdate=new Date();
		Student confirmSave=studentRep.save(new Student(student.getStudentId(),student.getFirstName(),student.getLastName(),
																										student.getMiddleName(),student.getStudentName(),student.getGender(),student.getDateOfBirth(),student.getReferral(),
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
	public Student findStudent(String studentId){
		
		Student student=studentRep.findStudentByStudentId(studentId);
		return student;
	}
	
	public List<Student> findAllStudent(List<Student> data){
		List<Student> students=studentRep.findAll();
		return students;
	}
}
