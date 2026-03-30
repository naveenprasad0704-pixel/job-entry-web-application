package project3.example.project3.service;

import project3.example.project3.model.Job;
import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    void saveJob(Job job);
}