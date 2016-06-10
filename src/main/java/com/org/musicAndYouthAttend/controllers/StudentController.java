/**
 * 
 */
package com.org.musicAndYouthAttend.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.musicAndYouthAttend.Helper.StudentHelper;
import com.org.musicAndYouthAttend.form.Student;
import com.org.musicAndYouthAttend.response.StudentRegistrationResponse;
import com.org.musicAndYouthAttend.serviceImpl.StudentService;



/**
 * Student Controller services all Student related actions.
 * 
 * @author Music and Youth Organization
 *
 */
@Controller

public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentHelper helper; 
	
	//for setting "" to null
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	/**
	 * Method to go to the Student data input page.
	 * 
	 * @param model
	 * @return view
	 */
	@RequestMapping(value="/saveStudent", method=RequestMethod.GET)
	public String getStudentData(Model model,HttpServletResponse response){
		response.addCookie(new Cookie("CenterId", "MAS"));
		model.addAttribute("student",new Student());
		
		return "studentData";
	}
	
	
	/**
	 * Responds to register student request.
	 * 
	 * @param student
	 * @param bindingResult
	 * @param model
	 * @return view
	 */
	@RequestMapping(value="/saveStudent", method=RequestMethod.POST)
	public String saveStudent(@Valid Student student,BindingResult bindingResult, Model model, 
			@CookieValue(value = "CenterId", defaultValue = "BOS") String centerId) {

		if (bindingResult.hasErrors()) {
			return "studentData";
		}
		String studentId;
		String studentName;
		StudentRegistrationResponse srr = new StudentRegistrationResponse();
		student.setCenterId(centerId);
		if (student.getMiddleName() != null) {
			studentId = student.getFirstName() + student.getLastName() + student.getMiddleName()
					+ student.getCenterId();
			studentName= student.getFirstName() +' '+student.getMiddleName()+' '+ student.getLastName();
		} else {
			studentId = student.getFirstName() + student.getLastName() + student.getCenterId();
			studentName= student.getFirstName() +' '+ student.getLastName();
		}
		Student duplicateStudent = studentService.findStudent(studentId);
		if (duplicateStudent != null) {
			LocalDate dateOfBirth = helper.getDate(student);

			if (duplicateStudent.getDateOfBirth().equals(dateOfBirth)) {
				srr.setResponseCode(100);
				srr.setResponseMessage("Duplicate Record, Please enter middle name");
				model.addAttribute("errorCodes", srr);
				model.addAttribute("student", student);
				return "studentData";
			}
		}
		student.setStudentId(studentId);
		student.setStudentName(studentName);
		// Setting userId and password same as studentId, which is first
		// name+last name+middle name(if not null)+centerId
		student.setUserId(studentId);
		student.setPassword(studentId);
		//student.deleteAll();
		Student studentSaved = studentService.studentSave(student);

		if (studentSaved == null) {
			srr.setResponseCode(500);
			srr.setResponseMessage("Save Failed");
			model.addAttribute("errorCodes", srr);
			model.addAttribute("student", studentSaved);
			return "studentData";
		}
		srr.setResponseCode(HttpStatus.OK.value());
		srr.setResponseMessage("Save Successful");
		model.addAttribute("errorCodes", srr);
		model.addAttribute("student", studentSaved);
		System.out.println(studentSaved.toString());
		return "saved";
	}
	
	/**
	 * Controller method that responds to student sign in request.
	 * 
	 * @param model
	 * @param response
	 * @param centerId
	 * @return view
	 */
	@RequestMapping(value="/studentSignIn", method=RequestMethod.GET)
	public String getStudentSignIn(Model model, HttpServletResponse response,
			@CookieValue(value = "CenterId", defaultValue = "BOS") String centerId) {
		model.addAttribute("student", new Student());
		return "studentSignIn";
	}
	
	@RequestMapping(value = "/getTags", method = RequestMethod.GET, produces = "application/json")	
	 public @ResponseBody List<Student> getStudents( @RequestParam String term) {
		
		return simulateSearchResult(term);

	}

	private List<Student> simulateSearchResult(String tagName) {
		List<Student> data=new ArrayList<Student>();
		List<Student> result = new ArrayList<Student>();
		data =studentService.findAllStudent(data) ;
		
		

		// iterate a list and filter by tagName
		for (Student tag : data) {
			if (tag.getFirstName().toLowerCase().contains(tagName) || tag.getLastName().toLowerCase().contains(tagName)
					|| (tag.getMiddleName() != null && tag.getMiddleName().toLowerCase().contains(tagName))) {
				result.add(tag);
			}
		}

		return result;
	}
	
	/**
	 * 
	 * 
	 * @param student
	 * @param bindingResult
	 * @param model
	 * @param centerId
	 * @return
	 */
	@RequestMapping(value="/studentSignInDetails", method=RequestMethod.GET)
	public String getSignInStudent(@Valid Student student,BindingResult bindingResult, Model model, 
			@CookieValue(value = "CenterId", defaultValue = "BOS") String centerId) {
		if (bindingResult.hasErrors()) {
			return "studentSignIn";
		}
		/*student.setCenterId(centerId);
		String studentId;
		studentId=student.getStudentName()+student.getCenterId();
		student =studentService.findStudent(studentId);
		model.addAttribute("student", student);*/
		return "studentSignInDetails";
	}
	
	@RequestMapping(value="/studentSignInDetails", method=RequestMethod.POST)
	public String signInStudent(@Valid Student student,BindingResult bindingResult, Model model, 
			@CookieValue(value = "CenterId", defaultValue = "BOS") String centerId) {
		
		return "studentSignIn";
	}
	
	
}
