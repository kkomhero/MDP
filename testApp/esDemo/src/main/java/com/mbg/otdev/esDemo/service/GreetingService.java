package com.mbg.otdev.esDemo.service;

import com.mbg.otdev.esDemo.model.Greeting;

import java.util.List;
import java.util.Optional;

public interface GreetingService {
    List<Greeting> getAll();
    Optional<Greeting> findOne(String id);
    Greeting create(Greeting greeting);
    Greeting update(Greeting greeting);
    List<Greeting> getGreetingByUsername(String username);
    void delete(String id);
}
