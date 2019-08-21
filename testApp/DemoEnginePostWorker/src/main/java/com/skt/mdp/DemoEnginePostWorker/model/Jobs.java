package com.skt.mdp.DemoEnginePostWorker.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

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
