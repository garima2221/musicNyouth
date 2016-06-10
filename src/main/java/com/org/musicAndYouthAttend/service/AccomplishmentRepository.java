/**
 * 
 */
package com.org.musicAndYouthAttend.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.org.musicAndYouthAttend.form.Accomplishment;

/**
 * @author Music and Youth Organization
 *
 */
public interface AccomplishmentRepository extends MongoRepository<Accomplishment,String>{
	public List<Accomplishment> findAccomplishmentByStudentId(String studentId);

}
