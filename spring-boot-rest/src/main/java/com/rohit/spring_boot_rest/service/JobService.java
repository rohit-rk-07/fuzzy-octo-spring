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
    
    //method to get job on specific id
	public JobPost getJob(int postId) {
		
		return repo.getJob(postId);
	}

	//method to update the job 
	public void updateJob(JobPost jobPost) {
		
		repo.updateJob(jobPost);
	}

	//method to delete the job
	public void deleteJob(int postId) {
		repo.deleteJob(postId);
		
	}
}
