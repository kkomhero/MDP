package com.skt.mdp.FacePostExecutorSim.service;

import java.util.List;

import com.skt.mdp.FacePostExecutorSim.model.FaceRaw;

public interface FaceRawService {

    List<FaceRaw> getAll();
    FaceRaw create(FaceRaw faceraw);
    List<FaceRaw> getActorByActorId(Integer actorid);
}
