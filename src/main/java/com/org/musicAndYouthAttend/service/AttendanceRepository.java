/**
 * 
 */
package com.org.musicAndYouthAttend.service;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.org.musicAndYouthAttend.form.Attendance;

/**
 * Repository for attendance of students
 * 
 * @author Music and Youth Organization
 *
 */
public interface AttendanceRepository extends MongoRepository<Attendance, String> {
	
	public Attendance findAttendanceByCenterIdAndAttendanceDateAndVocation(String centerId,LocalDate date,String vocation);

}
