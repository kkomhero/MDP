package com.skt.mdp.DemoEnginePostWorker.model;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * MetaInfo
 */
public class MetaInfo   {
  @JsonProperty("meta_id")
  private String metaId = null;

  @JsonProperty("meta_typ_cd")
  private String metaTypCd = null;

  @JsonProperty("meta_title")
  private String metaTitle = null;

  @JsonProperty("manufco_nm")
  private String manufcoNm = null;

  @JsonProperty("tot_tseq_ncnt")
  private BigDecimal totTseqNcnt = null;

  @JsonProperty("brcast_tseq_nm")
  private String brcastTseqNm = null;

  @JsonProperty("brcast_dt")
  private String brcastDt = null;

  @JsonProperty("manuf_yr")
  private String manufYr = null;

  @JsonProperty("sub_title")
  private String subTitle = null;

  @JsonProperty("manuf_country_nm")
  @Valid
  private List<String> manufCountryNm = null;

  @JsonProperty("open_dy")
  private String openDy = null;

  @JsonProperty("wat_lvl_cd")
  private String watLvlCd = null;

  @JsonProperty("gnr_info")
  @Valid
  private List<GnrInfo> gnrInfo = null;

  @JsonProperty("people_info")
  @Valid
  private List<PeopleInfo> peopleInfo = null;

  public MetaInfo metaId(String metaId) {
    this.metaId = metaId;
    return this;
  }
  
  

    /**
     * @return String return the metaId
     */
    public String getMetaId() {
        return metaId;
    }

    /**
     * @param metaId the metaId to set
     */
    public void setMetaId(String metaId) {
        this.metaId = metaId;
    }

    /**
     * @return String return the metaTypCd
     */
    public String getMetaTypCd() {
        return metaTypCd;
    }

    /**
     * @param metaTypCd the metaTypCd to set
     */
    public void setMetaTypCd(String metaTypCd) {
        this.metaTypCd = metaTypCd;
    }

    /**
     * @return String return the metaTitle
     */
    public String getMetaTitle() {
        return metaTitle;
    }

    /**
     * @param metaTitle the metaTitle to set
     */
    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    /**
     * @return String return the manufcoNm
     */
    public String getManufcoNm() {
        return manufcoNm;
    }

    /**
     * @param manufcoNm the manufcoNm to set
     */
    public void setManufcoNm(String manufcoNm) {
        this.manufcoNm = manufcoNm;
    }

    /**
     * @return BigDecimal return the totTseqNcnt
     */
    public BigDecimal getTotTseqNcnt() {
        return totTseqNcnt;
    }

    /**
     * @param totTseqNcnt the totTseqNcnt to set
     */
    public void setTotTseqNcnt(BigDecimal totTseqNcnt) {
        this.totTseqNcnt = totTseqNcnt;
    }

    /**
     * @return String return the brcastTseqNm
     */
    public String getBrcastTseqNm() {
        return brcastTseqNm;
    }

    /**
     * @param brcastTseqNm the brcastTseqNm to set
     */
    public void setBrcastTseqNm(String brcastTseqNm) {
        this.brcastTseqNm = brcastTseqNm;
    }

    /**
     * @return String return the brcastDt
     */
    public String getBrcastDt() {
        return brcastDt;
    }

    /**
     * @param brcastDt the brcastDt to set
     */
    public void setBrcastDt(String brcastDt) {
        this.brcastDt = brcastDt;
    }

    /**
     * @return String return the manufYr
     */
    public String getManufYr() {
        return manufYr;
    }

    /**
     * @param manufYr the manufYr to set
     */
    public void setManufYr(String manufYr) {
        this.manufYr = manufYr;
    }

    /**
     * @return String return the subTitle
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * @param subTitle the subTitle to set
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * @return List<String> return the manufCountryNm
     */
    public List<String> getManufCountryNm() {
        return manufCountryNm;
    }

    /**
     * @param manufCountryNm the manufCountryNm to set
     */
    public void setManufCountryNm(List<String> manufCountryNm) {
        this.manufCountryNm = manufCountryNm;
    }

    /**
     * @return String return the openDy
     */
    public String getOpenDy() {
        return openDy;
    }

    /**
     * @param openDy the openDy to set
     */
    public void setOpenDy(String openDy) {
        this.openDy = openDy;
    }

    /**
     * @return String return the watLvlCd
     */
    public String getWatLvlCd() {
        return watLvlCd;
    }

    /**
     * @param watLvlCd the watLvlCd to set
     */
    public void setWatLvlCd(String watLvlCd) {
        this.watLvlCd = watLvlCd;
    }

    /**
     * @return List<GnrInfo> return the gnrInfo
     */
    public List<GnrInfo> getGnrInfo() {
        return gnrInfo;
    }

    /**
     * @param gnrInfo the gnrInfo to set
     */
    public void setGnrInfo(List<GnrInfo> gnrInfo) {
        this.gnrInfo = gnrInfo;
    }

    /**
     * @return List<PeopleInfo> return the peopleInfo
     */
    public List<PeopleInfo> getPeopleInfo() {
        return peopleInfo;
    }

    /**
     * @param peopleInfo the peopleInfo to set
     */
    public void setPeopleInfo(List<PeopleInfo> peopleInfo) {
        this.peopleInfo = peopleInfo;
    }

}

