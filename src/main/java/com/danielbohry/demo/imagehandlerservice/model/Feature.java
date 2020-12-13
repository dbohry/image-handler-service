package com.danielbohry.demo.imagehandlerservice.model;


import java.util.UUID;

public class Feature {

    private UUID id;
    private Long timestamp;
    private Long beginViewingDate;
    private Long endViewingDate;
    private String missionName;

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

    public Long getBeginViewingDate() {
        return beginViewingDate;
    }

    public void setBeginViewingDate(Long beginViewingDate) {
        this.beginViewingDate = beginViewingDate;
    }

    public Long getEndViewingDate() {
        return endViewingDate;
    }

    public void setEndViewingDate(Long endViewingDate) {
        this.endViewingDate = endViewingDate;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }
}
