package com.rohit.JobApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rohit.JobApp.model.JobPost;
import com.rohit.JobApp.repo.JobRepo;
import com.rohit.JobApp.service.JobService;

@Controller
public class JobController {
	
	@Autowired
	private JobRepo service;
	
	@GetMapping({"/", "home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("addjob")
	public String addJob() {
		return "addjob";
	}
	
	@PostMapping("handleForm")
	public String handleForm(JobPost jobPost) {
		service.addJob(jobPost);
		return "success";
	}

}      
