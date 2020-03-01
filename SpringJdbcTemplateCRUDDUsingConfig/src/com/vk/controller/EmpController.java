package com.vk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.vk.model.Emp;
import com.vk.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;
	
	@RequestMapping("/empform")
	public String showform(Model m)
	{
		m.addAttribute("command", new Emp());
		return "empform";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("emp") Emp emp)
	{
		empService.save(emp);
		return "redirect:/viewemp";
	}
	
	@RequestMapping("/viewemp")
	public String viewemp(Model m)
	{
		List<Emp> list = empService.getEmployees();
		m.addAttribute("list", list);
		return "viewemp";
	}
	
	@RequestMapping(value="/editemp/{id}")
	public String edit(@PathVariable int id, Model m)
	{
		Emp emp = empService.getEmpById(id);
		m.addAttribute("command",emp);
		return "empeditform";
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Emp emp){    
		empService.update(emp);    
        return "redirect:/viewemp";    
    }    
	
	 @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
		 empService.delete(id);    
	        return "redirect:/viewemp";    
	    }     
}
