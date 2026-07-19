package com.rohit.JobApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.JobApp.model.JobPost;

@Service
public class JobService {
	
	@Autowired
	private JobService service;
	
	public void addJob(JobPost jobPost) {
		service.addJob(jobPost);
	}
	
	public List<JobPost> getAllJobs() {
		return service.getAllJobs();
	}
	
}
