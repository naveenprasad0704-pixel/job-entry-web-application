package project3.example.project3.controller;

import org.springframework.web.bind.annotation.*;
import project3.example.project3.model.Job;
import project3.example.project3.service.JobService;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")  // API prefix to avoid conflict with /jobs page
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping
    public void addJob(@RequestBody Job job) {
        jobService.saveJob(job);
    }
}