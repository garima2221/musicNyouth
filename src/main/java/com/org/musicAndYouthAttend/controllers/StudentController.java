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
import com.org.musicAndYouthAttend.form.Accomplishment;
import com.org.musicAndYouthAttend.form.Attendance;
import com.org.musicAndYouthAttend.form.Student;
import com.org.musicAndYouthAttend.form.StudentSignUp;
import com.org.musicAndYouthAttend.form.Vocation;
import com.org.musicAndYouthAttend.response.StudentRegistrationResponse;
import com.org.musicAndYouthAttend.response.StudentSignUpResponse;
import com.org.musicAndYouthAttend.response.SubmitAttendanceResponse;
import com.org.musicAndYouthAttend.serviceImpl.AccomplishmentService;
import com.org.musicAndYouthAttend.serviceImpl.AttendanceService;
import com.org.musicAndYouthAttend.serviceImpl.StudentService;
import com.org.musicAndYouthAttend.serviceImpl.StudentSignUpService;
import com.org.musicAndYouthAttend.serviceImpl.VocationService;



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
	private StudentSignUpService studentSignUpService;
	@Autowired
	private VocationService vocationService;
	@Autowired
	private AccomplishmentService accomplishmentService;
	@Autowired
	private AttendanceService attendanceService;
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
		//TODO remove centerID logic from here and move it to authorization page
		model.addAttribute("student",new Student());
		Vocation vocations=vocationService.getVocations("MAS");
		model.addAttribute("vocations", vocations.getVocations());
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
		student.setStudentId(studentId);
		student.setStudentName(studentName);
		LocalDate dateOfBirth = helper.getDate(student);
		student.setDateOfBirth(dateOfBirth);
		Student duplicateStudent = studentService.findStudent(studentId);
		if (duplicateStudent != null) {
			//LocalDate dateOfBirth = helper.getDate(student);

			//if (duplicateStudent.getDateOfBirth().equals(student.getDateOfBirth())) {
				srr.setResponseCode(100);
				srr.setResponseMessage("Duplicate Record, Please enter middle name");
				model.addAttribute("errorCodes", srr);
				model.addAttribute("student", student);
		/*	}
			else{
				//TODO confirm duplicate logic
				studentName=student.getStudentName()+" "+student.getMonth()+'-'+student.getDay()+'-'+student.getYear();
				student.setStudentName(studentName);
				studentId=student.getStudentName().replaceAll(" ", "")+student.getCenterId();
				student.setStudentId(studentId);
				saveStudent(student, model, srr);
			}*/
			
		}
		else{
					saveStudent(student, model, srr);
					
				}
		Vocation vocations=vocationService.getVocations(centerId);
		model.addAttribute("vocations", vocations.getVocations());
		return "studentData";
	}

	/**
	 * @param student
	 * @param model
	 * @param studentId
	 * @param studentName
	 * @param srr
	 */
	private void saveStudent(Student student, Model model, StudentRegistrationResponse srr) {
		
		// Setting userId and password same as studentId, which is first
		// name+last name+middle name(if not null)+centerId
		student.setUserId(student.getStudentId());
		student.setPassword(student.getStudentId());
		//student.deleteAll();
		Student studentSaved = studentService.studentSave(student);

		if (studentSaved == null) {
			srr.setResponseCode(500);
			srr.setResponseMessage("Save Failed");
			model.addAttribute("errorCodes", srr);
			model.addAttribute("student", studentSaved);
			
		}
		else{
			srr.setResponseCode(HttpStatus.OK.value());
			srr.setResponseMessage("Save Successful");
			model.addAttribute("errorCodes", srr);
			model.addAttribute("student", studentSaved);
			System.out.println(studentSaved.toString());
		}
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
	
	/**
	 * Controller method to get students for autocomplete search box.
	 * 
	 * @param term
	 * @return
	 */
	@RequestMapping(value = "/getTags", method = RequestMethod.GET, produces = "application/json")	
	 public @ResponseBody List<Student> getStudents( @RequestParam String term) {
		
		return simulateSearchResult(term);

	}

	/**
	 * Gets the students which match the criteria for autocomplete search box
	 * 
	 * @param tagName
	 * @return list of students
	 */
	private List<Student> simulateSearchResult(String tagName) {
		List<Student> data=new ArrayList<Student>();
		List<Student> result = new ArrayList<Student>();
		data =studentService.findAllStudent(data) ;
		
		// iterate a list and filter by tagName
		for (Student tag : data) {
			if (tag.getStudentName().toLowerCase().contains(tagName)) {
				result.add(tag);
			}
		}

		return result;
	}
	
	/**
	 * Gets the sign up page for the student 
	 * 
	 * @param student
	 * @param bindingResult
	 * @param model
	 * @param centerId
	 * @return view
	 */
	@RequestMapping(value="/studentSignInDetails", method=RequestMethod.GET)
	public String getSignInStudent(Student student,BindingResult bindingResult, Model model, 
			@CookieValue(value = "CenterId", defaultValue = "BOS") String centerId) {
		
		StudentSignUpResponse signUpResponse=new StudentSignUpResponse();
		if(student.getStudentName()==null){
			signUpResponse.setResponseCode(300);
			signUpResponse.setResponseMessage("please enter the student");
			model.addAttribute("errorCodes", signUpResponse);
			model.addAttribute("student", student);
			return "studentSignIn";
		}
		student.setCenterId(centerId);
		String studentId;
		String stdName=student.getStudentName();
		stdName=stdName.replaceAll(" ", "");
		studentId=stdName+student.getCenterId();
		Student studentPresent =studentService.findStudent(studentId);
		
		if(studentPresent==null){
			signUpResponse.setResponseCode(100);
			signUpResponse.setResponseMessage("No Student By this name present at this center");
			model.addAttribute("errorCodes", signUpResponse);
			model.addAttribute("student", student);
			return "studentSignIn";
		}
		Vocation vocations=vocationService.getVocations(centerId);
		model.addAttribute("vocations", vocations.getVocations());
		//TODO add side pane for accomplishments
		List<Accomplishment>accomplishments=accomplishmentService.getAccomplishments(studentId);
		model.addAttribute("accomplishments", accomplishments);
		model.addAttribute("student", student);
		StudentSignUp signUp=new StudentSignUp();
		signUp.setStudentId(studentId);
		model.addAttribute("studentSignUp", signUp);
		return "studentSignInDetails";
	}
	
	/**
	 * Signs up the student for interested classes
	 * 
	 * @param student
	 * @param bindingResult
	 * @param model
	 * @param centerId
	 * @return
	 */
	@RequestMapping(value="/studentSignInDetails", method=RequestMethod.POST)
	public String signInStudent(@Valid StudentSignUp studentSignUp,BindingResult bindingResult, Model model, 
			@CookieValue(value = "CenterId", defaultValue = "BOS") String centerId) {
		
		if (bindingResult.hasErrors()) {
			return "studentSignInDetails";
		}
		StudentSignUpResponse signUpResponse=new StudentSignUpResponse();
		StudentSignUp alreadySignUp=studentSignUpService.getSignUpForToday(LocalDate.now(), studentSignUp.getStudentId());
		StudentSignUp confirmSignUp=null;
		//update record if already signed up for the day
		if(alreadySignUp!=null){
			studentSignUp.set_id(alreadySignUp.get_id());
			studentSignUp.setDate(alreadySignUp.getDate());
			confirmSignUp=studentSignUpService.signUpUpdate(studentSignUp);
		}
		else{
			Integer id=studentSignUpService.getCount()+1;
			studentSignUp.set_id(id);
			studentSignUp.setDate(LocalDate.now());
			confirmSignUp=studentSignUpService.signUpSave(studentSignUp);
		}
		
		if(confirmSignUp==null){
			signUpResponse.setResponseCode(500);
			signUpResponse.setResponseMessage("Error in signing up. Please try again later");
		}
		else{
			signUpResponse.setResponseCode(HttpStatus.OK.value());
			signUpResponse.setResponseMessage("Sign up successful");
		}
		model.addAttribute("errorCodes", signUpResponse);
		Student student =studentService.findStudent(studentSignUp.getStudentId());
		model.addAttribute("student", student);
		Vocation vocations=vocationService.getVocations(centerId);
		model.addAttribute("vocations", vocations.getVocations());
		List<Accomplishment>accomplishments=accomplishmentService.getAccomplishments(studentSignUp.getStudentId());
		model.addAttribute("accomplishments", accomplishments);
		return "studentSignInDetails";
	}
	
	
	/**
	 * Controller method which displays the attendance page to user
	 * 
	 * @param model
	 * @param response
	 * @param centerId
	 * @return view
	 */
	@RequestMapping(value="/getAttendence", method=RequestMethod.GET)
	public String getAttendance(Model model, HttpServletResponse response,
			@CookieValue(value = "CenterId", defaultValue = "BOS") String centerId) {
		model.addAttribute("attendance",new Attendance());
		Vocation vocations=vocationService.getVocations(centerId);
		model.addAttribute("vocations", vocations.getVocations());
		return "attendance";
	}
	
	/**
	 * Controller method to submit the attendance for a vocation
	 * 
	 * @param attendance
	 * @param bindingResult
	 * @param model
	 * @param centerId
	 * @return
	 */
	@RequestMapping(value="/submitAttendence", method=RequestMethod.POST)
	public String submitAttendance(Attendance attendance,BindingResult bindingResult, Model model, 
			@CookieValue(value = "CenterId", defaultValue = "BOS") String centerId) {
		
		SubmitAttendanceResponse response=new SubmitAttendanceResponse();
		
		if(attendance.getVocation()==null){
			response.setResponseCode(600);
			response.setResponseMessage("Please select the Vocation");
			model.addAttribute("attendance",attendance);
			Vocation vocations=vocationService.getVocations(centerId);
			model.addAttribute("vocations", vocations.getVocations());
			return "attendance";
		}
		if(attendance.getStudentIds()==null||attendance.getStudentIds().isEmpty()){
			response.setResponseCode(700);
			response.setResponseMessage("Please select the students");
			model.addAttribute("attendance",attendance);
			Vocation vocations=vocationService.getVocations(centerId);
			model.addAttribute("vocations", vocations.getVocations());
			return "attendance";
		}
		//TODO get studentIds
		attendance.setCenterId(centerId);
		LocalDate date=helper.getDate(attendance);
		attendance.setAttendanceDate(date);
		Attendance alreadyPresent=attendanceService.getAttendance(attendance);
		Attendance confirmSubmit= null;
		//Update attendance if already present
		if(alreadyPresent!=null){
			attendance.set_id(alreadyPresent.get_id());
			attendance.setModifiedOn(LocalDate.now());
			confirmSubmit= attendanceService.updateAttendance(attendance);
		}
		else{
			Integer id=attendanceService.getCount()+1;
			attendance.set_id(id);
			attendance.setModifiedOn(LocalDate.now());
			confirmSubmit= attendanceService.submitAttendance(attendance);
		}
		
		if(confirmSubmit==null){
			response.setResponseCode(500);
			response.setResponseMessage("Some problem occured, please try later");
			model.addAttribute("attendance",attendance);
		}
		else{
			response.setResponseCode(HttpStatus.OK.value());
			response.setResponseMessage("Attendance submitted successfully");
		}
		Vocation vocations=vocationService.getVocations(centerId);
		model.addAttribute("vocations", vocations.getVocations());
		return "attendance";
	}
	
}
