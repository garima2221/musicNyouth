/**
 * 
 */
package com.org.musicAndYouthAttend.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.musicAndYouthAttend.form.Attendance;
import com.org.musicAndYouthAttend.service.AttendanceRepository;

/**
 * 
 * 
 * @author Music and Youth Organization
 *
 */
@Service
public class AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRep;
	
	/**
	 * Saves the document in mongo collection
	 * 
	 * @param att
	 * @return saved object
	 */
	public Attendance submitAttendance(Attendance att) {
		//LocalDate sysdate = LocalDate.now();
		Attendance confirmAttendance = attendanceRep.insert(new Attendance(att.get_id(),att.getVocation(), att.getStudentIds(),
				att.getModifiedOn(), att.getAttendanceDate(), att.getCenterId()));
		return confirmAttendance;

	}
	
	/**
	 * Check if attendance for that vocation has already been entered in the system
	 * 
	 * @param att
	 * @return attendance record
	 */
	public Attendance getAttendance(Attendance att){
		
		Attendance attendance = attendanceRep.findAttendanceByCenterIdAndAttendanceDateAndVocation(att.getCenterId(),
				att.getAttendanceDate(), att.getVocation());
		return attendance;
	}
	
	/**
	 * Updates the attendance record if already present
	 * 
	 * @param att
	 * @return updated record
	 */
	public Attendance updateAttendance(Attendance att){
		//LocalDate sysdate = LocalDate.now();
		Attendance confirmAttendance = attendanceRep.save(att);
		return confirmAttendance;
	}
	
	/**
	 * @return no. of documents in collection for setting up id
	 */
	public Integer getCount(){
		Integer cnt=(int)(long) attendanceRep.count();
		return cnt;
	}

}
