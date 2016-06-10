/**
 * 
 */
package com.org.musicAndYouthAttend.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.musicAndYouthAttend.form.Accomplishment;
import com.org.musicAndYouthAttend.service.AccomplishmentRepository;

/**
 * @author Music and Youth Organization
 *
 */
@Service
public class AccomplishmentService {
	
	@Autowired
	private AccomplishmentRepository accomplishmentRep;
	
	/**
	 * @param studentId
	 * @return
	 */
	public List<Accomplishment> getAccomplishments(String studentId){
		List<Accomplishment> accomplishments=accomplishmentRep.findAccomplishmentByStudentId(studentId);
		return accomplishments;
	}

}
