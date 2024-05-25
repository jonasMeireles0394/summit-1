package org.uniube.summit.repositories.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "eventimage")
public class EventImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eventimage_seq")
    @SequenceGenerator(name = "eventimage_seq", sequenceName = "eventimage_seq", allocationSize=1)
    private Long id;
    private Long eventid;
    private Long imageid;

    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    public Long getImageid() {
        return imageid;
    }

    public void setImageid(Long imageid) {
        this.imageid = imageid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
