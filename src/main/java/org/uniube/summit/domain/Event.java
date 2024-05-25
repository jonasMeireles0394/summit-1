package org.uniube.summit.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Event {
    private Long id;
    private Long categoryid;
    private EventAddres eventaddress;
    private String name;
    private Date initialdate;
    private Date enddate;
    private String observation;
    private String status;
    private List<Image> images = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public EventAddres getEventaddress() {
        return eventaddress;
    }

    public void setEventaddress(EventAddres eventaddress) {
        this.eventaddress = eventaddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInitialdate() {
        return initialdate;
    }

    public void setInitialdate(Date initialdate) {
        this.initialdate = initialdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
