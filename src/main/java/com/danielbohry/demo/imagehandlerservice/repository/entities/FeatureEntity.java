package com.danielbohry.demo.imagehandlerservice.repository.entities;

import java.util.ArrayList;
import java.util.HashMap;

public class FeatureEntity {

    private String type;
    private ArrayList<String> bbox;
    private HashMap geometry;
    private HashMap properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getBbox() {
        return bbox;
    }

    public void setBbox(ArrayList<String> bbox) {
        this.bbox = bbox;
    }

    public HashMap getGeometry() {
        return geometry;
    }

    public void setGeometry(HashMap geometry) {
        this.geometry = geometry;
    }

    public HashMap getProperties() {
        return properties;
    }

    public void setProperties(HashMap properties) {
        this.properties = properties;
    }

}
