package com.danielbohry.demo.imagehandlerservice.service;

import com.danielbohry.demo.imagehandlerservice.exception.NotFoundException;
import com.danielbohry.demo.imagehandlerservice.model.Feature;
import com.danielbohry.demo.imagehandlerservice.repository.FeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FeatureService {

    private final FeatureRepository repository;

    public FeatureService(FeatureRepository repository) {
        this.repository = repository;
    }

    public List<Feature> findAll() {
        return repository.getAll();
    }

    public Feature find(UUID id) throws NotFoundException {
        return repository.find(id);
    }

    public String findQuicklook(UUID id) throws NotFoundException {
        return repository.findQuicklook(id);
    }

}
