package com.skt.mdp.FacePostExecutorSim.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.skt.mdp.FacePostExecutorSim.model.FaceRaw;

@Repository
public interface FaceRawRepository extends ElasticsearchRepository<FaceRaw, Integer> {

    List<FaceRaw> findByActorid(Integer actorid);

}