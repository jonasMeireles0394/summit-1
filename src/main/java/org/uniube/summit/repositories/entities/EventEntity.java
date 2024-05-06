package org.uniube.summit.repositories.entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name = "event_seq", sequenceName = "event_seq", allocationSize=1)
    private Long id;

    private Long categoryid;

    private Long eventaddressid;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date initialdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    private String observation;
    private String status;

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

    public Long getEventaddressid() {
        return eventaddressid;
    }

    public void setEventaddressid(Long eventaddressid) {
        this.eventaddressid = eventaddressid;
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

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", categoryid=" + categoryid +
                ", eventaddressid=" + eventaddressid +
                ", name='" + name + '\'' +
                ", initialdate=" + initialdate +
                ", enddate=" + enddate +
                ", observation='" + observation + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
