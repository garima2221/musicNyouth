/**
 * 
 */
package com.org.musicAndYouthAttend.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.musicAndYouthAttend.service.VocationRepository;
import com.org.musicAndYouthAttend.form.Vocation;

/**
 * @author Music and Youth Organization
 *
 */
public class VocationService {

	@Autowired
	private VocationRepository vocationRep;
	
	public List<Vocation>getVocations(String centerId){
		List<Vocation>vocations=vocationRep.findVocationByCenterId(centerId);
		return vocations;
	}
}
