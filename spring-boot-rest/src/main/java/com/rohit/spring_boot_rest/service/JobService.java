package com.rohit.spring_boot_rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.spring_boot_rest.model.JobPost;
import com.rohit.spring_boot_rest.repo.JobRepo;

import java.util.List;

@Service
public class JobService {
	
	public final JobRepo repo;

    JobService(JobRepo repo) {
        this.repo = repo;
    }

    // method to add a jobPost
    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    //method to return all JobPosts
    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }
}
