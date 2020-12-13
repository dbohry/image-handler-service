package com.danielbohry.demo.imagehandlerservice.repository.entities;

import java.util.List;

public class FeatureCollectionEntity {

    private String type;
    private List<Object> features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getFeatures() {
        return features;
    }

    public void setFeatures(List<Object> features) {
        this.features = features;
    }
}
