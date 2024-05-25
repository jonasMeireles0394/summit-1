package org.uniube.summit.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.uniube.summit.repositories.entities.EventImageEntity;
import org.uniube.summit.repositories.entities.ImageEntity;

import java.util.List;

public interface EventImageRepositoryJPA extends JpaRepository<EventImageEntity, Long>{

    @Query("select ei from EventImageEntity ei where ei.eventid = ?1")
    public List<EventImageEntity> findByEventId(Long eventId);
}
