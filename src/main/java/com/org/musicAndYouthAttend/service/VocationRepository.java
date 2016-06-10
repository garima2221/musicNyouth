/**
 * 
 */
package com.org.musicAndYouthAttend.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.org.musicAndYouthAttend.form.Vocation;

/**
 * @author Music and Youth Organization
 *
 */
public interface VocationRepository  extends MongoRepository<Vocation, String> {

	public List<Vocation> findVocationByCenterId(String centerId);
}
