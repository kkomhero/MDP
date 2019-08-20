package com.mbg.otdev.esDemo.service;

import com.mbg.otdev.esDemo.dao.MusicMergeRepository;
import com.mbg.otdev.esDemo.model.MusicMerge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicMergeServiceImpl implements MusicMergeService{

    @Autowired
    private MusicMergeRepository repository;

    @Override
    public List<MusicMerge> getAll() {
        return null;
    }

    @Override
    public MusicMerge create(MusicMerge music) {
        return repository.save(music);
    }

}
