/**
 * 
 */
package com.org.musicAndYouthAttend.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.musicAndYouthAttend.form.User;
import com.org.musicAndYouthAttend.service.UserRepository;

/**
 * @author Music and Youth Organization
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRep;
	
	/**
	 * Service for authorizing user
	 * 
	 * @param userId
	 * @param password
	 * @param centerId
	 * @return user
	 */
	public User findUser(String userId,String password,String centerId){
		
		User user=userRep.findUserByUserIdAndPasswordAndCenterId(userId, password, centerId);
		return user;
	}
	
	/**
	 * Service to get User when the user has been authorized
	 * 
	 * @param userId
	 * @return user
	 */
	public User findUser(String userId){
		
		User user=userRep.findUserByUserId(userId);
		return user;
	}
	
	/**
	 * @return no. of documents in collection for setting up id
	 */
	public Integer getCount(){
		Integer cnt=(int)(long) userRep.count();
		return cnt;
	}

}