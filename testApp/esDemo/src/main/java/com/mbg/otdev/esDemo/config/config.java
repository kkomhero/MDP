package com.mbg.otdev.esDemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class config {

    @Value("${config.saveIndexName}")
    private String saveIndexName;

    @Value("${config.faceindexName}")
    private String faceindexName;

    @Value("${config.facemergeindexName}")
    private String facemergeindexName;

    @Value("${config.musicindexName}")
    private String musicindexName;

    @Value("${config.musicmergeindexName}")
    private String musicmergeindexName;

    public String getSaveIndexName() {
        return saveIndexName;
    }

    public void setSaveIndexName(String saveIndexName) {
        this.saveIndexName = saveIndexName;
    }

    public String getFaceindexName() {
        return faceindexName;
    }

    public void setFaceindexName(String faceindexName) {
        this.faceindexName = faceindexName;
    }

    public String getFacemergeindexName() {
        return facemergeindexName;
    }

    public void setFacemergeindexName(String facemergeindexName) {
        this.facemergeindexName = facemergeindexName;
    }

    public String getMusicindexName() {
        return musicindexName;
    }

    public void setMusicindexName(String musicindexName) {
        this.musicindexName = musicindexName;
    }

    public String getMusicmergeindexName() {
        return musicmergeindexName;
    }

    public void setMusicmergeindexName(String musicmergeindexName) {
        this.musicmergeindexName = musicmergeindexName;
    }
}

//  musicindexName: mymusicraw
//          musicmergeindexName: mymusicmerge