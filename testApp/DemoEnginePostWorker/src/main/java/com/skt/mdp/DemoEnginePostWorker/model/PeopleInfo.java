package com.skt.mdp.DemoEnginePostWorker.model;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

/**
 * 등장인물정보
 */
@ApiModel(description = "등장인물정보")

public class PeopleInfo   {
  @JsonProperty("prs_id")
  private String prsId = null;

  @JsonProperty("brth_ymd")
  private String brthYmd = null;

  @JsonProperty("prs_nm")
  private String prsNm = null;

  @JsonProperty("sex_cd")
  private String sexCd = null;

  @JsonProperty("prs_role_cd")
  private String prsRoleCd = null;

  @JsonProperty("sort_seq")
  private BigDecimal sortSeq = null;

  @JsonProperty("filmography")
  @Valid
  private List<String> filmography = null;

  public PeopleInfo prsId(String prsId) {
    this.prsId = prsId;
    return this;
  }

  

    /**
     * @return String return the prsId
     */
    public String getPrsId() {
        return prsId;
    }

    /**
     * @param prsId the prsId to set
     */
    public void setPrsId(String prsId) {
        this.prsId = prsId;
    }

    /**
     * @return String return the brthYmd
     */
    public String getBrthYmd() {
        return brthYmd;
    }

    /**
     * @param brthYmd the brthYmd to set
     */
    public void setBrthYmd(String brthYmd) {
        this.brthYmd = brthYmd;
    }

    /**
     * @return String return the prsNm
     */
    public String getPrsNm() {
        return prsNm;
    }

    /**
     * @param prsNm the prsNm to set
     */
    public void setPrsNm(String prsNm) {
        this.prsNm = prsNm;
    }

    /**
     * @return String return the sexCd
     */
    public String getSexCd() {
        return sexCd;
    }

    /**
     * @param sexCd the sexCd to set
     */
    public void setSexCd(String sexCd) {
        this.sexCd = sexCd;
    }

    /**
     * @return String return the prsRoleCd
     */
    public String getPrsRoleCd() {
        return prsRoleCd;
    }

    /**
     * @param prsRoleCd the prsRoleCd to set
     */
    public void setPrsRoleCd(String prsRoleCd) {
        this.prsRoleCd = prsRoleCd;
    }

    /**
     * @return BigDecimal return the sortSeq
     */
    public BigDecimal getSortSeq() {
        return sortSeq;
    }

    /**
     * @param sortSeq the sortSeq to set
     */
    public void setSortSeq(BigDecimal sortSeq) {
        this.sortSeq = sortSeq;
    }

    /**
     * @return List<String> return the filmography
     */
    public List<String> getFilmography() {
        return filmography;
    }

    /**
     * @param filmography the filmography to set
     */
    public void setFilmography(List<String> filmography) {
        this.filmography = filmography;
    }

}

