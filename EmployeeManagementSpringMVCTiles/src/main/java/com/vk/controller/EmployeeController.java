package com.vk.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.vk.model.PersonLeave;
import com.vk.model.Person;
import com.vk.service.PersonLeaveService;
import com.vk.service.PersonService;



@Controller
public class EmployeeController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonLeaveService personLeaveService;
	
	@RequestMapping(value="/login_adm",method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		if(username.equals("Vishal") && password.equals("123456"))
		{
			return "redirect:/persons";
		}
		return "errorAdmin";
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		//model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	

	@RequestMapping(value="/showAddForm",method=RequestMethod.GET)
	public String addNewPerson(Model model)
	{
		model.addAttribute("person", new Person());
		return "addPerson";
	}

	
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@Valid @ModelAttribute("person") Person p,BindingResult result){
		if(result.hasErrors())
		{
			return "addPerson";
		}
		      if(p.getId() == 0){
		    	this.personService.addPerson(p);
		         }
		       return "redirect:/persons";
	}
	
	@RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person",personService.getPersonById(id));
      //  model.addAttribute("listPersons",personService.listPersons());
        return "updatePerson";
    }
	
	@RequestMapping(value= "/person/update", method = RequestMethod.POST)
	public String editPerson(@Valid @ModelAttribute("person") Person p,BindingResult result){
		if(result.hasErrors())
		{
			return "updatePerson";
		}
		
		if(p.getId() != 0){
			this.personService.updatePerson(p);
		}
		return "redirect:/persons";
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
	
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String home(HttpServletResponse response) {
		return "redirect:/";
	}
	
	@RequestMapping("viewEmpProfileById")
    public String viewEmpP(){
       return "enterID";
    }
	
	
	@RequestMapping(value="/getEmpByID",method=RequestMethod.POST)
    public String getPeron(@RequestParam("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
     return "viewEmpProfile";
    }
	
	@RequestMapping(value = "/leaves", method = RequestMethod.GET)
	public String listPersonsLeave(Model model) {
		model.addAttribute("personLeave", new PersonLeave());
		model.addAttribute("listPersonsLeaves", this.personLeaveService.listPersonsLeaves());
		return "leave";
	}
	
	@RequestMapping("/leaveApprove/{lid}")
    public String mailPersonApprove(@PathVariable("lid") int lid, Model model){
        model.addAttribute("personLeave", this.personLeaveService.getPersonLeaveById(lid));
        model.addAttribute("listPersonsLeave", this.personLeaveService.listPersonsLeaves());
        this.personLeaveService.removePersonLeave(lid);

        return "sendApproveEmailPerson";
    }
    @RequestMapping("/leaveReject/{lid}")
    public String mailPersonReject(@PathVariable("lid") int lid, Model model){
        model.addAttribute("personLeave", this.personLeaveService.getPersonLeaveById(lid));
        model.addAttribute("listPersonsLeave", this.personLeaveService.listPersonsLeaves());
        this.personLeaveService.removePersonLeave(lid);
        return "sendRejectEmailPerson";
    }
	
	
	
	@RequestMapping(value="/login_emp",method = RequestMethod.POST)
    public String login(@RequestParam("email") String email,@RequestParam("password") String password, Model model){
		Person p = personService.getPersonDetailsByEmailAndPassword(email, password);
		
		if(p != null)
		{
			model.addAttribute("person",p);
			return "employee_homepage";
		}
		
        return "errorUser";
        
    }
	
	@RequestMapping(value="/leave_apply/{id}",method=RequestMethod.GET)
	public String addNewPersonLeave(@ModelAttribute("personLeave") PersonLeave pl,@PathVariable("id") int id,Model model)
	{
		 model.addAttribute("person",personService.getPersonById(id));
		return "leave_application";
	}
	
	
	@RequestMapping(value="/leave_applied",method=RequestMethod.POST)
	public String addPersonLeave(@ModelAttribute("personLeave") PersonLeave personLeave,Model model)
	{
		personLeaveService.addPersonLeave(personLeave);
		model.addAttribute("person", personService.getPersonById(Integer.parseInt(personLeave.getEid()))) ;
		return "employee_homepage";
	}
	
	@RequestMapping(value="/viewMyProfile/{id}")
	public String viewEmployeePage(@PathVariable("id") int id, Model model)
	{
		
	  model.addAttribute("person", this.personService.getPersonById(id));
		return "employee_homepage";
	}
	
	  @RequestMapping("/mail/{id}")
	    public String mailPerson(@PathVariable("id") int id, Model model){
	        model.addAttribute("person", this.personService.getPersonById(id));
	        model.addAttribute("listPersons", this.personService.listPersons());
	        return "sendEmailPerson";
	    }
	
	  
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/sendEmail",method=RequestMethod.POST)
	public String doSendEmail(HttpServletRequest request) {
		// takes input from e-mail form
		String recipientAddress = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		// sends the e-mail
		mailSender.send(email);
		

		// forwards to the view named "Result"
		return "mailSent";
	}
	
	@RequestMapping(value="/sendRejectEmail",method=RequestMethod.POST)
	public String doSendRejectEmail(HttpServletRequest request) {
		// takes input from e-mail form
		String recipientAddress = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		// sends the e-mail
		mailSender.send(email);

		// forwards to the view named "Result"
		return "mailSentReject";
	}
	@RequestMapping(value="/sendApproveEmail",method=RequestMethod.POST)
	public String doSendApproveEmail(HttpServletRequest request) {
		// takes input from e-mail form
		String recipientAddress = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		// sends the e-mail
		mailSender.send(email);

		// forwards to the view named "Result"
		return "mailSentApprove";
	}
}
