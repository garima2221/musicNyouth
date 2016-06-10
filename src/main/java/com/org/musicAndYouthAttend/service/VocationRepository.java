/**
 * 
 */
package com.org.musicAndYouthAttend.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.org.musicAndYouthAttend.form.Vocation;

/**
 * @author Music and Youth Organization
 *
 */
public interface VocationRepository  extends MongoRepository<Vocation, String> {

	public Vocation findVocationByCenterId(String centerId);
}
