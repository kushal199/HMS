package com.kush.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

//import javax.swing.text.html.HTML;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kush.customRepo.Repo;
import com.kush.modal.Appointment;
import com.kush.modal.Department;
import com.kush.modal.Patient;
import com.kush.modal.User;
import com.kush.repository.UserRepository;
import com.kush.services.UserService;

//@Controller
@RestController
public class ApplicationController {
	@Autowired
	private UserService userService;
	@Autowired
	Repo repo;
	//private final UserRepository userRepo;

	    //@ResponseBody
//		@RequestMapping("/home")
//		public String welcome() {
//			return "come welcome go go";
//		}
	    
	    //@ResponseBody
//		@RequestMapping(method = RequestMethod.GET, value = "/homew")
//	    public String welcome1() {
//			return "cart.html";
//		}
	    @ResponseBody
		@RequestMapping(method = RequestMethod.GET, value = "/come")
		public String welc() {
			return "abcd";
	}
		@RequestMapping("/reg")
		public String welcome(@ModelAttribute("user") User user) {
			return "register";
	}
		@RequestMapping("/login")
		public String welcomelog(@ModelAttribute("user") User user) {
			return "login";
	}
		
//		//@ResponseBody
//		@RequestMapping("/save")
//		//public String register(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("username") String username,@RequestParam("password") String password)
//		public String register(@ModelAttribute("user") User user ,Model m)
//		{
//			//User user = new User(firstname,lastname,username, password);
//			//m.addAttribute("user", user);
//			userService.saveUser(user);
//			User user1 =new User();
//			m.addAttribute("user", user1);
//			return "return_from_success";
//	    }
		
		
		
		
		
		//@ResponseBody
				@RequestMapping(value="/save",method=RequestMethod.POST)
				@CrossOrigin(origins="http://localhost:4200")
				public int register(@RequestBody User user)
				{
					//User user = new User(firstname,lastname,username, password);
					//m.addAttribute("user", user);
					System.out.println(user);
					userService.saveUser(user);
					
//					User user1 =new User();
//					m.addAttribute("user", user1);
					//return "return_from_success";
					return 1;
			    }
		
		
		
		@RequestMapping("/check")
		public String kjkj(){
			userService.check();
			return "kjkj";
			
		}
		
		@RequestMapping("/insert")
		public String k(){
			userService.inse();
			return "kjkj";
			
		}
		
//		@RequestMapping ("/login-user")
//		public String loginUser(@ModelAttribute User user,Model m) {
//			if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
//				//m.addAttribute("users", userService.showAllUsers());
////				List<User> l= new ArrayList<>();
////				l.add(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword()));
////				m.addAttribute("users",l);
//				return "dashboard_adm";
//			}
//			else {
//				m.addAttribute("error", "Invalid Username or Password");
//				//m.addAttribute("mode", "MODE_LOGIN");
//				return "login";
//				
//			}
//		}
		
		
		@RequestMapping (value="/login-user",method=RequestMethod.POST)
		@CrossOrigin(origins="http://localhost:4200")
		public User loginUser(@RequestBody User user) {
			if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
				//m.addAttribute("users", userService.showAllUsers());
//				List<User> l= new ArrayList<>();
//				l.add(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword()));
//				m.addAttribute("users",l);
			//	return "dashboard_adm";
				User user1=new User();
				user1=userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
				return user1;
			}
//			else {
////				m.addAttribute("error", "Invalid Username or Password");
////				//m.addAttribute("mode", "MODE_LOGIN");
////				return "login";
//				return 0;
//				
//			}
			
			return new User();
		}
		
		
		
		@RequestMapping("/edit-user")
		public String editUser(@RequestParam int id,Model m,@RequestParam int idd) {
			User user =(userService.editUser(id)).get();
			System.out.println(idd);
			m.addAttribute("user", user);
			return "Edit";
		}
		
		@RequestMapping(value="/new-user",method=RequestMethod.POST)
		@CrossOrigin(origins="http://localhost:4200")
		public User editUser(@RequestBody int id) {
			User user =(userService.editUser(id)).get();
			//System.out.println(idd);
			//m.addAttribute("user", user);
			return user;
		}
		
		@RequestMapping(value="/new_user",method=RequestMethod.POST)
		@CrossOrigin(origins="http://localhost:4200")
		public User editUserhh(@RequestBody int id) {
			User user =(userService.editUser(id)).get();
			//System.out.println(idd);
			//m.addAttribute("user", user);
			return user;
		}
		
		
		
//		@ResponseBody
//		@RequestMapping("/save-user")
//		public String register(@RequestParam("username") String username,@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("id") String id,@RequestParam("password") String password)
////		public String update(Model m)
//		{
//			User user = new User(firstname,lastname,username,password);
//			//m.addAttribute("user", user);
//			userService.saveUser(user);
//			return "Updated Succesfully";
//	    }
		
//		@RequestMapping("/save-user")
//	public String register(@RequestParam("username") String username,@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("doctor_id") int doctor_id,@RequestParam("password") String password,@Param("dob") String dob,@Param("department_id") int department_id,@Param("address") String address,@Param("email") String email
//			,@Param("active") String active,Model m)
//	//	public String update(Model m)
//	{
//		//User user = new User(firstname,lastname,username,password);
//		//m.addAttribute("user", user);
//		userService.updateu(username,firstname,lastname, password,doctor_id,dob,department_id,address,email,active);
//		m.addAttribute("users", userService.showAllUsers());
//		return "NewFile";
//			
//	    }
		
		
		@RequestMapping(value="/update",method=RequestMethod.POST)
		@CrossOrigin(origins="http://localhost:4200")
		public int register1(@RequestBody User user)
		//	public String update(Model m)
		{
			//User user = new User(firstname,lastname,username,password);
			//m.addAttribute("user", user);
			userService.updateu(user.getUsername(),user.getFirstname(),user.getLastname(), user.getPassword(),user.getDoctor_id(),user.getDob(),user.getDepartment_id(),user.getAddress(),user.getEmail(),user.getActive());
			//m.addAttribute("users", userService.showAllUsers());
			return 1;
				
		    }
		
		
//		@RequestMapping("/delete-user")
//		public String deleteUser(@RequestParam int id, Model m) {
//			userService.deleteMyUser(id);
//			m.addAttribute("users", userService.showAllUsers());
//			
//			return "NewFile";
//		}
		
		
		@RequestMapping(value="/delete-user",method=RequestMethod.POST)
		@CrossOrigin(origins="http://localhost:4200")
		public int deleteUser(@RequestBody int id) {
			userService.deleteMyUser(id);
			//m.addAttribute("users", userService.showAllUsers());
			
			return 1;
		}
		
		
		
		
		@RequestMapping("/landing")
		public String landing(@ModelAttribute("user") User user) {
			return "landing";
	}
		
		@RequestMapping("/dashboard_adm")
		public String dashboard(@ModelAttribute("user") User user) {
			return "dashboard_adm";
	}
		
//		@RequestMapping("/view_doc")
//		public String viewdoc(@ModelAttribute("user") User user,Model m) {
//		
//			m.addAttribute("users", userService.showAllUsers());
//			return "NewFile";
//	}
		
		
		
		@RequestMapping(value="/view_doc",method=RequestMethod.GET)
		@CrossOrigin(origins="http://localhost:4200")
		public List<User> viewdoc() {
		    List<User> list = new ArrayList<User>();
			list= userService.showAllUsers();
			return list;
	}
		
		
//		@RequestMapping("/param")
//		public String kjkjk(){
//			int id=1;
//			List<Object> list = new ArrayList<>();
//			list= repo.abc(id);
//			//userService.check();
//			return "kjkj";
//			
//		}
		
		
		//for patient
		
		
		@RequestMapping("/patient_landing")
		public String patient_landing(@ModelAttribute("patient") Patient patient) {
			return "patient_landing";
	}
		
		@RequestMapping("/patient_registration")
		public String patient_registration(@ModelAttribute("patient") Patient patient) {
			return "patient_registration";
	}
		
		
		
		
		
		
		@RequestMapping("/patient_login")
		public String patient_login(@ModelAttribute("patient") Patient patient) {
			return "patient_login";
	}
		
		
		
//		@RequestMapping ("/login_patient")
//		public String login_patient(@ModelAttribute Patient patient,Model m) {
//			if(userService.findByUsernameAndPassword_patient(patient.getUsername(), patient.getPassword())!=null) {
//				//m.addAttribute("users", userService.showAllUsers());
////				List<User> l= new ArrayList<>();
////				l.add(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword()));
////				m.addAttribute("users",l);
//				Patient patientm = new Patient();
//				patientm=userService.findByUsernameAndPassword_patient(patient.getUsername(), patient.getPassword());
//				m.addAttribute("patientm",patientm);
//				//m.addAttribute("users", userService.showAllUsers());
//				System.out.println(userService.showAllDepartments());
//				m.addAttribute("departments",userService.showAllDepartments());
//				return "departments";
//			}
//			else {
//				m.addAttribute("error", "Invalid Username or Password");
//				//m.addAttribute("mode", "MODE_LOGIN");
//				return "patient_login";
//				
//			}
//		}
		
		
		
		
		
		
	
		
		
		
		
		
//		@RequestMapping("/doctorfordep")
//		public String viewdocfordep(@ModelAttribute("user") User user,Model m,@RequestParam int id) {
//			m.addAttribute("users", userService.showAllDocforDep(id));
//			m.addAttribute("patient_id",idd);
//			System.out.println(userService.showAllDocforDep(id));
//			return "patient_doctor";
//	}
		
		
		
		@RequestMapping("/book_appointment")
		public String appointment_form(@ModelAttribute("appointment") Appointment appointment,Model m,@RequestParam int id,
				@RequestParam int idd) {
			m.addAttribute("doctor_id",id);
			m.addAttribute("patient_id",idd);
			
			return "apointment";
	}
		
//		@RequestMapping("/save_appointment")
//		public String appointment_save(@ModelAttribute("appointment") Appointment appointment,Model m,@RequestParam int id,
//				@RequestParam int idd,@RequestParam("datetime") Date datetime,@RequestParam("description") String description) {
////			m.addAttribute("doctor_id",id);
////			m.addAttribute("patient_id",idd);
//			Patient patientm=new Patient();
//			 patientm =(userService.singlePatient(idd)).get();
//			m.addAttribute("patientm",patientm);
//			
//			Appointment appointment1=new Appointment(id,idd,datetime,"",description,"");
//			userService.saveAppointment(appointment1);
//			m.addAttribute("departments",userService.showAllDepartments());
//			return "departments";
//			
//			
//			//return "";
//	}
		
		
		
		
		
		
		
//		@RequestMapping("/appointments")
//		public String showAppointments(@ModelAttribute("appointment") Appointment appointment,Model m,@RequestParam int id) {
//			Patient patientm=new Patient();
//			 patientm =(userService.singlePatient(id)).get();
//			m.addAttribute("patientm",patientm);
//			
//			m.addAttribute("users",userService.showAllAppointforPatient(id));
//			return "appointments";
//	}
		
	
		
		
		
		
		@RequestMapping("/feedback_push")
		public String feedback_form(@ModelAttribute("appointment") Appointment appointment,Model m,@RequestParam int id,@RequestParam int idd
				) {
			m.addAttribute("appointment_id",id);
			m.addAttribute("patient_id",idd);
			
			
			return "feedback_form";
	}
		
//		@RequestMapping(value="/update_feedback" ,method = RequestMethod.POST)
//		public String feedback_push(@ModelAttribute("appointment") Appointment appointment,Model m,@RequestParam("id") int id,
//				@RequestParam("feedback") String feedback,@RequestParam("idd") int idd) {
//			//m.addAttribute("appointment_id",id);
//			//m.addAttribute("patient_id",idd);
//			
//			
//			userService.update_feedback(feedback, id);
//			Patient patientm=new Patient();
//			 patientm =(userService.singlePatient(idd)).get();
//			m.addAttribute("patientm",patientm);
//			m.addAttribute("departments",userService.showAllDepartments());
//			return "departments";
//	}
		
		
			
		
		
	
		
		
		
		
		@RequestMapping("/logout")
		public String patient_logout(@ModelAttribute("patient") Patient patient) {
			return "patient_login";
	}
		
		
}



	

	

