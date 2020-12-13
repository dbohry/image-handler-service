package com.danielbohry.demo.imagehandlerservice.repository.entities;

import com.danielbohry.demo.imagehandlerservice.model.Feature;

import java.util.UUID;

public class PropertyEntity {

    private UUID id;
    private Long timestamp;
    private AcquisitionEntity acquisition;
    private String quicklook;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public AcquisitionEntity getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(AcquisitionEntity acquisition) {
        this.acquisition = acquisition;
    }

    public String getQuicklook() {
        return quicklook;
    }

    public void setQuicklook(String quicklook) {
        this.quicklook = quicklook;
    }

    public static Feature fromEntity(PropertyEntity entity) {
        Feature feature = new Feature();

        feature.setId(entity.getId());
        feature.setTimestamp(entity.getTimestamp());

        if (entity.getAcquisition() != null) {
            feature.setBeginViewingDate(entity.getAcquisition().getBeginViewingDate());
            feature.setEndViewingDate(entity.getAcquisition().getEndViewingDate());
            feature.setMissionName(entity.getAcquisition().getMission());
        }

        return feature;
    }

}
