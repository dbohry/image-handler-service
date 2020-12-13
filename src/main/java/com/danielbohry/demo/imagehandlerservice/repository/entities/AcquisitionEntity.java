package com.danielbohry.demo.imagehandlerservice.repository.entities;

public class AcquisitionEntity {

    private String mission;
    private Long beginViewingDate;
    private Long endViewingDate;

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
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
}
