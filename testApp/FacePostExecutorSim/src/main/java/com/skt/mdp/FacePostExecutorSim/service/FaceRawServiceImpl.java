package com.skt.mdp.FacePostExecutorSim.service;

import java.util.List;

import com.skt.mdp.FacePostExecutorSim.model.FaceRaw;
import com.skt.mdp.FacePostExecutorSim.repo.FaceRawRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaceRawServiceImpl implements FaceRawService{

    @Autowired
    private FaceRawRepository repository;

    @Override
    public List<FaceRaw> getAll() {
        return null;
    }

    @Override
    public FaceRaw create(FaceRaw face) {
        return repository.save(face);
    }

    @Override
    public List<FaceRaw> getActorByActorId(Integer actorid) {
        return null;
    }
}