/**
 * 
 */
package com.org.musicAndYouthAttend.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.musicAndYouthAttend.form.Vocation;
import com.org.musicAndYouthAttend.service.VocationRepository;

/**
 * @author Music and Youth Organization
 *
 */
@Service
public class VocationService {

	@Autowired
	private VocationRepository vocationRep;
	
	public Vocation getVocations(String centerId){
		Vocation vocation=vocationRep.findVocationByCenterId(centerId);
		return vocation;
	}
}
