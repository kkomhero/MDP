package com.mbg.otdev.esDemo.dao;

import com.mbg.otdev.esDemo.model.FaceMerge;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaceMergeRepository extends ElasticsearchRepository<FaceMerge, Integer> {

    //List<Face> findByActorid(Integer actorid);

}


//https://kimseunghyun76.tistory.com/444