package com.mbg.otdev.esDemo.service;

import com.mbg.otdev.esDemo.model.MusicMerge;

import java.util.List;

public interface MusicMergeService {

    List<MusicMerge> getAll();
    MusicMerge create(MusicMerge music);
    //List<Face> getActorByActorId(Integer actorid);
}
