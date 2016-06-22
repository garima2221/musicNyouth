/**
 * 
 */
package com.org.musicAndYouthAttend.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.org.musicAndYouthAttend.form.User;

/**
 * Repository for users of Music and Youth Organization application
 * 
 * @author Music and Youth Organization
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
	
	public User findUserByUserIdAndPasswordAndCenterId(String userId,String password, String centerId);
	public User findUserByUserId(String userId);

}
