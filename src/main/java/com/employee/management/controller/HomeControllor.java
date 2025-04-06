package com.employee.management.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class HomeControllor {
	
	@GetMapping("/")
    public String showHomePage() {
        return "index"; 
    }
	
}
