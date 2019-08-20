package com.mbg.otdev.esDemo.dao;

import com.mbg.otdev.esDemo.model.Face;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaceRepository extends ElasticsearchRepository<Face, Integer> {

    List<Face> findByActorid(Integer actorid);

}


//https://kimseunghyun76.tistory.com/444