package com.skt.mdp.FacePostExecutorSim.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "#{runConfig.facerawindexName}", type = "faceraw")
//@Document(indexName = "mdp_my_raw_face", type = "faceraw")
public class FaceRaw {
    @Id
    //@Field( type = FieldType.Integer)
    private int faceid;

    //@Field( type = FieldType.Keyword)
    private String jobid;

    //@Field( type = FieldType.Integer)
    private int videoid;

    //@Field( type = FieldType.Integer)
    private int frameindex;

    //@Field( type = FieldType.Float)
    private float score;

    //@Field( type = FieldType.Integer)
    private int rectx;

    //@Field( type = FieldType.Integer)
    private int recty;

    //@Field( type = FieldType.Integer)
    private int rectw;

    //@Field( type = FieldType.Integer)
    private int recth;

    //@Field( type = FieldType.Integer)
    private int actorid;

    public int getFaceid() {
        return faceid;
    }

    public void setFaceid(int faceid) {
        this.faceid = faceid;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    public int getFrameindex() {
        return frameindex;
    }

    public void setFrameindex(int frameindex) {
        this.frameindex = frameindex;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getRectx() {
        return rectx;
    }

    public void setRectx(int rectx) {
        this.rectx = rectx;
    }

    public int getRecty() {
        return recty;
    }

    public void setRecty(int recty) {
        this.recty = recty;
    }

    public int getRectw() {
        return rectw;
    }

    public void setRectw(int rectw) {
        this.rectw = rectw;
    }

    public int getRecth() {
        return recth;
    }

    public void setRecth(int recth) {
        this.recth = recth;
    }

    public int getActorid() {
        return actorid;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }
}