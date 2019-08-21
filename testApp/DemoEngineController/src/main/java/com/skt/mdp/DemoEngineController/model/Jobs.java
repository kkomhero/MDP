package com.skt.mdp.DemoEngineController.model;

import java.util.List;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class Jobs {
  @JsonProperty("jobs")
  private List<JobInfo> jobs;

  

    /**
     * @return List<JobInfo> return the jobs
     */
    public List<JobInfo> getJobs() {
        return jobs;
    }

    /**
     * @param jobs the jobs to set
     */
    public void setJobs(List<JobInfo> jobs) {
        this.jobs = jobs;
    }

}
