/**
 * 
 */
package com.org.musicAndYouthAttend.Helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.org.musicAndYouthAttend.form.Attendance;
import com.org.musicAndYouthAttend.form.Student;

/**
 * @author Music and Youth Organization
 *
 */
@Component
public class StudentHelper {
	/**
	 * @param student
	 * @return
	 */
	public LocalDate getDate(Student student) {
		String date;
		if(Integer.parseInt(student.getDay())<10){
			student.setDay("0"+student.getDay());
		}
	
		if(Integer.parseInt(student.getMonth())<10){
			student.setMonth("0"+student.getMonth());
		}
			
		date=student.getMonth()+"-"+student.getDay()+"-"+student.getYear();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate dateOfBirth=LocalDate.parse(date,formatter);
		return dateOfBirth;
	}
	
	
	/**
	 * @param attendance
	 * @return
	 */
	public LocalDate getDate(Attendance attendance) {
		String date;
		if(Integer.parseInt(attendance.getDay())<10){
			attendance.setDay("0"+attendance.getDay());
		}
	
		if(Integer.parseInt(attendance.getMonth())<10){
			attendance.setMonth("0"+attendance.getMonth());
		}
			
		date=attendance.getMonth()+"-"+attendance.getDay()+"-"+attendance.getYear();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate finalDate=LocalDate.parse(date,formatter);
		return finalDate;
	}
}
