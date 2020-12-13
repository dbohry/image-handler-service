package com.danielbohry.demo.imagehandlerservice.repository;

import com.danielbohry.demo.imagehandlerservice.exception.NotFoundException;
import com.danielbohry.demo.imagehandlerservice.model.Feature;
import com.danielbohry.demo.imagehandlerservice.repository.entities.FeatureCollectionEntity;
import com.danielbohry.demo.imagehandlerservice.repository.entities.FeatureEntity;
import com.danielbohry.demo.imagehandlerservice.repository.entities.PropertyEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Repository
public class FeatureRepository {

    private static final String RESOURCE = "src/main/resources/data.json";
    private static List<PropertyEntity> features;

    public FeatureRepository(ObjectMapper objectMapper) throws IOException {
        List<FeatureCollectionEntity> featureCollection = objectMapper.readValue(new File(RESOURCE), new TypeReference<>() {
        });

        features = featureCollection.stream()
                .map(features -> features.getFeatures().get(0))
                .map(features -> objectMapper.convertValue(features, FeatureEntity.class))
                .map(features -> objectMapper.convertValue(features.getProperties(), PropertyEntity.class))
                .collect(toList());
    }

    public List<Feature> getAll() {
        return features.stream()
                .map(PropertyEntity::fromEntity)
                .collect(toList());
    }

    public Feature find(UUID id) throws NotFoundException {
        return features.stream()
                .filter(entity -> entity.getId().equals(id))
                .map(PropertyEntity::fromEntity)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    public String findQuicklook(UUID id) throws NotFoundException {
        PropertyEntity properties = features.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);

        return properties.getQuicklook();
    }

}
