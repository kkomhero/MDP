package com.mbg.otdev.esDemo.service;

import com.mbg.otdev.esDemo.model.Face;
import com.mbg.otdev.esDemo.model.FaceMerge;

import java.util.List;

public interface FaceMergeService {

    List<FaceMerge> getAll();
    FaceMerge create(FaceMerge facemerge);
    //List<FaceMerge> getActorByActorId(Integer actorid);
}
