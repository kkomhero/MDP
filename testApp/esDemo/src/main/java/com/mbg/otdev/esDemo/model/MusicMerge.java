package com.mbg.otdev.esDemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

//@Document(indexName = "#{config.musicmergeindexName}", type = "musicmerge")
public class MusicMerge {

    @Id
    private int musicid;

    private int videoid;

    private String jobid;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="HH:mm:ss;SS", timezone = "GMT+8")
    private Date starttimecode; // (00:18:22;06) HH:mm:ss;SS

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="HH:mm:ss;SS", timezone = "GMT+8")
    private Date endtimecode;    // (00:18:22;06) HH:mm:ss;SS

    private int startframeindex;
    private int endframeindex;
    private int sequence;

    private String album_packagelanguage;
    private String album_titleofficial;
    private String album_year;
    private String album_genrelevel1;
    private String album_genrelevel2;
    private String album_genrelevel3;
    private String album_albumlabel;
    private int album_totalinset;
    private int album_discinset;
    private int album_trackcount;
    private String album_coverarturl;
    private String album_track_trackgnid;
    private int album_track_tracknumber;
    private String album_track_titleofficial;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyyMMddHHmmss", timezone = "GMT+8")
    private Date createtime; // (20190621151601) yyyyMMddHHmmss

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyyMMddHHmmss", timezone = "GMT+8")
    private Date modifytime; // (20190621151601) yyyyMMddHHmmss

    private String album_credit_nameofficial;
    private String album_credit_originlevel1;
    private String album_credit_originlevel2;
    private String album_credit_originlevel3;
    private String album_credit_originlevel4;
    private String album_credit_eralevel1;
    private String album_credit_eralevel2;
    private String album_credit_eralevel3;
    private String album_credit_artisttypelevel1;
    private String album_credit_artisttypelevel2;
    private int isduplication;

    public int getMusicid() {
        return musicid;
    }

    public void setMusicid(int musicid) {
        this.musicid = musicid;
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
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

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getAlbum_packagelanguage() {
        return album_packagelanguage;
    }

    public void setAlbum_packagelanguage(String album_packagelanguage) {
        this.album_packagelanguage = album_packagelanguage;
    }

    public String getAlbum_titleofficial() {
        return album_titleofficial;
    }

    public void setAlbum_titleofficial(String album_titleofficial) {
        this.album_titleofficial = album_titleofficial;
    }

    public String getAlbum_year() {
        return album_year;
    }

    public void setAlbum_year(String album_year) {
        this.album_year = album_year;
    }

    public String getAlbum_genrelevel1() {
        return album_genrelevel1;
    }

    public void setAlbum_genrelevel1(String album_genrelevel1) {
        this.album_genrelevel1 = album_genrelevel1;
    }

    public String getAlbum_genrelevel2() {
        return album_genrelevel2;
    }

    public void setAlbum_genrelevel2(String album_genrelevel2) {
        this.album_genrelevel2 = album_genrelevel2;
    }

    public String getAlbum_genrelevel3() {
        return album_genrelevel3;
    }

    public void setAlbum_genrelevel3(String album_genrelevel3) {
        this.album_genrelevel3 = album_genrelevel3;
    }

    public String getAlbum_albumlabel() {
        return album_albumlabel;
    }

    public void setAlbum_albumlabel(String album_albumlabel) {
        this.album_albumlabel = album_albumlabel;
    }

    public int getAlbum_totalinset() {
        return album_totalinset;
    }

    public void setAlbum_totalinset(int album_totalinset) {
        this.album_totalinset = album_totalinset;
    }

    public int getAlbum_discinset() {
        return album_discinset;
    }

    public void setAlbum_discinset(int album_discinset) {
        this.album_discinset = album_discinset;
    }

    public int getAlbum_trackcount() {
        return album_trackcount;
    }

    public void setAlbum_trackcount(int album_trackcount) {
        this.album_trackcount = album_trackcount;
    }

    public String getAlbum_coverarturl() {
        return album_coverarturl;
    }

    public void setAlbum_coverarturl(String album_coverarturl) {
        this.album_coverarturl = album_coverarturl;
    }

    public String getAlbum_track_trackgnid() {
        return album_track_trackgnid;
    }

    public void setAlbum_track_trackgnid(String album_track_trackgnid) {
        this.album_track_trackgnid = album_track_trackgnid;
    }

    public int getAlbum_track_tracknumber() {
        return album_track_tracknumber;
    }

    public void setAlbum_track_tracknumber(int album_track_tracknumber) {
        this.album_track_tracknumber = album_track_tracknumber;
    }

    public String getAlbum_track_titleofficial() {
        return album_track_titleofficial;
    }

    public void setAlbum_track_titleofficial(String album_track_titleofficial) {
        this.album_track_titleofficial = album_track_titleofficial;
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

    public String getAlbum_credit_nameofficial() {
        return album_credit_nameofficial;
    }

    public void setAlbum_credit_nameofficial(String album_credit_nameofficial) {
        this.album_credit_nameofficial = album_credit_nameofficial;
    }

    public String getAlbum_credit_originlevel1() {
        return album_credit_originlevel1;
    }

    public void setAlbum_credit_originlevel1(String album_credit_originlevel1) {
        this.album_credit_originlevel1 = album_credit_originlevel1;
    }

    public String getAlbum_credit_originlevel2() {
        return album_credit_originlevel2;
    }

    public void setAlbum_credit_originlevel2(String album_credit_originlevel2) {
        this.album_credit_originlevel2 = album_credit_originlevel2;
    }

    public String getAlbum_credit_originlevel3() {
        return album_credit_originlevel3;
    }

    public void setAlbum_credit_originlevel3(String album_credit_originlevel3) {
        this.album_credit_originlevel3 = album_credit_originlevel3;
    }

    public String getAlbum_credit_originlevel4() {
        return album_credit_originlevel4;
    }

    public void setAlbum_credit_originlevel4(String album_credit_originlevel4) {
        this.album_credit_originlevel4 = album_credit_originlevel4;
    }

    public String getAlbum_credit_eralevel1() {
        return album_credit_eralevel1;
    }

    public void setAlbum_credit_eralevel1(String album_credit_eralevel1) {
        this.album_credit_eralevel1 = album_credit_eralevel1;
    }

    public String getAlbum_credit_eralevel2() {
        return album_credit_eralevel2;
    }

    public void setAlbum_credit_eralevel2(String album_credit_eralevel2) {
        this.album_credit_eralevel2 = album_credit_eralevel2;
    }

    public String getAlbum_credit_eralevel3() {
        return album_credit_eralevel3;
    }

    public void setAlbum_credit_eralevel3(String album_credit_eralevel3) {
        this.album_credit_eralevel3 = album_credit_eralevel3;
    }

    public String getAlbum_credit_artisttypelevel1() {
        return album_credit_artisttypelevel1;
    }

    public void setAlbum_credit_artisttypelevel1(String album_credit_artisttypelevel1) {
        this.album_credit_artisttypelevel1 = album_credit_artisttypelevel1;
    }

    public String getAlbum_credit_artisttypelevel2() {
        return album_credit_artisttypelevel2;
    }

    public void setAlbum_credit_artisttypelevel2(String album_credit_artisttypelevel2) {
        this.album_credit_artisttypelevel2 = album_credit_artisttypelevel2;
    }

    public int getIsduplication() {
        return isduplication;
    }

    public void setIsduplication(int isduplication) {
        this.isduplication = isduplication;
    }
}
