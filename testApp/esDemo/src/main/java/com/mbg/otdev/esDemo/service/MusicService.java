package com.mbg.otdev.esDemo.service;

import com.mbg.otdev.esDemo.model.Music;

import java.util.List;

public interface MusicService {

    List<Music> getAll();
    Music create(Music music);
    //List<Face> getActorByActorId(Integer actorid);
}
