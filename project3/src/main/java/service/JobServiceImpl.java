package project3.example.project3.service;

import org.springframework.stereotype.Service;
import project3.example.project3.model.Job;
import project3.example.project3.repository.JobRepository;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void saveJob(Job job) {
        jobRepository.save(job);
    }
}