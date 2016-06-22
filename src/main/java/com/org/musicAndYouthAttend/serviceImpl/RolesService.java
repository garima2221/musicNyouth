/**
 * 
 */
package com.org.musicAndYouthAttend.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.musicAndYouthAttend.form.Roles;
import com.org.musicAndYouthAttend.service.RolesRepository;

/**
 * @author Music and Youth Organization
 *
 */
@Service
public class RolesService {
	
	@Autowired
	private RolesRepository rolesRep;
	
	/**
	 * Gets the access list for a given role.
	 * 
	 * @param roleId
	 * @return
	 */
	public Roles getRole(String roleId){
		Roles role=rolesRep.findRolesByRole(roleId);
		return role;
	}

}
