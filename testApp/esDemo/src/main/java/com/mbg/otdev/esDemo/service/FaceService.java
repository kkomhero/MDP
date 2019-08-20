package com.mbg.otdev.esDemo.service;

import com.mbg.otdev.esDemo.model.Face;

import java.util.List;

public interface FaceService {

    List<Face> getAll();
    Face create(Face greeting);
    List<Face> getActorByActorId(Integer actorid);
}
