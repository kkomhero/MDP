package com.mbg.otdev.esDemo.dao;

import com.mbg.otdev.esDemo.model.Greeting;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public interface GreetingRepository extends ElasticsearchRepository<Greeting, String> {
public interface GreetingRepository  {
    List<Greeting> findByUsername(String username);
}
