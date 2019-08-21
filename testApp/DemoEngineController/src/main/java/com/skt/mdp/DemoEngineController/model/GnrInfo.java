package com.skt.mdp.DemoEngineController.model;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 장르정보
 */
@ApiModel(description = "장르정보")
public class GnrInfo   {
  @JsonProperty("gnr_id")
  private String gnrId = null;

  @JsonProperty("meta_gnr_nm")
  private String metaGnrNm = null;

  @JsonProperty("rep_gnr_yn")
  private String repGnrYn = null;

  public GnrInfo gnrId(String gnrId) {
    this.gnrId = gnrId;
    return this;
  }

    /**
     * @return String return the gnrId
     */
    public String getGnrId() {
        return gnrId;
    }

    /**
     * @param gnrId the gnrId to set
     */
    public void setGnrId(String gnrId) {
        this.gnrId = gnrId;
    }

    /**
     * @return String return the metaGnrNm
     */
    public String getMetaGnrNm() {
        return metaGnrNm;
    }

    /**
     * @param metaGnrNm the metaGnrNm to set
     */
    public void setMetaGnrNm(String metaGnrNm) {
        this.metaGnrNm = metaGnrNm;
    }

    /**
     * @return String return the repGnrYn
     */
    public String getRepGnrYn() {
        return repGnrYn;
    }

    /**
     * @param repGnrYn the repGnrYn to set
     */
    public void setRepGnrYn(String repGnrYn) {
        this.repGnrYn = repGnrYn;
    }

}

