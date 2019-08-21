package com.skt.mdp.DemoEnginePostWorker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * EpisodeInfo
 */
public class EpisodeInfo   {
  @JsonProperty("asis_cnts_id")
  private String asisCntsId = null;

  @JsonProperty("file_path_url")
  private String filePathUrl = null;

  @JsonProperty("rslu_file_nm")
  private String rsluFileNm = null;

  @JsonProperty("sris_id")
  private String srisId = null;

  @JsonProperty("sris_nm")
  private String srisNm = null;

  @JsonProperty("play_tms_val")
  private BigDecimal playTmsVal = null;

  public EpisodeInfo asisCntsId(String asisCntsId) {
    this.asisCntsId = asisCntsId;
    return this;
  }
    /**
     * @return String return the asisCntsId
     */
    public String getAsisCntsId() {
        return asisCntsId;
    }

    /**
     * @param asisCntsId the asisCntsId to set
     */
    public void setAsisCntsId(String asisCntsId) {
        this.asisCntsId = asisCntsId;
    }

    /**
     * @return String return the filePathUrl
     */
    public String getFilePathUrl() {
        return filePathUrl;
    }

    /**
     * @param filePathUrl the filePathUrl to set
     */
    public void setFilePathUrl(String filePathUrl) {
        this.filePathUrl = filePathUrl;
    }

    /**
     * @return String return the rsluFileNm
     */
    public String getRsluFileNm() {
        return rsluFileNm;
    }

    /**
     * @param rsluFileNm the rsluFileNm to set
     */
    public void setRsluFileNm(String rsluFileNm) {
        this.rsluFileNm = rsluFileNm;
    }

    /**
     * @return String return the srisId
     */
    public String getSrisId() {
        return srisId;
    }

    /**
     * @param srisId the srisId to set
     */
    public void setSrisId(String srisId) {
        this.srisId = srisId;
    }

    /**
     * @return String return the srisNm
     */
    public String getSrisNm() {
        return srisNm;
    }

    /**
     * @param srisNm the srisNm to set
     */
    public void setSrisNm(String srisNm) {
        this.srisNm = srisNm;
    }

    /**
     * @return BigDecimal return the playTmsVal
     */
    public BigDecimal getPlayTmsVal() {
        return playTmsVal;
    }

    /**
     * @param playTmsVal the playTmsVal to set
     */
    public void setPlayTmsVal(BigDecimal playTmsVal) {
        this.playTmsVal = playTmsVal;
    }

}

