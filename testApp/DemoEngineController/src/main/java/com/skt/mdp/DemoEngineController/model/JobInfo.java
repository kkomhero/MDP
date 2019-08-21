package com.skt.mdp.DemoEngineController.model;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * JobInfo
 */
public class JobInfo   {
  @JsonProperty("service_id")
  private String serviceId = null;

  @JsonProperty("epsd_id")
  private String epsdId = null;

  @JsonProperty("episode_info")
  private EpisodeInfo episodeInfo = null;

  @JsonProperty("meta_info")
  private MetaInfo metaInfo = null;

  public JobInfo serviceId(String serviceId) {
    this.serviceId = serviceId;
    return this;
  }

  
  

    /**
     * @return String return the serviceId
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId the serviceId to set
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return String return the epsdId
     */
    public String getEpsdId() {
        return epsdId;
    }

    /**
     * @param epsdId the epsdId to set
     */
    public void setEpsdId(String epsdId) {
        this.epsdId = epsdId;
    }

    /**
     * @return EpisodeInfo return the episodeInfo
     */
    public EpisodeInfo getEpisodeInfo() {
        return episodeInfo;
    }

    /**
     * @param episodeInfo the episodeInfo to set
     */
    public void setEpisodeInfo(EpisodeInfo episodeInfo) {
        this.episodeInfo = episodeInfo;
    }

    /**
     * @return MetaInfo return the metaInfo
     */
    public MetaInfo getMetaInfo() {
        return metaInfo;
    }

    /**
     * @param metaInfo the metaInfo to set
     */
    public void setMetaInfo(MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }

}

