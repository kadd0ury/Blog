package com.master4.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.master4.entities.Tag;
import com.master4.entities.User;
import com.master4.exceptions.ResourceNotFoundException;
import com.master4.services.ArticleService;
import com.master4.services.UserService;



@Controller
@RequestMapping(value = {"","/user"})
public class UserContoller {
	

	
	@Autowired
	private UserService userservice ;
	
	
    @GetMapping(value = {"/","/page/{id}"})
    public String home(@PathVariable(name="id",required = false) Optional<Integer> id, ModelMap model)
    {
            Page<User> pages = userservice.getAllUsers(id, 1, "id");
            model.addAttribute("pageable", pages);
        return "users/home";
    }

	
	
	   @GetMapping("/add")
	    public String add(ModelMap model,User user) {
		   		List <String>role = new ArrayList <String>();
		   		role.add("Admin");role.add("Visitor");role.add("Writer");
	            model.addAttribute("user", user);
	            model.addAttribute("role",role);
	       return "users/add";
	    }
	
	   @PostMapping("/save")
	    public String saveArticle(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) throws ResourceNotFoundException {
	        if(result.hasErrors()){
	            model.addAttribute("user",user);
	            return "users/add";
	        }
	        userservice.save(user);
	        return "redirect:/user/";
	    }
	   
	   @GetMapping("/add/{id}")
	    public String edit(@PathVariable("id") long id, ModelMap model) throws ResourceNotFoundException {
	   		List <String>role = new ArrayList <String>();
	   		role.add("Admin");role.add("Visitor");role.add("Writer");
	        model.addAttribute("user", userservice.findById(id));
	        model.addAttribute("role",role);
	        return "users/add";
	    }

	   
	    @GetMapping("/delete/{page}/{id}")
	    public String delete(@PathVariable("page") long page,@PathVariable("id") long id, ModelMap model) throws ResourceNotFoundException {
	    	userservice.deleteById(id);
	        return "redirect:/user/page/"+page;
	    }

	
	
	
	
	
	
	
	
	

}
