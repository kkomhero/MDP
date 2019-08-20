package com.mbg.otdev.esDemo.service;

import com.mbg.otdev.esDemo.dao.FaceRepository;
import com.mbg.otdev.esDemo.model.Face;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaceServiceImpl implements FaceService{

    @Autowired
    private FaceRepository repository;

    @Override
    public List<Face> getAll() {
        return null;
    }

    @Override
    public Face create(Face face) {
        return repository.save(face);
    }

    @Override
    public List<Face> getActorByActorId(Integer actorid) {
        return null;
    }
}
