package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.model.Family_Members;
import com.sample.service.FamilyService;

@Controller
public class FamilyController {
	
	@Autowired
	FamilyService service;
	
	@RequestMapping("/familyform")    
    public String showform(Model m){    
        m.addAttribute("command", new Family_Members());  
        return "familyform";   
    }
	
	@RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("f") Family_Members f){    
		service.save(f);    
        return "redirect:/viewfamily";//will redirect to viewemp request mapping    
    }    
	
	@RequestMapping("/viewfamily")
	public String viewFamily(Model m) {
		List<Family_Members> list = service.getListAllMembers();
		System.out.println("Total  : " + list.size());
	/*	for (Family_Members family_Members : list) {
			System.out.println(family_Members.getName());
		}*/
		m.addAttribute("familyMembers", list);
		return "viewfamily";
	}
	
	  @RequestMapping(value="/editfamily/{id}")    
	    public String edit(@PathVariable int id, Model m){    
	        Family_Members f=service.getFamilyById(id);
	        System.out.println("editmetod" +f.getF_name());
	        m.addAttribute("command",f);  
	        return "familyeditform";    
	    } 
	  
	  @RequestMapping(value="/editsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("f") Family_Members f){    
	        service.update(f);    
	        return "redirect:/viewfamily";    
	    }
	  
	  @RequestMapping(value="/deletefamily/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	        service.delete(id);    
	        return "redirect:/viewfamily";    
	    }     

}
