/**
 * 
 */
package com.org.musicAndYouthAttend.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.musicAndYouthAttend.form.Roles;
import com.org.musicAndYouthAttend.form.User;
import com.org.musicAndYouthAttend.response.UserAuthorizationResponse;
import com.org.musicAndYouthAttend.serviceImpl.RolesService;
import com.org.musicAndYouthAttend.serviceImpl.UserService;

/**
 * User controller responds to all user related actions
 * 
 * @author Music and Youth Organization
 *
 */

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RolesService rolesService;
	
	//for setting "" to null
		@InitBinder
		public void initBinder(WebDataBinder binder) {
		    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		}
		
		/**
		 * Gets user sign in page
		 * 
		 * @param model
		 * @param response
		 * @return view
		 */
		@RequestMapping(value="/signIn", method=RequestMethod.GET)
		public String getUserSignIn(Model model,HttpServletResponse response){
			//TODO take center Id from response
			response.addCookie(new Cookie("CenterId", "MAS"));
			model.addAttribute("user",new User());
			return "user";
		}
		
		/**
		 * Checks for valid user and if valid gets the access page
		 * @param user
		 * @param bindingResult
		 * @param model
		 * @param centerId
		 * @return
		 */
		@RequestMapping(value="/signIn", method=RequestMethod.POST)
		public String getAccess(User user,Model model,HttpServletResponse response, 
			@CookieValue(value = "CenterId", defaultValue = "BOS") String centerId){
			user.setCenterId(centerId);
			User authorizedUser=null;
			//Called for the first time , at the time of authorization
		
				UserAuthorizationResponse userResponse=new UserAuthorizationResponse();
				authorizedUser=userService.findUser(user.getUserId(), user.getPassword(), user.getCenterId());
				if(authorizedUser==null){
					userResponse.setResponseCode(100);
					userResponse.setResponseMessage("Invalid userId or password");
					model.addAttribute("user",user);
					return "user";
				}
				//for access from other pages
			response.addCookie(new Cookie("UserId", authorizedUser.getUserId()));
			Roles accessTo=rolesService.getRole(authorizedUser.getRole());
			model.addAttribute("accessTo", accessTo.getAccessTo());
			model.addAttribute("user", authorizedUser);
			return "access";
		}
		
		/**
		 * Controller method called when user already signed in
		 * 
		 * @param user
		 * @param bindingResult
		 * @param model
		 * @param response
		 * @param centerId
		 * @param userId
		 * @return view
		 */
		@RequestMapping(value="/getAccess", method=RequestMethod.GET)
		public String getAccessAfterSignIn(User user,BindingResult bindingResult, Model model,HttpServletResponse response, 
				@CookieValue(value = "CenterId", defaultValue = "BOS") String centerId,@CookieValue(value = "UserId") String userId){
			
				User authorizedUser=userService.findUser(userId);
				Roles accessTo=rolesService.getRole(authorizedUser.getRole());
				model.addAttribute("accessTo", accessTo.getAccessTo());
				model.addAttribute("user", authorizedUser);
				return "access";
			
		}
	

}
