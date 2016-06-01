/**
 * 
 */
package com.org.musicAndYouthAttend.Helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

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
		String month;
		if(Integer.parseInt(student.getDay())<10){
			student.setDay("0"+student.getDay());
		}
	
		if(Integer.parseInt(student.getMonth())<10)
			month="0"+student.getMonth();
		else
			month=student.getMonth();
		date=month+"-"+student.getDay()+"-"+student.getYear();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate dateOfBirth=LocalDate.parse(date,formatter);
		return dateOfBirth;
	}
}
