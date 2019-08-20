package com.mbg.otdev.esDemo.service;

import com.mbg.otdev.esDemo.dao.FaceMergeRepository;
import com.mbg.otdev.esDemo.dao.FaceRepository;
import com.mbg.otdev.esDemo.model.Face;
import com.mbg.otdev.esDemo.model.FaceMerge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaceMergeServiceImpl implements FaceMergeService{

    @Autowired
    private FaceMergeRepository repository;

    @Override
    public List<FaceMerge> getAll() {
        return null;
    }

    @Override
    public FaceMerge create(FaceMerge facemerge) {
        return repository.save(facemerge);
    }

//    @Override
//    public List<Face> getActorByActorId(Integer actorid) {
//        return null;
//    }
}
