/**
 * 
 */
package com.org.musicAndYouthAttend.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.org.musicAndYouthAttend.form.Roles;

/**
 * @author Music and Youth Organization
 *
 */
public interface RolesRepository extends MongoRepository<Roles, String> {
	public Roles findRolesByRole(String role);
}
