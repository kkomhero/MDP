package com.mbg.otdev.esDemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "#{config.facemergeindexName}", type = "facemerge")
public class FaceMerge {

    @Id
    private int mergefaceid;

    private int videoid;

    private int actorid;

    private String jobid;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="HH:mm:ss;SS", timezone = "GMT+8")
    private Date starttimecode;     //(00:18:22;06)

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="HH:mm:ss;SS", timezone = "GMT+8")
    private Date endtimecode;

    private int  startframeindex;
    private int endframeindex;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyyMMddHHmmss", timezone = "GMT+8")
    private Date createtime;    //(20190621151601) yyyymmddhhmmss

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyyMMddHHmmss", timezone = "GMT+8")
    private Date modifytime;    // (20190621151601) yyyymmddhhmmss

    private int keyframeindex;

    public int getMergefaceid() {
        return mergefaceid;
    }

    public void setMergefaceid(int mergefaceid) {
        this.mergefaceid = mergefaceid;
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    public int getActorid() {
        return actorid;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public Date getStarttimecode() {
        return starttimecode;
    }

    public void setStarttimecode(Date starttimecode) {
        this.starttimecode = starttimecode;
    }

    public Date getEndtimecode() {
        return endtimecode;
    }

    public void setEndtimecode(Date endtimecode) {
        this.endtimecode = endtimecode;
    }

    public int getStartframeindex() {
        return startframeindex;
    }

    public void setStartframeindex(int startframeindex) {
        this.startframeindex = startframeindex;
    }

    public int getEndframeindex() {
        return endframeindex;
    }

    public void setEndframeindex(int endframeindex) {
        this.endframeindex = endframeindex;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public int getKeyframeindex() {
        return keyframeindex;
    }

    public void setKeyframeindex(int keyframeindex) {
        this.keyframeindex = keyframeindex;
    }
}
